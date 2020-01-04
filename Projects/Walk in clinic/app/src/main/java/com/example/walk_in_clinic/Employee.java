package com.example.walk_in_clinic;
import android.os.Parcelable;

import java.io.Serializable;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import static com.example.walk_in_clinic.asSha256.*;

/*
    Class used to store Employee information
 */

public class Employee implements Serializable, UserInterface {
    /**
     * Create an account for the walk in clinic
     * Select services provided and the rate for each service
     * Enter the working hours of the walk in clinic
     * @param username
     * @param password
     * @param first_name
     * @param last_name
     * @param email
     * @param rate
     * @param working_hour
     */

    //Class Variables
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String nameofCompany;
    private String description;
    private boolean licensed;
    private List<Services> servicesOffered;
    private double workhour;
    private List<Patient> patientsigned;


    //Null Constructor
    public Employee(){}

    //Default Constructor
    public Employee(String username, String password, String first_name, String last_name, String email,String address,String nameofCompany,String description,boolean licensed, List<Services> services, double workhour){

        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.address = address;
        this.nameofCompany = nameofCompany;
        this.description = description;
        this.licensed = licensed;
        this.servicesOffered = services;
        this.workhour = workhour;
    }

    //Prints out account info
    public void accountInfo(){
        System.out.println("Employee's information");
        System.out.println("Username: " + getUsername());
        System.out.println("First Name: " + getFirst_name());
        System.out.println("Last Name: " + getLast_name());
        System.out.println("Password: " + getPassword());
        System.out.println("Email: " + getEmail());
    }

    //Get and Set Methods

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){

        this.password = password;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        /*try
        {
            this.password =  asSha256.toHexString(getSHA(password));
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }*/
        return this.password;
    }

    public String getFirst_name(){
        return this.first_name;
    }

    public String getLast_name(){
        return this.last_name;
    }

    public String getEmail(){
        return this.email;
    }


    public void setNameofCompany(String companyName){this.nameofCompany = companyName;}

    public void setDescription(String description){this.description = description;}

    public void setLicensed(String licensed){this.licensed =(licensed.toLowerCase()=="yes") ? true : false;}

    public String getAddress(){
        return this.address;
    }

    public String getNameofCompany(){
        return this.nameofCompany;
    }

    public String getDescription(){
        return this.description;
    }

    public String getLicensed(){
        if(licensed)
            return "Yes";
        else
            return "No";
    }

    public void setServiceList(List<Services> serviceList){this.servicesOffered = serviceList;}

    public void addService(Services service){
        servicesOffered.add(service);
    }
    public void setWorkhour(double workhour){
        this.workhour = workhour;
    }
    public double getWorkhour(){return this.workhour;}

    //Method used to remove a service from the list, returns a boolean value
    public Boolean removeService(String serviceName){
        boolean result = false;
        int counter = 0;

        for(Services s : servicesOffered){
            if(s.getServicesName().toLowerCase().equals(serviceName.toLowerCase())){
                servicesOffered.remove(counter);
                result = true;
            }
            counter++;
        }
        return result;
    }

    //Method use to search for a service in the list, returns the service found
    public Services searchService(String serviceName){
        int counter = 0;

        for(Services s: servicesOffered){
            if(s.getServicesName().toLowerCase().equals(serviceName.toLowerCase())){
                return servicesOffered.get(counter);
            }
            counter++;
        }
        return null;
    }
}