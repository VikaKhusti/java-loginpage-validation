package com.example.java_test_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private TextView loginTextView;
    private TextView passwordTextView;

    private Button signInButton;

    private EditText loginEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Sign in");

        loginTextView = findViewById(R.id.loginHintTextView);
        passwordTextView = findViewById(R.id.passwordHintTextView);

        signInButton = findViewById(R.id.signInButton);

        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                short isValid = -1;
                if(!Auth.isLoginValid(loginEditText.getText().toString())){
                    loginTextView.setText(Auth.messageToLogin);
                    //ToDo set hint color
                } else {
                    loginTextView.setText("");
                    isValid = 0;
                }

                if(!Auth.isPasswordValid(passwordEditText.getText().toString())){
                    passwordTextView.setText(Auth.messageToPassword);
                }
                else {
                    passwordTextView.setText("");
                    isValid = 1;
                }

                if(isValid == 1){
                    startPersonalDataActivity();
                }
            }
        });

    }
    public void startPersonalDataActivity(){
        Intent intent = new Intent(this, PersonalDataActivity.class);
        startActivity(intent);
    }


}
