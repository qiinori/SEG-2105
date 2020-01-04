package com.example.walk_in_clinic;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/*
    Custom adapter for Service objects
    used to open context to edit or delete Services in listview
 */

public class ServiceCustomAdapter extends ArrayAdapter{

    private final Context context;
    private ArrayList<Services> list;
    private TextView serviceName;

    public ServiceCustomAdapter(Context context, ArrayList<Services> list){
        super(context, R.layout.service_layout,list);
        this.context = context;
        this.list =  list;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.service_layout,parent,false);

        Services service = (Services) list.get(position);


        TextView serviceName = (TextView) rowView.findViewById(R.id.ServiceName);

        serviceName.setText(service.getServicesName());

        return rowView;
    }

}
