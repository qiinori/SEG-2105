package com.example.walk_in_clinic;

import java.io.Serializable;
import java.lang.String;
import java.security.NoSuchAlgorithmException;

import static com.example.walk_in_clinic.asSha256.getSHA;

/*
    Class for storing Administrator information
    Stores:
    Username
    Password
    Name
    Email
 */

@SuppressWarnings("serial")
public class Administrator implements Serializable, UserInterface {

    /**
     * Create services (at least 5) to be offered by walk-in clinics using the application.
     * Delete accounts of walk in clinics and users
     *
     * @param username
     * @param password
     * @param first_name
     * @param last_name
     * @param email
     */

    //Class Variables
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;

    //Null Constructor
    public Administrator(){}

    //Default Constructor
    public Administrator(String username, String password, String first_name, String last_name, String email){

        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

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

    //Method to print out account information
    public void accountInfo(){
        System.out.println("Admin's information");
        System.out.println("Username: " + getUsername());
        System.out.println("First Name: " + getFirst_name());
        System.out.println("Last Name: " + getLast_name());
        System.out.println("Password: " + getPassword());
        System.out.println("Email: " + getEmail());
    }


}
