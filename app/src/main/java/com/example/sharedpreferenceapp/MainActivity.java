package com.example.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static PatientDB patientDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();

        patientDB = Room.databaseBuilder(getApplicationContext(),PatientDB.class,"hospitalDB").allowMainThreadQueries().build();
        View status = findViewById(R.id.fragment_container);

        if (status != null){
            if (savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        }

    }






}