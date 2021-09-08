package com.example.sharedpreferenceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class AddPatientFragment extends Fragment {

    private EditText patientId, firstname, lastname, department, nurseId, room;
    private Button bn_SavePatient;
    List<Nurse> nurses = SecondMainActivity.patientDB2.hospitalDao().getnurses();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_patient, container, false);
        patientId = view.findViewById(R.id.patientId);
        firstname = view.findViewById(R.id.patientfirstname);
        lastname = view.findViewById(R.id.patientlastname);
        department = view.findViewById(R.id.patientdepartment);
        nurseId = view.findViewById(R.id.nurseId);
        room = view.findViewById(R.id.patientroom);
        bn_SavePatient = view.findViewById(R.id.savePatient);

      bn_SavePatient.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              int patId = Integer.parseInt(patientId.getText().toString());
              String first = firstname.getText().toString();
              String last = lastname.getText().toString();
              String depart = department.getText().toString();
              int nurse = Integer.parseInt(nurseId.getText().toString());
              int room_1 = Integer.parseInt(room.getText().toString());

              Patient patient1 = new Patient();
              patient1.setPatientId(patId);
              patient1.setFirstname(first);
              patient1.setLastname(last);
              patient1.setDepartment(depart);
              patient1.setNurseId(nurse);
              patient1.setRoom(room_1);

              for (Nurse nur:nurses){
                  if (nurse == nur.getNurseId()){
                      Toast.makeText(getActivity(), "Patient has been added", Toast.LENGTH_SHORT).show();
                      SecondMainActivity.patientDB2.hospitalDao().addPatient(patient1);
              }else{
                      Toast.makeText(getActivity(), "Nurse profile has not been created", Toast.LENGTH_SHORT).show();
                  }
              }

              patientId.setText("");
              firstname.setText("");
              lastname.setText("");
              department.setText("");
              nurseId.setText("");
              room.setText("");

          }
      });
        return view;
    }
}