package com.example.walk_in_clinic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class EmployeeList  extends ArrayAdapter<Employee>{

    private Activity context;
    List<Employee> employees;

    public EmployeeList(MainActivity context, List<Employee> employees){
        super(context, R.layout.layout_employee_list, employees);
        this.context = context;
        this.employees = employees;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_employee_list, null, true);


        TextView textViewFirstName= (TextView) listViewItem.findViewById(R.id.textViewFirstName);
        TextView textViewLastName = (TextView) listViewItem.findViewById(R.id.textViewLastName);
        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textViewEmail);
        TextView textViewAddress = (TextView) listViewItem.findViewById(R.id.textViewAddress);
        TextView textViewDescription = (TextView) listViewItem.findViewById(R.id.textViewDescription);
        TextView textViewLicensed = (TextView) listViewItem.findViewById(R.id.textViewLicensed);
        TextView textViewWorkhour = (TextView) listViewItem.findViewById(R.id.textViewWorkhour);


        Employee employee = employees.get(position);
        textViewFirstName.setText(employee.getFirst_name());
        textViewLastName.setText(employee.getLast_name());
        textViewEmail.setText(employee.getEmail());
        textViewAddress.setText(employee.getAddress());
        textViewDescription.setText(employee.getDescription());
        textViewLicensed.setText(employee.getLicensed());
        textViewWorkhour.setText(String.valueOf(employee.getWorkhour()));
        return listViewItem;
    }
}
