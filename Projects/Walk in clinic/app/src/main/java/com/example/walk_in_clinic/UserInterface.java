package com.example.walk_in_clinic;

import java.security.NoSuchAlgorithmException;

import static com.example.walk_in_clinic.asSha256.getSHA;

public interface UserInterface {



    public void setUsername(String username);

    public void setPassword(String password);

    public void setFirst_name(String first_name);

    public void setLast_name(String last_name);

    public void setEmail(String email);

    public String getUsername();

    public String getPassword();

    public String getFirst_name();

    public String getLast_name();

    public String getEmail();
}
