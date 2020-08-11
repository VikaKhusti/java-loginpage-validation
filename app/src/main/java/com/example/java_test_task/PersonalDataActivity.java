package com.example.java_test_task;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class PersonalDataActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText birthDateEditText;
    private EditText nameEditText;
    private EditText telEditText;
    private EditText emailEditText;

    private TextView nameTextView;
    private TextView telTextView;
    private TextView emailTextView;
    private TextView dateTextView;

    private Button saveButton;

    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        getSupportActionBar().setTitle("Personal Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameEditText = findViewById(R.id.nameEditText);
        telEditText = findViewById(R.id.telNumEditText);
        birthDateEditText = findViewById(R.id.birthDateEditText);
        emailEditText = findViewById(R.id.emailEditText);

        nameTextView = findViewById(R.id.nameTextView);
        telTextView = findViewById(R.id.telTextView);
        emailTextView = findViewById(R.id.emailTextView);
        dateTextView = findViewById(R.id.dateTextView);

        birthDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataPickerDialog();
            }
        });

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PersonalData.isNameValid(nameEditText.getText().toString())) {
                    nameTextView.setText(PersonalData.messageToName);
                } else {
                    nameTextView.setText("");
                }
                if(!PersonalData.isNumberValid(telEditText.getText().toString())){
                    telTextView.setText(PersonalData.messageToNumber);
                    Log.d("TAG", "" + telEditText.getText().toString().length());
                    Log.d("TAG", "" + (telEditText.getText().toString().length() != 9));
                } else {
                    telTextView.setText("");
                }
                if(birthDateEditText.getText().toString().equals("")){
                    dateTextView.setText("Вкажіть дату народження");
                } else {
                    dateTextView.setText("");
                }
                if(!PersonalData.isEmailValid(emailEditText.getText().toString())){
                    emailTextView.setText(PersonalData.messageToEmail);
                }else {
                    emailTextView.setText("");
                }
            }
        });


    }
    private void showDataPickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month++;
        date = "" + dayOfMonth + "/" + month + "/" + year;
        birthDateEditText.setText(date.toString());
    }
}


