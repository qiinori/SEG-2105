package com.example.walk_in_clinic;


import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.test.annotation.UiThreadTest;
import androidx.test.espresso.Root;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;

public class deliverable03Test1 {
    @Rule
    public ActivityTestRule <MainActivity> mainActivityActivityTestRule = new ActivityTestRule(MainActivity.class);
    private MainActivity mainActivity = null;
    Button logBtn;
    Button continueBtn;
    public ActivityTestRule <Login> loginActivityTestRule = new ActivityTestRule(Login.class);
    private Login loginActivity = null;


    public ActivityTestRule <Servicespage> servicespageActivityTestRule = new ActivityTestRule(Servicespage.class);
    private Servicespage myServicespage = null;
    private TextView serviceText;

    @Before
    public void setup() throws Exception{

        mainActivity = mainActivityActivityTestRule.getActivity();
        loginActivity = loginActivityTestRule.getActivity();

        myServicespage = servicespageActivityTestRule.getActivity();
    }

    @Test
    @UiThreadTest
    public void checkServiceName() throws Exception{

        TextView email = mainActivity.findViewById(R.id.EmailLogin);
        email.setText("example@gmail.com");

        TextView pwd = mainActivity.findViewById(R.id.PasswordField);
        pwd.setText("password");

        Button logBtn = mainActivity.findViewById(R.id.LoginButton);
        this.logBtn = logBtn;
        logBtn.performClick();

        Button continueBtn = loginActivity.findViewById(R.id.continuebutton);
        this.continueBtn = continueBtn;
        continueBtn.performClick();

        //assertNotNull(myServicespage.findViewById(R.id.services_name));
        serviceText = myServicespage.findViewById(R.id.services);
        serviceText.setText("vaccine shot");
        String testService = serviceText.getText().toString();
        assertNotEquals("", testService);
    }
}
