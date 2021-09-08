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

public class AddTestFragment extends Fragment {

    private EditText testId,patientId,nurseId,BPL,BPH,temperature;
    Button addTest;
    List<Nurse> nurses = SecondMainActivity.patientDB2.hospitalDao().getnurses();
    List<Patient> patients = SecondMainActivity.patientDB2.hospitalDao().getpatients();
    boolean state =false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_test, container, false);

        testId = view.findViewById(R.id.testId);
        patientId = view.findViewById(R.id.patientId2);
        nurseId = view.findViewById(R.id.nurseId2);
        BPL = view.findViewById(R.id.BPL);
        BPH = view.findViewById(R.id.BPH);
        temperature = view.findViewById(R.id.temperature);
        addTest = view.findViewById(R.id.bn_addTest);

        addTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int TestId = Integer.parseInt(testId.getText().toString());
                int PatientId = Integer.parseInt(patientId.getText().toString());
                int NurseId = Integer.parseInt(nurseId.getText().toString());
                boolean bpl = Boolean.parseBoolean(BPL.getText().toString());
                boolean bph = Boolean.parseBoolean(BPH.getText().toString());
                double temp = Double.parseDouble(temperature.getText().toString());


                Test test1 = new Test();
                test1.setTestId(TestId);
                test1.setPatientId(PatientId);
                test1.setNurseId(NurseId);
                test1.setBPH(bph);
                test1.setBPL(bpl);
                test1.setTemperature(temp);

                for (Nurse nur:nurses) {
                    if (NurseId == nur.getNurseId()) {
                        for (Patient pat : patients) {
                            if (PatientId == pat.getPatientId()) {
                                state = true;
                            }
                        }
                    }

                    if (state) {
                        SecondMainActivity.patientDB2.hospitalDao().addAllTest(test1);
                        Toast.makeText(getActivity(),"Test has been added",Toast.LENGTH_SHORT).show();
                        state =false;
                    }
                }



                testId.setText("");
                patientId.setText("");
                nurseId.setText("");
                BPL.setText("");
                BPH.setText("");
                temperature.setText("");

            }
        });

        return view;
    }
}