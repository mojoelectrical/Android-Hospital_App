package com.example.sharedpreferenceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class    ReadPatientFragment extends Fragment {

    private TextView patientView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_patient, container, false);

        patientView = view.findViewById(R.id.patientInfo);
        List<Patient> patients = SecondMainActivity.patientDB2.hospitalDao().getpatients();

        String info ="";

        for (Patient pati:patients)
        {
            int id = pati.getPatientId();
            String firstname = pati.getFirstname();
            String lastname = pati.getLastname();
            String department = pati.getDepartment();
            int nurseId = pati.getNurseId();
            int room = pati.getRoom();

            info = info + "\n\n Patient ID: " + id +"\n" + "Name: "+ firstname + " " + lastname + "\n" + "Department: " + department + "\n" +"Nurse ID: "+ nurseId + "\n" + "Room: " + room;
        }

        patientView.setText(info);
        return view;

    }
}