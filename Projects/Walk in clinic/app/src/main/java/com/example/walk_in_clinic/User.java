package com.example.walk_in_clinic;
import android.widget.AdapterView;

import java.io.Serializable;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

import static com.example.walk_in_clinic.asSha256.getSHA;

public class User implements Serializable {
    /**
     * Users
     * @param username
     * @param password
     * @param first_name
     * @param last_name
     * @param email
     */
   /* private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String nameofCompany;
    private String description;
    private boolean licensed;
    private int userType;
    private static final int ADMIN = 0;
    private static final int EMPLOYEE = 1;
    private static final int PATIENT = 2;
    private User user;
    private List<Services> servicesOffered;

    public User(){}

    public User(String username,String password){
        this.username = username;
        try
        {
            this.password =  asSha256.toHexString(getSHA(password));
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
    }

    public void createUser(String username, String password, String first_name, String last_name, String email,int userType){

        this.username = username;
        this.userType = userType;
        try
        {
            this.password =  asSha256.toHexString(getSHA(password));
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        if (userType == ADMIN){
            user = new Administrator(username,password,first_name,last_name,email);
        }else if (userType == EMPLOYEE){
            user = new Employee(username,password,first_name,last_name,email,address,nameofCompany,description,licensed,servicesOffered);
        }else if (userType == PATIENT){
            user = new Patient(username,password,first_name,last_name,email);
        }
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
        try
        {
            this.password =  asSha256.toHexString(getSHA(password));
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
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
    public void setAddress(String address){this.address = address;}
    public String getAddress(){return address;}

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription(){return description;}
    public void setNameofCompany(String nameofCompany){this.nameofCompany = nameofCompany;}
    public String getNameofCompany(){return nameofCompany;}
    public int getusertype(){return this.userType;}
    //private int verifyLogin(String username,String password){

    //}
    public void accountInfo(){

        System.out.println("Username: " + this.username);
        System.out.println("First Name: " + this.first_name );
        System.out.println("Last Name: " + this.last_name );
        System.out.println("Password: " + this.password);
        System.out.println("Email: " + this.email);
    }
    */
}