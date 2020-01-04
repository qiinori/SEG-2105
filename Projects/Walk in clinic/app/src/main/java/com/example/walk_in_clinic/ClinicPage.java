package com.example.walk_in_clinic;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ClinicPage extends AppCompatActivity {

    //Defining all pieces of the activity as well as database, 2 clinic objects (for storage), an intent for getting and sending information, and a boolean
    private EditText compName,compDesc,compAddress, errorMessage;
    private Button completeButton, deleteButton, returnButton;
    private Clinic clinic,originalClinic;
    private MyDBHandler dbHandler;
    private Intent intent;
    private boolean isChanged;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.clinic_edit);

        //Setting values and adding textwatchers to the edittexts
        compName = findViewById(R.id.CompName);
        compName.addTextChangedListener(watcher);

        compDesc = findViewById(R.id.CompDesc);
        compDesc.addTextChangedListener(watcher);

        compAddress = findViewById(R.id.CompAddress);
        compAddress.addTextChangedListener(watcher);

        //Setting values for buttons and setting the button pressed when done editing to false
        completeButton = findViewById(R.id.Complete);
        completeButton.setEnabled(false);

        deleteButton = findViewById(R.id.Delete);

        returnButton = findViewById(R.id.Return);

        //Getting intent from source activity and storing the information in two objects (an editable one and a source one)
        intent = getIntent();

        originalClinic = (Clinic) intent.getSerializableExtra("clinic");
        clinic = (Clinic) intent.getSerializableExtra("clinic");

        isChanged = false;

        //Setting values of edittexts to start with and instantiating the dbHandler
        compName.setText(clinic.getCompanyName());
        compDesc.setText(clinic.getDescription());
        compAddress.setText(clinic.getAddress());

        dbHandler = new MyDBHandler(this);
    }

    //Textwatcher to check text changed in any of the EditTexts
    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //Checks if any values have changed, if so update the editable clinic and enable the edit complete button
            if(nameNotEqual()){
                clinic.setCompanyName(compName.getText().toString());
                completeButton.setEnabled(true);
                return;
            }
            else if(descNotEqual()){
                clinic.setDescription((compDesc.getText().toString()));
                completeButton.setEnabled(true);
                return;
            }
            else if(addressNotEqual()){
                clinic.setAddress(compAddress.getText().toString());
                completeButton.setEnabled(true);
                return;
            }
            else{
                completeButton.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    //Methods to return boolean values for each of the fields
    public boolean nameNotEqual(){
        return(!compName.getText().toString().equals(originalClinic.getCompanyName())) ? true:false;
    }

    public boolean descNotEqual(){
        return(!compDesc.getText().toString().equals(originalClinic.getDescription())) ? true:false;
    }

    public boolean addressNotEqual(){
        return(!compAddress.getText().toString().equals(originalClinic.getAddress())) ? true:false;
    }


    //Method called on click of complete button
    //Updates the entry in the database and returns the new object to previous activity
    public void editReturn(){

        //Creating a writable database and string to store arguments in
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        String SQL;

        //Checks if each field has been edited on click
        //If true an argument is created to update that aspect
        if(nameNotEqual()){
            String name = clinic.getCompanyName();
            SQL = "UPDATE TABLE_Clinic SET COLUMN_CNAME = name WHERE columnId = " + originalClinic.getCompanyName();
            db.execSQL(SQL);
            isChanged = true;
            db.close();
        }
        else if(descNotEqual()){
            String desc = clinic.getDescription();
            SQL = "UPDATE TABLE_Clinic SET COLUMN_DESCRIPTION = desc WHERE columnId = " + originalClinic.getDescription();
            db.execSQL(SQL);
            isChanged = true;
            db.close();
        }
        else if(addressNotEqual()){
            String address = clinic.getAddress();
            SQL = "UPDATE TABLE_Clinic SET COLUMN_ADDRESS = address WHERE columnId = " + originalClinic.getAddress();
            db.execSQL(SQL);
            isChanged = true;
            db.close();
        }
        else{
            isChanged = false;
        }

        //If the values are changed create a new return intent and return to the source activity
        if(isChanged){
            intent = new Intent();
            intent.putExtra("return",clinic);
            setResult(RESULT_OK,intent);
            finish();
        }
        //Sets error message if the button is somehow enabled when EditTexts are not different from original values
        else{
            errorMessage.setText("Error: clinic not changed, values are still the same");
        }

    }

    //Method called when delete button is clicked
    public void deleteClinic(){

        //Checks if the defined clinic is valid, if so deletes it from the database and returns to the original activity
        if(dbHandler.searchClinics(clinic.getCompanyName()) != null){
            dbHandler.deleteservices(clinic.getCompanyName());
            intent = new Intent();
            setResult(RESULT_OK,intent);
            finish();
        }
        else{
            errorMessage.setText("Error: Clinic not found in database, please return to previous page.");
        }

    }

    //Method called when back button is clicked
    //Returns to the source activity, returning the original clinic in the process
    public void returnActivity(){
        intent = new Intent();
        intent.putExtra("return",originalClinic);
        setResult(RESULT_OK,intent);
        finish();
    }
}
