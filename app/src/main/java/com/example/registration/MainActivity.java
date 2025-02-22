package com.example.registration;

import static java.security.AccessController.getContext;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.registration.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String fname, lname, mail, gender, dob, password;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper dbHelper = new DBHelper(this);

        // Date Picker for Date of Birth
        binding.btnselectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        binding.etdate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        // Register Button
        binding.btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // Get user input
                fname = binding.etfname.getText().toString();
                lname = binding.etlname.getText().toString();
                mail = binding.etmail.getText().toString();
                dob = binding.etdate.getText().toString();
                password = binding.etpassword.getText().toString();

                // Check which gender is selected
                int selectedGenderId = binding.gender.getCheckedRadioButtonId();
                if (selectedGenderId == R.id.rbmale) {
                    gender = "male";
                } else if (selectedGenderId == R.id.rbfemale) {
                    gender = "female";
                } else {
                    gender = "";
                }

                // Validation: Ensure all fields are filled and checkbox is checked
                if (!fname.isEmpty() && !lname.isEmpty() && !mail.isEmpty() && !dob.isEmpty() && !password.isEmpty() && !gender.isEmpty() && binding.policy.isChecked()) {
                    // Registration logic here

                    boolean isInserted = dbHelper.insertStudent(
                            fname,lname,mail,gender,dob,password
                    );

                    if (isInserted)
                        Toast.makeText(MainActivity.this, "Student Registration Successful", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "Registration  failed!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Please fill all details and accept the policy", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
