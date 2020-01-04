package com.example.walk_in_clinic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
    Custom adapter for Clinic objects
    used to open context to edit or delete clinic in listview
 */
public class ClinicCustomAdapter extends ArrayAdapter {

    private final Context context;
    private ArrayList<Clinic> list;

    public ClinicCustomAdapter(Context context, ArrayList<Clinic> list){
        super(context, R.layout.clinic_layout,list);
        this.context = context;
        this.list =  list;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.clinic_layout,parent,false);
        TextView clinicName = rowView.findViewById(R.id.CompanyName);
        TextView description = rowView.findViewById(R.id.Description);

        clinicName.setText(list.get(position).getCompanyName());
        description.setText(list.get(position).getDescription());

        return rowView;
    }
}
