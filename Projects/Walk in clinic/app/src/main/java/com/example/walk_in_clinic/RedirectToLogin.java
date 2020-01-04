package com.example.walk_in_clinic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/*
    Class used to redirect to login activity
 */

public class RedirectToLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect_to_login);
    }

    public void redirectBtnClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
