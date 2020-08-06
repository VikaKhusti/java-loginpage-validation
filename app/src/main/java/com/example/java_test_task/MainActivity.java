package com.example.java_test_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView loginTextView = findViewById(R.id.loginHintTextView);
        final TextView passwordTextView = findViewById(R.id.passwordHintTextView);
        final Button signInButton = findViewById(R.id.signInButton);


        final EditText loginEditText = findViewById(R.id.loginEditText);
        loginEditText.setFilters(new InputFilter[] {
                new InputFilter() {
                    public CharSequence filter(CharSequence src, int start,
                                               int end, Spanned dst, int dstart, int dend) {
                        if(src.equals("")){ // for backspace
                            loginTextView.setText(src);
                            return src.toString().trim();
                        }

                        if(src.toString().equals("")){ //ToDo: review
                            loginTextView.setText("");
                            return src.toString().trim();
                        }

                        if(src.toString().matches("[a-zA-Z ]+")){ //for Latin alphabet
                            return src.toString().trim();
                        }
                        else {
                            loginTextView.setText("Allowed only Latin alphabet");
                            signInButton.setEnabled(false);
                        }

                        return loginEditText.getText().toString().trim();

                    }
                }
        });


        final EditText passwordEditText = findViewById(R.id.passwordEditText);
        passwordEditText.setFilters(new InputFilter[] {
                new InputFilter() {
                    public CharSequence filter(CharSequence src, int start,
                                               int end, Spanned dst, int dstart, int dend) {
                        if(src.equals("")){ // for backspace
                            Log.d("TAG", "src" + src);
                            signInButton.setEnabled(false);
                            passwordTextView.setText(src);
                            return src.toString().trim();
                        }
                        if(src.toString().equals("")){
                            signInButton.setEnabled(false);
                            passwordTextView.setText("");
                            return src.toString().trim();
                        }
                        if(src.toString().matches("[a-zA-Z ]+")){
                            //ToDo: allow to input symbols
                            signInButton.setEnabled(false);
                            return src.toString().trim();
                        }
                        else {
                            passwordTextView.setText("Allowed only Latin alphabet");
                            signInButton.setEnabled(false);
                            src = "";
                        }
                        if(!src.equals(src.toString().toLowerCase())){
                            return src.toString().trim();
                            //ToDo: do not go inside this if-statement
                        }
                        else {
                           // passwordTextView.setText("Must be at least 1 uppercase letter");
                        }
                        signInButton.setEnabled(true);
                        return passwordEditText.getText().toString().trim();

                    }
                }
        });

    }

}
