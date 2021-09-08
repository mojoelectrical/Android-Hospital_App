package com.example.sharedpreferenceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import com.example.sharedpreferenceapp.ui.login.LoginActivity;

public class SecondMainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager2;
    public static PatientDB testDB;
    public static PatientDB patientDB2;
    boolean start=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);
        if (start){
            start=false;
        Intent intent = new Intent(SecondMainActivity.this, LoginActivity.class);
        startActivity(intent);}
        fragmentManager2 = getSupportFragmentManager();

        testDB = Room.databaseBuilder(getApplicationContext(),PatientDB.class,"Test DataBase").allowMainThreadQueries().build();
        patientDB2 = Room.databaseBuilder(getApplicationContext(),PatientDB.class,"Patient DataBase").allowMainThreadQueries().build();
        //nurseDB = Room.databaseBuilder(getApplicationContext(),PatientDB.class,"Nurse DataBase").allowMainThreadQueries().build();

        View status = findViewById(R.id.fragment_container2);

        if (status != null){
            if (savedInstanceState != null){
                return;
            }
            fragmentManager2.beginTransaction().add(R.id.fragment_container2, new NavigatorFragment()).commit();
        }


    }
}