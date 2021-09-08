package com.example.sharedpreferenceapp;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Patient {
    @PrimaryKey
    private int patientId;
    @ColumnInfo(name = "patientfirstname")
    private String firstname;
    @ColumnInfo(name="patientlastname")
    private String lastname;
    @ColumnInfo(name ="patientdepartment")
    private String department;
    @ColumnInfo(name = "nurseId")
    private int nurseId;
    @ColumnInfo(name ="patientroom")
    private int room;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
