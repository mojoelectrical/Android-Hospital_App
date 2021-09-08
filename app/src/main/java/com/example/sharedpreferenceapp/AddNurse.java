package com.example.sharedpreferenceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNurse extends AppCompatActivity implements View.OnClickListener {

    private TextView nurseId,nursefirstname, nurselastname, nursedepartment, nursepassword;
    private Button bn_create_nurse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nurse);

        nurseId= (TextView)findViewById(R.id.nurseId3);
        nursefirstname = (TextView) findViewById(R.id.nurstfirstname);
        nurselastname = (TextView) findViewById(R.id.nurselastname);
        nursedepartment = (TextView) findViewById(R.id.nursedepartment);
        nursepassword = (TextView) findViewById(R.id.nursepassword);
        bn_create_nurse = (Button) findViewById(R.id.bn_create_nurseaccount);
        bn_create_nurse.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int Id = Integer.parseInt(nurseId.getText().toString());
            String first = nursefirstname.getText().toString();
            String last = nurselastname.getText().toString();
            String depart = nursedepartment.getText().toString();
            String password = nursepassword.getText().toString();

            Nurse nurse2 = new Nurse();
            nurse2.setNurseId(Id);
            nurse2.setFirstname(first);
            nurse2.setLastname(last);
            nurse2.setDepartment(depart);
            nurse2.setPassword(password);


            SecondMainActivity.patientDB2.hospitalDao().addNurse(nurse2);
            Toast.makeText(getApplicationContext(),"Nurse successfully created",Toast.LENGTH_LONG).show();

            nurseId.setText("");
            nursefirstname.setText("");
            nurselastname.setText("");
            nursedepartment.setText("");
            nursepassword.setText("");

            Intent intent1 = new Intent(AddNurse.this,SecondMainActivity.class);
            startActivity(intent1);
        }

    }

