package com.example.sharedpreferenceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ReadTestFragment extends Fragment {


    private TextView readTestView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_test, container, false);
        readTestView= view.findViewById(R.id.testInfo);
        List<Test> all_tests = SecondMainActivity.patientDB2.hospitalDao().gettests();

        String info = "";

        for (Test tes: all_tests)
        {
            int testid = tes.getTestId();
            int patientid = tes.getPatientId();
            int nurseId = tes.getNurseId();
            boolean BPL = tes.isBPL();
            boolean BPH = tes.isBPL();
            double temperature = tes.getTemperature();

            info = info + "\n\nTest ID: " + testid +"\n" + "Patient ID: " + patientid + "\n" + "Nurse ID: "+nurseId + "\n" + "BPL: " + BPL + "\n" + "BPH: " + BPH + "\n" + "Temperature: " + temperature;
        }

        readTestView.setText(info);
        return view;
    }
}