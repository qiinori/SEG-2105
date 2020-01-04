package com.example.walk_in_clinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.PixelCopy;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;


public class AdministatorPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Creating Variables
    private Spinner adminSpin;
    private String[] adminOptions = {"Patients", "Clinics", "Services"};
    private String[] patientColumns = {"PatientFirstName","PatientLastName","PatientEmail","PatientPassword","PatientUsername"};
    private MyDBHandler dbHandler;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList dataList;
    private PatientCustomAdapter pAdapter;
    private ServiceCustomAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administator_page);

        //Initializing spinner to select object type to review and setting an on click listener
        adminSpin = (Spinner) findViewById(R.id.AdminSelect);
        adminSpin.setOnItemSelectedListener(this);

        //Creating an array adapter for the spinner
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, adminOptions);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting array adapter for the spinner
        adminSpin.setAdapter(aa);

        //Initializing dbHandler
        dbHandler = new MyDBHandler(this);


        //setting adapter to PatientAdapter as default
        listView = findViewById(R.id.List);
        patientList();

        //Method called on click of list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Checks which type of object is in display and opens the proper editing page
                if (dataList.get(position) instanceof Services) {
                    Services services = (Services) dataList.get(position);
                    Intent editorLaunchInterest = new Intent(getApplicationContext(), ServicePage.class);
                    editorLaunchInterest.putExtra("profile", services);
                    startActivityForResult(editorLaunchInterest, 0);
                } else if (dataList.get(position) instanceof Clinic) {
                    Clinic clinic = (Clinic) dataList.get(position);
                    Intent editorLaunchInterest = new Intent(getApplicationContext(), ClinicPage.class);
                    editorLaunchInterest.putExtra("profile",clinic);
                    startActivityForResult(editorLaunchInterest,0);
                } else if (dataList.get(position) instanceof Patient) {
                    Patient patient = (Patient) dataList.get(position);
                    Intent editorLaunchIntent = new Intent(getApplicationContext(), PatientEdit.class);
                    editorLaunchIntent.putExtra("profile", patient);
                    startActivityForResult(editorLaunchIntent, 0);
                }

            }
        });

    }

    //Method called when spinner position changes
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //Changes text shown on spinner
        Toast.makeText(getApplicationContext(), adminOptions[position], Toast.LENGTH_LONG).show();

        //Checks if position is valid and passes value to changeScroll
        if(position > 2 || position < 0){
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_LONG).show();
        }
        else{
            changeScroll(position);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    //Method called to change items in listview
    public void changeScroll(int pos) {

        System.out.println(pos);
        //Setting datalist to empty to add items to
        dataList = new ArrayList();

        //Switch statement to select which data type to populate the list is
        switch (pos) {
            case 0:
                patientList();
                break;
            case 1:
                clinicList();
                break;
            case 2:
                serviceList();
                break;
        }
    }

    //Method to populate dataList with patients and change the adapter to patient
    public void patientList(){
        //Opening database
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        String query = "SELECT * FROM Patients";

        dataList = new ArrayList<Patient>();

        //Creating cursor
        Cursor cursor;

        cursor = db.rawQuery(query,null);

        //Changing adapter and notifying the adapter the data set has changed so it updates the list view
        pAdapter = new PatientCustomAdapter(this,dataList);
        listView.setAdapter(pAdapter);

        //While loop that runs while there is a next value to add a new object to the arraylist
        while (cursor.moveToNext()) {
            Patient patient = new Patient(cursor.getString(4), cursor.getString(2), cursor.getString(0),
                    cursor.getString(1), cursor.getString(3));
            dataList.add(patient);
            pAdapter.notifyDataSetChanged();
        }


        db.close();
    }

    //Method to populate dataList with clinics and change the adapter to clinic
    public void clinicList(){
        //Opening database
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        //Creating cursor
        Cursor cursor;

        //Creating query
        String query = "Select * FROM Clinic";

        //Initializing cursor using query
        cursor = db.rawQuery(query, null);

        //While loop that runs while there is a next value to add a new object to the arraylist
        while (cursor.moveToNext()) {
            Clinic clinic = new Clinic(cursor.getString(0), cursor.getString(1), null, cursor.getString(2));
            dataList.add(clinic);
        }

        db.close();
        //Changing adapter and notifying the adapter the data set has changed so it updates the list view
        adapter = new ClinicCustomAdapter(this,dataList);
        adapter.notifyDataSetChanged();
    }

    //Method to populate dataList with services and change the adapter to service
    public void serviceList(){
        //Opening database
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        //Creating cursor
        Cursor cursor;

        dataList = new ArrayList<Services>();

        //Creating query
        String query = "Select * FROM services";

        //Initializing cursor using query
        cursor = db.rawQuery(query, null);

        //Changing adapter and notifying the adapter the data set has changed so it updates the list view
        sAdapter = new ServiceCustomAdapter(this,dataList);
        listView.setAdapter(sAdapter);

        //While loop that runs while there is a next value to add a new object to the arraylist
        while (cursor.moveToNext()) {
            Services service = new Services(cursor.getFloat(1), cursor.getString(0), cursor.getString(2), cursor.getFloat(3), null);
            dataList.add(service);
            sAdapter.notifyDataSetChanged();
        }

        db.close();
    }
}
