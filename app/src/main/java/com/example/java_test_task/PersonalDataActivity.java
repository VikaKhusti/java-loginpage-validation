package com.example.java_test_task;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
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
    private EditText emailDateEditText;

    private TextView nameTextView;
    private TextView telTextView;
    private TextView emailTextView;

    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        nameEditText = findViewById(R.id.nameEditText);
        telEditText = findViewById(R.id.telNumEditText);
        birthDateEditText = findViewById(R.id.birthDateEditText);
        emailDateEditText = findViewById(R.id.emailEditText);

        nameTextView = findViewById(R.id.nameTextView);
        telTextView = findViewById(R.id.telTextView);
        emailTextView = findViewById(R.id.emailTextView);

        birthDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataPickerDialog();
            }
        });

        final Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PersonalData.isNameValid(nameEditText.getText().toString())) {
                    nameTextView.setText(PersonalData.messageToName);
                } else {
                    nameTextView.setText("");
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


