package com.example.registration.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registration.DBHelper;
import com.example.registration.Model.StudentModel;
import com.example.registration.R;
import com.example.registration.databinding.FragmentProfileBinding;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;




    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false);

        binding = FragmentProfileBinding.inflate(inflater,container,false);

        final DBHelper dbHelper = new DBHelper(getContext());

        ArrayList<StudentModel> list = dbHelper.getStudents();

        if(!list.isEmpty()){

            StudentModel studentModel = list.get(0);

            binding.fname.setText(studentModel.getFname());
            binding.lname.setText(studentModel.getLname());
            binding.mail.setText(studentModel.getMail());
            binding.gender.setText(studentModel.getGender());
            binding.dob.setText(studentModel.getDob());
            binding.password.setText(studentModel.getPassword());
        }
        else {
            binding.fname.setText("No data found");
            binding.lname.setText("No data found");
            binding.mail.setText("No data found");
            binding.gender.setText("No data found");
            binding.dob.setText("No data found");
            binding.password.setText("No data found");
        }
        return binding.getRoot();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}