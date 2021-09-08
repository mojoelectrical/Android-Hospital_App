package com.example.sharedpreferenceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button bn_addpatient, bn_viewpatient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bn_addpatient = view.findViewById(R.id.bn_add_Patient);
        bn_addpatient.setOnClickListener(this);
        bn_viewpatient = view.findViewById(R.id.bn_Viewpatient);
        bn_viewpatient.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bn_add_Patient:
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddPatientFragment()).addToBackStack(null).commit();
            break;
            case R.id.bn_Viewpatient:
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadPatientFragment()).addToBackStack(null).commit();
            break;
        }


    }
}