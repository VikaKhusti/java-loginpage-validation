package com.example.java_test_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class MainActivity extends AppCompatActivity {

    private TextView loginTextView;
    private TextView passwordTextView;

    private Button signInButton;

    private EditText loginEditText;
    private EditText passwordEditText;

    private String _login;
    private String _password;

    private int count = 0;

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

        loginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!Auth.isLoginValid(loginEditText.getText().toString())){
                    // if login is invalid then show error message
                    loginTextView.setText(Auth.messageToLogin);
                } else {
                    //if login is valid then hide error message
                    _login = loginEditText.getText().toString();
                    loginTextView.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!Auth.isPasswordValid(passwordEditText.getText().toString())){
                    passwordTextView.setText(Auth.messageToPassword);
                }
                else {
                    _password = passwordEditText.getText().toString();
                    passwordTextView.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (Auth.isLoginValid(_login) && Auth.isPasswordValid(_password)){
                        startPersonalDataActivity();
                    }
                } catch (Exception e) {
                    count++;
                    if(count == 3){
                        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
                    Toast toast=Toast.makeText(getApplicationContext(),"Перевірьте введені дані",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

    }
    public void startPersonalDataActivity(){
        Intent intent = new Intent(this, PersonalDataActivity.class);
        startActivity(intent);
    }
}
