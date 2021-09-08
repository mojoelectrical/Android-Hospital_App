package com.example.sharedpreferenceapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Patient.class, Test.class,Nurse.class}, version = 1)
public abstract class PatientDB extends RoomDatabase {

    public abstract HospitalDao hospitalDao();
}
