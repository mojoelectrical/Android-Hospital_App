package com.example.sharedpreferenceapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Test {

    @PrimaryKey
    private int testId;
    @ColumnInfo(name = "patientId2")
    private int patientId;
    @ColumnInfo(name = "nurseId2")
    private int nurseId;
    @ColumnInfo(name = "BPH")
    private boolean BPH;
    @ColumnInfo(name = "BPL")
    private boolean BPL;
    @ColumnInfo(name = "temperature")
    private double temperature;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public boolean isBPH() {
        return BPH;
    }

    public void setBPH(boolean BPH) {
        this.BPH = BPH;
    }

    public boolean isBPL() {
        return BPL;
    }

    public void setBPL(boolean BPL) {
        this.BPL = BPL;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
