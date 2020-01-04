package com.example.walk_in_clinic;

import java.io.Serializable;
import java.sql.Time;


/*
    Class for storage of services
    stores:
    Name of Service
    Type of Service
    Appointment Time
    Hour
    Employee Executing Service
 */

@SuppressWarnings("serial")
public class Services implements Serializable {

    //Class Variables
    private float hour;
    private String servicesname;
    private String type;
    private Float appointmenttime;
    private Employee assignedWorker;
    private Integer rate;

    //Null Constructor
    public Services(){}

    //Default Constructor
    public Services(float hour, String servicesname, String type, Float appointmenttime, Employee worker) {
        this.hour = hour;
        this.servicesname = servicesname;
        this.type = type;
        this.appointmenttime = appointmenttime;
        this.assignedWorker = worker;
        rate = 0;
    }

    //Set and Get methods
    public void setHour(float h) {
        hour = h;
    }
    public float getHour() {
        return hour;
    }
    public void setServicesName(String s) {
        servicesname = s;
    }
    public String getServicesName() {
        return servicesname;
    }
    public void setType(String t) {
        type = t;
    }
    public String getType() {
        return type;
    }
    public void setAssignedWorker(Employee e){this.assignedWorker = e;}
    public Employee assignedWorker(){return this.assignedWorker;}
    public void setAppointmentTime(Float a) {
        appointmenttime = a;
    }
    public Float getAppointmentTime(){return appointmenttime;}
    public void setRate(Integer r){rate = r;}
    public Integer getRate(){return rate;}


}
