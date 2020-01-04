package com.example.walk_in_clinic;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ServicePage extends AppCompatActivity {

    //Defining all variables
    private EditText serviceName,appTime,serviceType,hour,worker;
    private TextView errorMessage;
    private Button doneEdit,delete,back;
    private Intent intent;
    private Services service,originalService;
    private MyDBHandler dbHandler;
    private boolean isChanged;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.service_edit);

        //Initializing all variables
        serviceName = findViewById(R.id.Name);
        appTime = findViewById(R.id.Time);
        hour = findViewById(R.id.Hour);
        serviceType = findViewById(R.id.Type);
        worker = findViewById(R.id.Employee);
        errorMessage = findViewById(R.id.Errors);

        //setting edit button to false to begin with
        doneEdit = findViewById(R.id.Completed);
        doneEdit.setEnabled(false);

        delete = findViewById(R.id.Delete);

        back = findViewById(R.id.Back);

        //Initializing intent value and getting data passed by source activity
        intent = getIntent();

        //Storing information in two objects, an original one, and an editable one
        originalService = (Services) intent.getSerializableExtra("profile");

        service = (Services) intent.getSerializableExtra("profile");


        //Setting EditText values
        serviceName.setText(service.getServicesName());
        appTime.setText(String.valueOf(service.getAppointmentTime()));
        hour.setText(String.valueOf(service.getHour()));
        serviceType.setText(service.getType());

        //Initializing the DB Handler
        dbHandler =  new MyDBHandler(this);

        //Adding a textwatcher to the EdtiTexts
        serviceName.addTextChangedListener(watcher);
        appTime.addTextChangedListener(watcher);
        hour.addTextChangedListener(watcher);
        serviceType.addTextChangedListener(watcher);
        worker.addTextChangedListener(watcher);

    }

    //TextWatcher used to detect changes in EditText fields
    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        //Checks if the values have changed, if so it updates the editable Service and enables the complete button
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if(!nameNotEqual()){
                service.setServicesName(serviceName.getText().toString());
                doneEdit.setEnabled(true);
                return;
            }
            else if(!timeNotEqual()){
                service.setAppointmentTime(Float.parseFloat(appTime.getText().toString()));
                doneEdit.setEnabled(true);
                return;
            }
            else if(!hourNotEqual()){
                service.setHour(Float.parseFloat(hour.getText().toString()));
                doneEdit.setEnabled(true);
                return;
            }
            else if(!typeNotEqual()){
                service.setType(serviceType.getText().toString());
                doneEdit.setEnabled(true);
                return;
            }
            else{
                doneEdit.setEnabled(false);
            }

        }
    };

    //Boolean methods to check if any of the values have changed from their original ones
    public boolean nameNotEqual(){
        return(!serviceName.getText().toString().equals(originalService.getServicesName())) ? true:false;
    }

    public boolean timeNotEqual(){
        return(!appTime.getText().toString().equals(String.valueOf(originalService.getAppointmentTime()))) ? true:false;
    }

    public boolean hourNotEqual(){
        return(!hour.getText().toString().equals(String.valueOf(originalService.getHour()))) ? true:false;
    }

    public boolean typeNotEqual(){
        return(!serviceType.getText().toString().equals(originalService.getType())) ? true:false;
    }

    //Method called on click of complete button
    //Updates the entry in the database and returns the new object to previous activity
    public void editService(View view){

        //Creating a writable database and string to store arguments in
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        String SQL;

        //Checks if each field has been edited on click
        //If true an argument is created to update that aspect
        if(nameNotEqual()){
            String name = serviceName.getText().toString();
            SQL = "UPDATE services SET servicesname = \"" + name +"\"" + " WHERE servicesname = \"" + originalService.getServicesName() + "\"";
            db.execSQL(SQL);
            isChanged = true;
        }
        else if(timeNotEqual()){
            Float time = service.getAppointmentTime();
            SQL = "UPDATE TABLE_Service SET appointment = \"" + time + "\"" + " WHERE appointment = \"" + originalService.getAppointmentTime() + "\"";
            db.execSQL(SQL);
            isChanged = true;
        }
        else if(hourNotEqual()){
            Float hour = service.getHour();
            SQL = "UPDATE TABLE_Service SET hours  = \"" + hour  + "\"" + " WHERE hours = \"" + originalService.getHour() + "\"";
            db.execSQL(SQL);
            isChanged = true;
        }
        else if(typeNotEqual()){
            String type = service.getType();
            SQL = "UPDATE TABLE_Service SET types = \"" + type + "\"" + " WHERE types = \"" + originalService.getType() + "\"";
            db.execSQL(SQL);
            isChanged = true;
        }
        //Sets error message if the button is somehow enabled when EditTexts are not different from original values
        else{
           errorMessage.setText("Error: Service not changed");
           isChanged = false;
        }

        db.close();

        //If the values are changed create a new return intent and return to the source activity
        if(isChanged){
            intent = new Intent();
            intent.putExtra("return",service);
            setResult(RESULT_OK,intent);
            finish();
        }

    }

    //Method called when delete button is clicked
    public void deleteService(View view){

        //Checks if the defined service is valid, if so deletes it from the database and returns to the original activity
        if(dbHandler.searchservices(service.getServicesName()) != null){
            dbHandler.deleteservices(service.getServicesName());
            intent = new Intent();
            setResult(RESULT_OK,intent);
            finish();
        }

        else{
            errorMessage.setText("Error: service not found in database, please return to previous page.");
        }

    }

    //Method called when back button is clicked
    //Returns to the source activity, returning the original clinic in the process
    public void serviceReturn(View view){
        intent = new Intent();
        intent.putExtra("return",originalService);
        setResult(RESULT_OK,intent);
        finish();
    }
}
