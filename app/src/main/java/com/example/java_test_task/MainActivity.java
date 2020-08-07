package com.example.java_test_task;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView loginTextView = findViewById(R.id.loginHintTextView);
        final TextView passwordTextView = findViewById(R.id.passwordHintTextView);
        final Button signInButton = findViewById(R.id.signInButton);


        final EditText loginEditText = findViewById(R.id.loginEditText);
        final EditText testEditText = findViewById(R.id.testEditText);

        final EditText passwordEditText = findViewById(R.id.passwordEditText);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!Auth.isLoginValid(loginEditText.getText().toString())){
                    loginTextView.setText(Auth.messageToLogin);
                    //ToDo set hint color
                } else {
                    loginTextView.setText("");
                }

                if(!Auth.isPasswordValid(passwordEditText.getText().toString())){
                    passwordTextView.setText(Auth.messageToPassword);
                }
                else {
                    passwordTextView.setText("");
                }
            }
        });


    }


}
