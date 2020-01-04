package com.example.walk_in_clinic;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;

import java.sql.SQLInput;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "serviceDB.db";
    public static final String TABLE_Service = "services";
    public static final String COLUMN_HOUR = "hours";
    public static final String COLUMN_SERVICENAME = "servicesname";
    public static final String COLUMN_TYPES = "types";
    public static final String COLUMN_APPOINTMENT = "appointment";
    public static final String COLUMN_RATING = "Rate";
    //Information for Table for Users/Patients (Don't know the difference between User and Patient Currently
    public static final String TABLE_Patient = "Patients";
    public static final String COLUMN_FNAME = "PatientFirstName";
    public static final String COLUMN_LNAME = "PatientLastName";
    public static final String COLUMN_EMAIL = "PatientEmail";
    public static final String COLUMN_PASSWORD = "PatientPassword";
    public static final String COLUMN_USERNAME = "PatientUsername";
    //Information for Table for Employees
    public static final String TABLE_Employee = "Employees";
    public static final String COLUMN_EUSERNAME = "EmployeeUsername";
    public static final String COLUMN_EFNAME = "EmployeeFirstName";
    public static final String COLUMN_ELNAME = "EmployeeLastName";
    public static final String COLUMN_EPASSWORD = "EmployeePassword";
    public static final String COLUMN_EEMAIL = "EmployeeEmail";
    public static final String COLUMN_COMPNAME = "EmployeeCompany";
    public static final String COLUMN_DESC = "EmployeeDescription";
    public static final String COLUMN_LICENSED = "EmployeeLicenseStatus";
    public static final String COLUM_WORKHOUR = "EmployeeWorkHour";
    //Clinic Table
    public static final String TABLE_Clinic = "Clinic";
    public static final String COLUMN_CNAME = "ClinicCompanyName";
    public static final String COLUMN_DESCRIPTION = "ClinicCompanyDescription";
    public static final String COLUMN_ADDRESS = "ClinicAddress";
    //Admin Table
    public static final String TABLE_Admin = "Administrator";
    public static final String COLUMN_AUSERNAME = "AdminUsername";
    public static final String COLUMN_APASSWORD = "AdminPassword";
    public static final String COLUMN_AFNAME = "AdminFirstName";
    public static final String COLUMN_ALNAME = "AdminLastName";
    public static final String COLUMN_AEMAIL = "AdminEmailAddress";

    public MyDBHandler (Context context){ super(context, DATABASE_NAME, null , DATABASE_VERSION);}

    public void onCreate(SQLiteDatabase db){
        String CREATE_SERVICES_TABLE = "CREATE TABLE " + TABLE_Service + " (" + COLUMN_SERVICENAME + " TEXT, " + COLUMN_TYPES + " TEXT, " + COLUMN_HOUR + " FLOAT, " + COLUMN_APPOINTMENT + " FLOAT" + COLUMN_RATING + "INTEGER" + ")";
        db.execSQL(CREATE_SERVICES_TABLE);
        //Added DB Table for User profile type
        String CREATE_PATIENT_TABLE = "CREATE TABLE " + TABLE_Patient + " (" + COLUMN_FNAME + " TEXT, " + COLUMN_LNAME + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_USERNAME + " TEXT" + ")";
        db.execSQL(CREATE_PATIENT_TABLE);
        //Added DB table for Employee profile type
        String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + TABLE_Employee + " (" + COLUMN_EUSERNAME + " TEXT, " + COLUMN_EFNAME + "TEXT, " + COLUMN_ELNAME + "TEXT, " + COLUMN_EPASSWORD + "TEXT, "
                + COLUMN_EEMAIL + " TEXT, " + COLUMN_COMPNAME + " TEXT, " + COLUMN_DESC + " TEXT, " + COLUMN_LICENSED + "TEXT"  + ");";
        db.execSQL(CREATE_EMPLOYEE_TABLE);
        //Added DB table for Clinic Profile Type
        String CREATE_CLINIC_TABLE = "CREATE TABLE " + TABLE_Clinic + " (" + COLUMN_CNAME + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_ADDRESS + "TEXT" + ")";
        db.execSQL(CREATE_CLINIC_TABLE);
        //Added DB table for Admin profile type
        String CREATE_ADMIN_TABLE = "CREATE TABLE " + TABLE_Admin + " (" + COLUMN_AUSERNAME + " TEXT, " + COLUMN_APASSWORD + " TEXT, " + COLUMN_AFNAME + " TEXT, " + COLUMN_ALNAME + " TEXT, " + COLUMN_AEMAIL + " TEXT" + ")";
        db.execSQL(CREATE_ADMIN_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Service);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Patient);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Employee);
        onCreate(db);
    }

    public void addServices (Services services){


        ContentValues values = new ContentValues();
        values.put(COLUMN_SERVICENAME, services.getServicesName());
        values.put(COLUMN_HOUR, services.getHour());
        values.put(COLUMN_TYPES, services.getType());
        values.put(COLUMN_APPOINTMENT, services.getAppointmentTime());
        values.put(COLUMN_RATING, services.getRate());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_Service, null, values);

        db.close();
    }

    public Services searchservices(String servicesname){
        String query = "Select * FROM " + TABLE_Service + " WHERE " + COLUMN_SERVICENAME + " = \"" + servicesname + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Services services = new Services();

        if (cursor.moveToFirst()){
            services.setServicesName(cursor.getString(0));
            services.setHour(Float.parseFloat(cursor.getString(2)));
            services.setType(cursor.getString(1));
            services.setAppointmentTime(Float.parseFloat(cursor.getString(3)));
            services.setRate(Integer.parseInt(cursor.getString(4)));
            cursor.close();
        }
        else{
            services = null;
        }
        db.close();
        return services;
    }

    public boolean deleteservices(String servicesname){
        boolean result = false;

        String query = "Select * FROM " + TABLE_Service + " WHERE " + COLUMN_SERVICENAME + "= \"" + servicesname + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            String temp = cursor.getString(0);
            String SQL = "DELETE FROM " + TABLE_Service + " WHERE " + COLUMN_SERVICENAME + "= \"" + servicesname + "\"";
            db.execSQL(SQL);
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    //Added add,search, and remove methods for all new DB tables
    public void addPatient(Patient user){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues vals = new ContentValues();
        vals.put(COLUMN_FNAME,user.getFirst_name());
        vals.put(COLUMN_LNAME,user.getLast_name());
        vals.put(COLUMN_PASSWORD,user.getPassword());
        vals.put(COLUMN_EMAIL,user.getEmail());
        vals.put(COLUMN_USERNAME,user.getUsername());


        db.insert(TABLE_Patient,null,vals);
        db.close();
    }

    public Patient searchPatients(String email){
        String query = "SELECT * FROM " + TABLE_Patient + " WHERE " + COLUMN_EMAIL + " = \"" + email + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        Patient users = new Patient();

        if(cursor.moveToFirst()){
            users.setFirst_name(cursor.getString(0));
            users.setLast_name(cursor.getString(1));
            users.setPassword(cursor.getString(2));
            users.setEmail(cursor.getString(3));
            users.setUsername(cursor.getString(4));
        }
        else{
            users = null;
        }

        db.close();
        return users;
    }

    public Patient searchPatientUsername(String username){
        String query = "Select * FROM " + TABLE_Patient + " WHERE " + COLUMN_USERNAME + " = \"" + username + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        Patient patient = new Patient();

        if(cursor.moveToFirst()){
            patient.setFirst_name(cursor.getString(0));
            patient.setLast_name(cursor.getString(1));
            patient.setPassword(cursor.getString(2));
            patient.setEmail(cursor.getString(3));
            patient.setUsername(cursor.getString(4));
        }
        else{
            patient = null;
        }

        db.close();
        return patient;
    }

    public Boolean deletePatient(String email){

        boolean result = true;

        String SQL = "DELETE FROM " + TABLE_Patient + " WHERE " + COLUMN_EMAIL + " = \'" + email + "\'";

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(SQL);

        if(searchPatients(email) == null){
            result = true;
        }

        db.close();
        return result;
    }


    //Add a new employee object to the database
    public void addEmployee(Employee employee){

        //Setting the values in the table for the employee
        ContentValues vals = new ContentValues();
        vals.put(COLUMN_EUSERNAME,employee.getUsername());
        vals.put(COLUMN_EFNAME,employee.getFirst_name());
        vals.put(COLUMN_EFNAME,employee.getLast_name());
        vals.put(COLUMN_EPASSWORD,employee.getPassword());
        vals.put(COLUMN_EEMAIL,employee.getEmail());
        vals.put(COLUMN_COMPNAME,employee.getNameofCompany());
        vals.put(COLUMN_DESC,employee.getDescription());
        vals.put(COLUMN_LICENSED,employee.getLicensed());
        vals.put(COLUM_WORKHOUR,employee.getWorkhour());

        //Getting a reference to the database to write to it
        SQLiteDatabase db = this.getWritableDatabase();

        //Inserting the entry of the table into the database and closing the reference
        db.insert(TABLE_Employee,null,vals);
        db.close();
    }

    public Employee searchEmployees(String email){
        String query = "Select * FROM " + TABLE_Employee + " WHERE " + COLUMN_EEMAIL + " = \"" + email + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        Employee emp = new Employee();

        if(cursor.moveToFirst()){
            emp.setUsername(cursor.getString(0));
            emp.setFirst_name(cursor.getString(1));
            emp.setLast_name(cursor.getString(2));
            emp.setPassword(cursor.getString(3));
            emp.setEmail(cursor.getString(4));
            emp.setNameofCompany(cursor.getString(5));
            emp.setDescription(cursor.getString(6));
            emp.setLicensed(cursor.getString(7));
            emp.setWorkhour(Double.parseDouble(cursor.getString(8)));
            cursor.close();
        }
        else{
            emp = null;
        }
        db.close();
        return emp;
    }

    public Employee searchEmployeeUsername(String username){
        String query = "Select * FROM " + TABLE_Employee + " WHERE " + COLUMN_EUSERNAME + " = \"" + username + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        Employee emp = new Employee();

        if(cursor.moveToFirst()){
            emp.setUsername(cursor.getString(0));
            emp.setFirst_name(cursor.getString(1));
            emp.setLast_name(cursor.getString(2));
            emp.setPassword(cursor.getString(3));
            emp.setEmail(cursor.getString(4));
            emp.setNameofCompany(cursor.getString(5));
            emp.setDescription(cursor.getString(6));
            emp.setLicensed(cursor.getString(7));
            emp.setWorkhour(Double.parseDouble(cursor.getString(8)));
            cursor.close();
        }
        else{
            emp = null;
        }
        db.close();
        return emp;
    }

    public boolean deleteEmployee(String email){
        boolean result = false;
        String SQL = "DELETE FROM " + TABLE_Patient + " WHERE " + COLUMN_EEMAIL + " = \'" + email + "\'";

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(SQL);

        if(searchEmployees(email) == null){
            result = true;
        }

        db.close();
        return result;
    }


    public void addClinic(Clinic clinic){
        ContentValues vals = new ContentValues();

        vals.put(COLUMN_COMPNAME,clinic.getCompanyName());
        vals.put(COLUMN_DESCRIPTION,clinic.getDescription());
        vals.put(COLUMN_ADDRESS,clinic.getAddress());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_Clinic,null,vals);
        db.close();
    }

    public Clinic searchClinics(String companyName){
        String query = "Select * FROM " + TABLE_Service + " WHERE " + COLUMN_COMPNAME + " = \"" + companyName + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        Clinic clinic = new Clinic();

        if(cursor.moveToFirst()){
            clinic.setCompanyName(cursor.getString(0));
            clinic.setDescription(cursor.getString(1));
            clinic.setAddress(cursor.getString(2));
            cursor.close();
        }
        else{
            clinic = null;
        }
        db.close();
        return clinic;
    }

    public boolean deleteClinic(String companyName){
        boolean result = false;
        String SQL = "DELETE FROM " + TABLE_Clinic + " WHERE " + COLUMN_CNAME + " = \'" + companyName + "\'";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL);

        if(searchClinics(companyName) == null){
            result = true;
        }

        db.close();
        return result;
    }

    public void addAdmin(Administrator admin){
        ContentValues vals = new ContentValues();

        vals.put(COLUMN_AUSERNAME,admin.getUsername());
        vals.put(COLUMN_APASSWORD,admin.getPassword());
        vals.put(COLUMN_AFNAME,admin.getFirst_name());
        vals.put(COLUMN_ALNAME,admin.getLast_name());
        vals.put(COLUMN_AEMAIL,admin.getEmail());

        SQLiteDatabase db= this.getWritableDatabase();

        db.insert(TABLE_Admin,null,vals);
        db.close();
    }

    public Administrator searchAdmin(String email){
        String query = "Select * FROM  " + TABLE_Admin + " WHERE " + COLUMN_AEMAIL + " = \"" + email + "\"";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        Administrator admin = new Administrator();

        if(cursor.moveToFirst()){
            admin.setUsername(cursor.getString(0));
            admin.setPassword(cursor.getString(1));
            admin.setFirst_name(cursor.getString(2));
            admin.setLast_name(cursor.getString(3));
            admin.setEmail(cursor.getString(4));
            cursor.close();
        }
        else{
            admin = null;
        }
        db.close();
        return admin;
    }

    public boolean deleteAdmin(String email){

        boolean result = false;
        String SQL = "DELETE FROM " + TABLE_Admin + " WHERE " + COLUMN_AEMAIL + " = \'" + email + "\'";

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(SQL);

        if(searchAdmin(email) == null){
            result = true;
        }

        db.close();
        return result;
    }
}
