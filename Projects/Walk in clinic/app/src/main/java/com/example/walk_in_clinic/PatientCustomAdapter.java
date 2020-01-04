package com.example.walk_in_clinic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
    Custom adapter for Patient objects
    used to open context to edit or delete patients in listview
 */

public class PatientCustomAdapter extends ArrayAdapter {

    private final Context context;
    private TextView username,name,email;
    private ArrayList<Patient> list;

    public PatientCustomAdapter(Context context, ArrayList<Patient> list){
        super(context, R.layout.patient_layout,list);
        this.context = context;
        this.list =  list;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.patient_layout,parent,false);

        username = rowView.findViewById(R.id.PatientUsername);
        name = rowView.findViewById(R.id.PatientName);
        email = rowView.findViewById(R.id.PatientEmail);

        Patient patient = (Patient) list.get(position);

        username.setText(patient.getUsername());
        name.setText(patient.getFirst_name() + " " + patient.getLast_name());
        email.setText(patient.getEmail());

        return rowView;
    }
}
