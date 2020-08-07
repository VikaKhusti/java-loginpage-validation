package com.example.java_test_task;

import java.util.regex.Pattern;

public class Auth {

    public static String messageToLogin = "";
    public static String messageToPassword = "";

    public static boolean isLoginValid(String s) {
        if(s.isEmpty()){
            messageToLogin = "Field cannot be empty";
            return false;
        } else if(!Pattern.compile( "[a-zA-Z ]" ).matcher(s).find())
        {
            messageToLogin = "Allowed only Latin alphabet";
            return false;
        } else return true;

    }

    public static boolean isPasswordValid(String s) {
        if(s.isEmpty()){
            messageToPassword = "Field cannot be empty";
            return false;
        } else if(!Pattern.compile( "[a-zA-Z]" ).matcher(s).find())
        {
            messageToPassword = "Allowed only Latin alphabet without spaces";
            return false;
        } else if(!Pattern.compile( "[0-9]" ).matcher(s).find()){
            messageToPassword = "At least 1 digit";
            return false;
        } else if(!Pattern.compile( "(?=.*[A-Z])" ).matcher(s).find()){
            messageToPassword = "At least 1 uppercase letter";
            return false;
        } else return true;
    }


}
