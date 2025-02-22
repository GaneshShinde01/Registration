package com.example.registration;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView fname,lname,email,date,password;
    private Button select_date,register;
    private RadioGroup gender;
    private RadioButton male,female;
    private CheckBox policy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fname = findViewById(R.id.etfname);
        lname = findViewById(R.id.etlname);
        email = findViewById(R.id.etemail);
        date = findViewById(R.id.etdate);
        password = findViewById(R.id.etpassword);
        select_date = findViewById(R.id.btndate);
        register = findViewById(R.id.btnregister);
        gender = findViewById(R.id.gender);
        male = findViewById(R.id.rbmale);
        female = findViewById(R.id.rbfemale);
        policy = findViewById(R.id.policy);

        String first_name = fname.getText().toString();
        String last_name = lname.getText().toString();
        String dates = select_date.getText().toString();
        Toast.makeText(this, ""+first_name+last_name+date, Toast.LENGTH_SHORT).show();
        findViewById(R.id.btndate).setOnClickListener(v->{
            DatePickerDialog dialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {date.setText("date");},12,12,12);
        });
    }
}