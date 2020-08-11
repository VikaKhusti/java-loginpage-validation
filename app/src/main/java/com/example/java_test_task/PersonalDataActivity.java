package com.example.java_test_task;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class PersonalDataActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText birthDateEditText;
    private EditText nameEditText;
    private EditText telEditText;
    private EditText emailEditText;

    private String _name;
    private String _tel;
    private String _email;
    private String _date;

    private TextView nameTextView;
    private TextView telTextView;
    private TextView emailTextView;
    private TextView dateTextView;

    private Button saveButton;


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

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!PersonalData.isNameValid(nameEditText.getText().toString())) {
                    nameTextView.setText(PersonalData.messageToName);
                } else {
                    nameTextView.setText("");
                    _name = nameEditText.getText().toString();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        telEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!PersonalData.isNumberValid(telEditText.getText().toString())){
                    telTextView.setText(PersonalData.messageToNumber);
                } else {
                    _tel = telEditText.getText().toString();
                    telTextView.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!PersonalData.isEmailValid(emailEditText.getText().toString())){
                    emailTextView.setText(PersonalData.messageToEmail);
                }else {
                    _email = emailEditText.getText().toString();
                    emailTextView.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

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
                if(birthDateEditText.getText().toString().isEmpty()){
                    dateTextView.setText("Вкажіть дату народження");
                } else {
                    dateTextView.setText("");
                }
                if(PersonalData.isNameValid(_name) && PersonalData.isNumberValid(_tel) &&
                        !birthDateEditText.getText().toString().isEmpty() && PersonalData.isEmailValid(_email)){
                    Toast toast=Toast.makeText(getApplicationContext(),"Зміни збережено",Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Toast toast=Toast.makeText(getApplicationContext(),"Будь ласка, перевітре введені дані",Toast.LENGTH_SHORT);
                    toast.show();
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
        _date = "" + dayOfMonth + "/" + month + "/" + year;
        birthDateEditText.setText(_date.toString());
    }


}


