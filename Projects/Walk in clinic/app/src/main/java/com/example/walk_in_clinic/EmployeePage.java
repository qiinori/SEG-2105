package com.example.walk_in_clinic;

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

@SuppressWarnings("serial")
public class EmployeePage extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView email;
    private TextView hours;
    private EditText username,Firstname, Lastname, Email, Workinghour,Description;
    private Button editButton, deleteButton, returnButton;
    private Intent intent;
    private Employee currentEmployee,employee;
    private MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_employee);

        username = findViewById(R.id.textUsername);
        firstName = findViewById(R.id.textfirstname);
        lastName = findViewById(R.id.textlastname);
        email = findViewById(R.id.textemail);
        Lastname = findViewById(R.id.textFname);
        Firstname = findViewById(R.id.textLname);
        Email = findViewById(R.id.textEmail);
        Workinghour = findViewById(R.id.textWorkhour);
        Description = findViewById(R.id.textViewDescription);
        editButton = findViewById(R.id.EditDone);
        deleteButton = findViewById(R.id.Delete);
        returnButton = findViewById(R.id.Return);

        intent = getIntent();

        currentEmployee = (Employee) getIntent().getSerializableExtra("profile");
        employee = (Employee) getIntent().getSerializableExtra("profile");

        Firstname.setText(currentEmployee.getFirst_name());
        Lastname.setText(currentEmployee.getLast_name());
        Email.setText(currentEmployee.getEmail());
        username.setText(currentEmployee.getUsername());
        Workinghour.setText(String.valueOf(currentEmployee.getWorkhour()));
        Description.setText(currentEmployee.getDescription());
    }
    private final TextWatcher textWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if(workhourNotEqual()){
                employee.setWorkhour(Double.parseDouble(Workinghour.getText().toString()));
                editButton.setEnabled(true);
            }
            else{
                editButton.setEnabled(false);
            }

        }
    };
    public boolean workhourNotEqual() {
        return (!Workinghour.getText().toString().equals(String.valueOf(currentEmployee.getWorkhour()))) ? true : false;
    }
    public void editEmployee(View view){

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        String SQL;

        double hour = Double.parseDouble(Workinghour.getText().toString());
        String describ = Description.getText().toString();
        SQL = "UPDATE Employee SET EmployeeWorkHour = \"" + hour + "\"" + " WHERE EmployeeWorkHour = \"" + currentEmployee.getWorkhour() + "\"";
        db.execSQL(SQL);
        SQL = "UPDATE Employee SET EmployeeDescription = \"" + describ + "\"" + " WHERE EmployeeDescription = \"" + currentEmployee.getDescription() + "\"";
        db.execSQL(SQL);


        db.close();
        Intent intent = new Intent();
        intent.putExtra("return",employee);
        setResult(RESULT_OK,intent);
        finish();

    }
    public void deleteEmployee(View view){

        if(dbHandler.searchEmployees(employee.getEmail()) != null){
            dbHandler.deleteEmployee(employee.getEmail());
            Intent intent = new Intent();
            setResult(RESULT_OK,intent);
            finish();
        }
    }

    public void employeeReturn(View view){
        Intent intent = new Intent();
        intent.putExtra("return",currentEmployee);
        setResult(RESULT_OK,intent);
        finish();
    }

}
