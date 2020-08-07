package com.example.java_test_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersonalDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        final EditText nameEditText = findViewById(R.id.nameEditText);
        final EditText telEditText = findViewById(R.id.telNumEditText);
        final EditText birthDateEditText = findViewById(R.id.birthDateEditText);
        final EditText emailDateEditText = findViewById(R.id.emailEditText);

        final TextView nameTextView = findViewById(R.id.nameTextView);
        final TextView telTextView = findViewById(R.id.telTextView);
        final TextView birthDateTextView = findViewById(R.id.birthTextView);
        final TextView emailTextView = findViewById(R.id.emailTextView);

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
}


