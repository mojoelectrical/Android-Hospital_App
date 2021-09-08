package com.example.sharedpreferenceapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HospitalDao {

    @Insert
    public void addPatient(Patient patient);

    @Insert
    public void addAllTest(Test test);

    @Insert
    public void addNurse(Nurse nurse);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Patient patient);

    @Query("select * from patient")
    public List<Patient> getpatients();

    @Query("select * from test")
    public List<Test> gettests();

    @Query("select * from nurse")
    public List<Nurse>  getnurses();


}
