package com.example.registration;

import static java.security.AccessController.getContext;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.registration.Model.StudentModel;
import com.example.registration.databinding.ActivityProfileBinding;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        final DBHelper dbHelper = new DBHelper(this);

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

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}