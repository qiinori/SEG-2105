package com.example.walk_in_clinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

/*
    Class for the main welcome screen of the app
    Can choose to login or create an account
 */

public class MainActivity extends AppCompatActivity {

    //Class Variables
    private Button loginButton,createAccount;
    private EditText emailInput,passwordInput;
    private MyDBHandler dbHandler;
    private Intent intent;
    private String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing fields and setting login button to false;
        loginButton = findViewById(R.id.LoginButton);
        loginButton.setEnabled(false);


        emailInput = findViewById(R.id.EmailLogin);
        passwordInput = findViewById(R.id.PasswordField);

        //Setting TextWatcher for EditTexts
        emailInput.addTextChangedListener(watcher);
        passwordInput.addTextChangedListener(watcher);

        //Initializing db Handler
        dbHandler = new MyDBHandler(this);
    }

    //Method called when Create Account button is clicked, opens new activity
    public void createAccountClick(View view){
        Intent intent = new Intent(this, AccountCreation.class);
        startActivity(intent);
    }

    //Textwatcher used to check EditText fields
    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            //Checks if the email and password are valid
            if(emailInput.getText().toString().length() == 0 || passwordInput.getText().toString().length() == 0){
                loginButton.setEnabled(false);
            }
            else{
                email = emailInput.getText().toString();
                password = passwordInput.getText().toString();
                loginButton.setEnabled(true);
            }
        }
    };

   // Add progress bar functionality, and copy email validation for next deliverable
    //Method to log user in
    public void userLogin(View view){

        //Checks fields are valid
        if(email.isEmpty()){
            emailInput.setError("Email is required");
            emailInput.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailInput.setError("Please enter a valid email");
            emailInput.requestFocus();
            return;
        }

        if(password.isEmpty()){
            passwordInput.setError("Password is required");
            passwordInput.requestFocus();
            return;
        }

        if(password.length()<6){
            passwordInput.setError("Minimum length of password is 6");
            passwordInput.requestFocus();
            return;
        }

        Patient patient = new Patient();
        patient.setPassword(password);
        patient.setEmail(email);
        Employee emp = new Employee();
        emp.setPassword(password);
        emp.setEmail(email);
        Administrator admin = new Administrator();
        admin.setPassword(password);
        admin.setEmail(email);


        /*
            If statements to find what type of object the user is and initizalize it if it's found
            If there is a match passwords are then compared
            if passwords match the object is passed to the appropriate activity
         */
        if(dbHandler.searchPatients(email) != null){
            patient = (Patient) dbHandler.searchPatients(email);
            String patientPassword = patient.getPassword();
            if(patientPassword.equals(password)){
                intent = new Intent(this,PatientPage.class);
                intent.putExtra("profile",patient);
                startActivity(intent);
            }
            else {
                passwordInput.setError("Error: password does not match email");
                passwordInput.requestFocus();
            }
        }
        else{
            if(dbHandler.searchEmployees(email) != null){
                emp = (Employee) dbHandler.searchEmployees(email);
                String empPassword = emp.getPassword();
                if(empPassword.equals(password)){
                    intent = new Intent(this,EmployeePage.class);
                    intent.putExtra("profile",emp);
                    startActivity(intent);
                }
                else{
                    passwordInput.setError("Error: password does not match email");
                    passwordInput.requestFocus();
                }
            }
            else{
                if(dbHandler.searchAdmin(email) != null){
                    admin = (Administrator) dbHandler.searchAdmin(email);
                    String adminPassword = admin.getPassword();
                    if(adminPassword.equals(password)){
                        intent = new Intent(this,AdministatorPage.class);
                        intent.putExtra("profile",admin);
                        startActivity(intent);
                    }
                    else{
                        passwordInput.setError("Error: password does not match email");
                        passwordInput.requestFocus();
                    }
                }
            }
        }
    }

}
