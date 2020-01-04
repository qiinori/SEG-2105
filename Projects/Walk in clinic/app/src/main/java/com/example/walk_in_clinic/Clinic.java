package com.example.walk_in_clinic;

import java.io.Serializable;
import java.util.List;

/*
Created Clinic class that stores information about the clinic
Such as It's employee List (Which in turn stores the majority of important information
 */
@SuppressWarnings("serial")
public class Clinic implements Serializable {

    //Class Variables
    private String companyName;
    private String description;
    private List<Employee> employeeList;
    private String address;

    //Null Constructor
    public Clinic(){}

    //Default Constructor
    public Clinic(String compName,String desc, List<Employee> employeeList, String address){
        this.companyName = compName;
        this.description = desc;
        this.employeeList = employeeList;
        this.address = address;
    }

    //Get and Set methods
    public String getCompanyName(){return this.companyName;}

    public String getDescription(){return this.description;}

    public String getAddress(){return this.address;}

    public void setCompanyName(String companyName){this.companyName = companyName;}

    public void setDescription(String description){this.description = description;}

    public void setEmployeeList(List<Employee> eList){this.employeeList = eList;}

    public void setAddress(String address){this.address = address;}



    //Method to add employee to the employee list
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    //Method to remove employee from employee list
    public boolean removeEmployee(String email){
        boolean result = false;
        int counter = 0;

        for(Employee e: employeeList){
            if(e.getEmail().equals(email)){
                employeeList.remove(counter);
                result = true;
            }
            counter++;
        }
        return result;
    }

    //Method to search and return employee if found in employee list
    public Employee searchEmployee(String email){
        int counter = 0;

        for(Employee e: employeeList){
            if(e.getEmail().equals(email)){
                return employeeList.get(counter);
            }
            counter++;
        }
        return null;
    }
}
