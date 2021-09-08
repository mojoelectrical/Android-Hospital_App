package com.example.sharedpreferenceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdatePatientFragment extends Fragment {

    private EditText update_firstname, update_lastname, update_department, update_nurseId, update_room;
    protected EditText update_patientId;
    private Button update_bn_SavePatient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_patient, container, false);

        update_patientId = view.findViewById(R.id.updatepatientId);
        update_firstname = view.findViewById(R.id.updatepatientfirstname);
        update_lastname = view.findViewById(R.id.updatepatientlastname);
        update_department = view.findViewById(R.id.updatepatientdepartment);
        update_nurseId = view.findViewById(R.id.updatenurseId);
        update_room = view.findViewById(R.id.updatepatientroom);
        update_bn_SavePatient = view.findViewById(R.id.updatesavePatient);

        update_bn_SavePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int patId = Integer.parseInt(update_patientId.getText().toString());
                String first = update_firstname.getText().toString();
                String last = update_lastname.getText().toString();
                String depart = update_department.getText().toString();
                int nurse = Integer.parseInt(update_nurseId.getText().toString());
                int room_1 = Integer.parseInt(update_room.getText().toString());

                Patient patient1 = new Patient();
                patient1.setPatientId(patId);
                patient1.setFirstname(first);
                patient1.setLastname(last);
                patient1.setDepartment(depart);
                patient1.setNurseId(nurse);
                patient1.setRoom(room_1);

                SecondMainActivity.patientDB2.hospitalDao().insert(patient1);
                Toast.makeText(getActivity(),"Patient has been added",Toast.LENGTH_SHORT).show();


                update_patientId.setText("");
                update_firstname.setText("");
                update_lastname.setText("");
                update_department.setText("");
                update_nurseId.setText("");
                update_room.setText("");

            }
        });

        return view;
    }
}