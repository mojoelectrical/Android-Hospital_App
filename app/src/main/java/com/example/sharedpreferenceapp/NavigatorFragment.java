package com.example.sharedpreferenceapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sharedpreferenceapp.ui.login.LoginActivity;

public class NavigatorFragment extends Fragment implements View.OnClickListener{

    private Button bn_logout, bn_addview_patient, bn_add_test, bn_view_test, bn_update_patient;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigator, container, false);

        bn_logout = view.findViewById(R.id.bn_nav_logout);
        bn_addview_patient = view.findViewById(R.id.bn_nav_addview);
        bn_add_test= view.findViewById(R.id.bn_nav_addtest);
        bn_view_test = view.findViewById(R.id.bn_nav_viewtest);
        bn_update_patient = view.findViewById(R.id.bn_nav_updatepatient);
        bn_logout.setOnClickListener(this);
        bn_addview_patient.setOnClickListener(this);
        bn_view_test.setOnClickListener(this);
        bn_add_test.setOnClickListener(this);
        bn_update_patient.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bn_nav_logout:
                Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.bn_nav_addtest:
                SecondMainActivity.fragmentManager2.beginTransaction().replace(R.id.fragment_container2, new AddTestFragment()).addToBackStack(null).commit();

                break;
            case R.id.bn_nav_addview:
                Intent intent3 = new Intent(getActivity(), MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.bn_nav_viewtest:
                SecondMainActivity.fragmentManager2.beginTransaction().replace(R.id.fragment_container2, new ReadTestFragment()).addToBackStack(null).commit();
                break;
            case R.id.bn_nav_updatepatient:
                SecondMainActivity.fragmentManager2.beginTransaction().replace(R.id.fragment_container2, new UpdatePatientFragment()).addToBackStack(null).commit();
                break;

        }
    }
}