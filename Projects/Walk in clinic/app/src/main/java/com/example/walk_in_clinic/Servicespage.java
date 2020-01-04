package com.example.walk_in_clinic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



import androidx.appcompat.app.AppCompatActivity;

/*
    Class to add delete or search for services
 */

public class Servicespage extends AppCompatActivity {

    //Class Variables
    EditText services;
    EditText appointment;
    EditText hours;
    EditText types;
    EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        //Initializing EditTexts
        services = (EditText) findViewById(R.id.services);
        appointment = (EditText) findViewById(R.id.appointment);
        hours = (EditText) findViewById(R.id.hour);
        types = (EditText) findViewById(R.id.types);
        name = (EditText) findViewById(R.id.name);
    }

    //Method to add service to the database
    public void Addservices (View view) {

        Employee employee = new Employee();
        Services service = new Services(Float.parseFloat(hours.getText().toString()),services.getText().toString(), types.getText().toString(), Float.parseFloat(appointment.getText().toString()),employee );
        service.setServicesName(name.getText().toString());
        MyDBHandler dbHandler = new MyDBHandler(this);
        dbHandler.addServices(service);

        services.setText("Services add!");
        hours.setText("");
        types.setText("");
        appointment.setText("");
    }

    //Method to search for a service and display it in the view
    public void Searchservice (View view) {


        MyDBHandler dbHandler = new MyDBHandler(this);
        dbHandler.searchservices(services.getText().toString());
        Services service = null;

        if (service != null) {
            hours.setText(String.valueOf(service.getHour()));
            types.setText(String.valueOf(service.getType()));
            appointment.setText(String.valueOf(service.getAppointmentTime()));
        } else {
            services.setText("No Match Found");
        }
    }

    //Method to delete the service
    public void Deleteservices (View view) {


        MyDBHandler dbHandler = new MyDBHandler(this);
        dbHandler.deleteservices(services.getText().toString());

        boolean result = false;

        if (result) {
            services.setText("Service Deleted");
            hours.setText("");
            types.setText("");
            appointment.setText("");
        }
        else
            services.setText("No Match Found");
    }

}
