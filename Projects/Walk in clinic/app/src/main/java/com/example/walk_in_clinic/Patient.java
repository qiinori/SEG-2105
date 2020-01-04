package com.example.walk_in_clinic;

import java.io.Serializable;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import static com.example.walk_in_clinic.asSha256.getSHA;

/*
    Class used to store patient information
 */

public class Patient implements Serializable{
    /**
     * Create an account
     * Search for a walk in clinic by address/type of service provided/working hours
     * Check in/book an appointment
     * Rate his/her experience at the walk in clinic
     * @param username
     * @param password
     * @param first_name
     * @param last_name
     * @param email
     * @param rate
     * @param address
     */

    //Class Variables
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;

    //Default Constructor
    public Patient(String username, String password, String first_name, String last_name, String email){

        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;

    }

    //Null Constructor
    public Patient(){}

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

    public String getEmail() {
        return this.email;
    }

    public int RatingAClinic(int rating){
        /**
         * The patient can rate a clinic by providing a score between 1 (terrible) and 5 (amazing) as well as provide comment.
         */
        System.out.println("Thank you for your feedback");
        return rating;
    }


    //Method to print out user information
    public void accountInfo(){
        System.out.println("Patient's information");
        System.out.println("Username: " + getUsername());
        System.out.println("First Name: " + getFirst_name());
        System.out.println("Last Name: " + getLast_name());
        System.out.println("Password: " + getPassword());
        System.out.println("Email: " + getEmail());
    }
}
