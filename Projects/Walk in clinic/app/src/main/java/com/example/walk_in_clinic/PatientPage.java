package com.example.walk_in_clinic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

/*
    Class used to display Patient profile after login
 */

@SuppressWarnings("serial")
public class PatientPage extends AppCompatActivity implements Serializable {

    //Class Variables
    private TextView firstName,lastName,email,services,doctor;
    private Patient currentPatient;


    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_user);

        firstName = findViewById(R.id.textfirstname);
        lastName = findViewById(R.id.textlastname);
        email = findViewById(R.id.textemail);
        services = findViewById(R.id.textservices);
        doctor = findViewById(R.id.textemployee);

        currentPatient = (Patient) getIntent().getSerializableExtra("profile");

        firstName.setText(currentPatient.getFirst_name());
        lastName.setText(currentPatient.getLast_name());
        email.setText(currentPatient.getEmail());

    }
}
