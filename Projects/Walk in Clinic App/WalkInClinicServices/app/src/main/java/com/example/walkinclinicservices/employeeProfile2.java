package com.example.walkinclinicservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class employeeProfile2 extends AppCompatActivity {

    private TextView nameTxt, emailTxt, addTxt, paymentTxt, insuranceTxt, numberTxt, clinicTxt;
    private Button editBtn, viewSBtn, editHrsBtn;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile2);

        nameTxt = (TextView) findViewById(R.id.nameTxt);
        emailTxt = (TextView) findViewById(R.id.emailTxt);
        numberTxt = (TextView) findViewById(R.id.numberTxt);
        addTxt = (TextView) findViewById(R.id.addTxt);
        clinicTxt = (TextView) findViewById(R.id.clinicTxt);
        insuranceTxt = (TextView) findViewById(R.id.insuranceTxt);
        paymentTxt = (TextView) findViewById(R.id.paymentTxt);

        editBtn = (Button) findViewById(R.id.editBtn);
        viewSBtn = (Button) findViewById(R.id.viewSBtn);
        editHrsBtn = (Button) findViewById(R.id.editHrsBtn);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (mUser == null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            mDatabase.child("Employee").child(mUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    employee curemployee = dataSnapshot.getValue(employee.class);

                    String name = curemployee.getFirstName();
                    String email = curemployee.getEmail();
                    String address = curemployee.getAddress();
                    String number = curemployee.getNumber();
                    String clinic = curemployee.getClinic();
                    String insurance = curemployee.getInsurance();
                    String payment = curemployee.getPayment();

                    //String display = "Welcome " + name + "! You are logged in";
                    nameTxt.setText(name);
                    emailTxt.setText(email);
                    numberTxt.setText(number);
                    addTxt.setText(address);
                    clinicTxt.setText(clinic);
                    insuranceTxt.setText(insurance);
                    paymentTxt.setText(payment);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(employeeProfile2.this, employeeProfile.class));
            }
        });

        viewSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(employeeProfile2.this, ClinicServices.class));
            }
        });

        editHrsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(employeeProfile2.this, Hours.class));
            }
        });
    }

}
