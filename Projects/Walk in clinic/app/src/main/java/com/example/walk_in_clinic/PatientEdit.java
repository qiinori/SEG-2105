package com.example.walk_in_clinic;

import android.os.Bundle;

import java.io.Serializable;
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

public class PatientEdit extends AppCompatActivity implements Serializable {

    private EditText username, rate;
    private TextView email,firstName,lastName;
    private Button editButton, deleteButton, returnButton;
    private Patient originalPatient,patient;
    private Services originalServices, services;
    private MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstance){

        super.onCreate(savedInstance);
        setContentView(R.layout.patient_edit);

        username = findViewById(R.id.EditUsername);
        email = findViewById(R.id.EditEmail);
        firstName = findViewById(R.id.EditFirstName);
        lastName = findViewById(R.id.EditLastName);
        editButton = findViewById(R.id.EditDone);
        deleteButton = findViewById(R.id.Delete);
        returnButton = findViewById(R.id.Return);
        rate = findViewById(R.id.EditRate);


        editButton.setEnabled(false);

        originalPatient = (Patient) getIntent().getSerializableExtra("profile");

        patient = (Patient) getIntent().getSerializableExtra("profile");

        originalServices = (Services) getIntent().getSerializableExtra("profile");

        services = (Services) getIntent().getSerializableExtra("profile");

        username.setText(patient.getUsername());
        email.setText(patient.getEmail());
        firstName.setText(patient.getFirst_name());
        lastName.setText(patient.getLast_name());

        dbHandler = new MyDBHandler(this);

        username.addTextChangedListener(textWatch);

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

            if(usernameNotEqual()){
                patient.setUsername(username.getText().toString());
                editButton.setEnabled(true);
            }
            else{
                editButton.setEnabled(false);
            }

        }
    };

    public boolean usernameNotEqual(){
        return(!username.getText().toString().equals(originalPatient.getUsername())) ? true:false;
    }


    public void editPatient(View view){

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        String SQL;

        String name = patient.getUsername();
        SQL = "UPDATE Patients SET PatientUsername = \"" + name + "\"" + " WHERE PatientUsername = \"" + originalPatient.getUsername() + "\"";
        Integer rating = services.getRate();
        SQL = "UPDATE Services SET Rating = \"" + rating + "\"" + " WHERE Rating = \"" + originalServices.getRate() + "\"";
        db.execSQL(SQL);

        db.close();
        Intent intent = new Intent();
        intent.putExtra("return",patient);
        setResult(RESULT_OK,intent);
        finish();

    }

    public void deletePatient(View view){

        if(dbHandler.searchPatients(patient.getEmail()) != null){
            dbHandler.deletePatient(patient.getEmail());
            Intent intent = new Intent();
            setResult(RESULT_OK,intent);
            finish();
        }
    }

    public void patientReturn(View view){
        Intent intent = new Intent();
        intent.putExtra("return",originalPatient);
        setResult(RESULT_OK,intent);
        finish();
    }

}
