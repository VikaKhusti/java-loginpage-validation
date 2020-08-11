package com.example.java_test_task;

import java.util.regex.Pattern;

public class Auth {

    //these are messages that user have while input
    public static String messageToLogin = "";
    public static String messageToPassword = "";

    public static boolean isLoginValid(String s) {
        if(s.isEmpty()){
            messageToLogin = "Поле не може бути пустим";
            return false;
        } else if(!Pattern.compile( "[a-zA-Z ]" ).matcher(s).find())
        {
            messageToLogin = "Вводьте лише символи латиницею";
            return false;
        } else return true;

    }

    public static boolean isPasswordValid(String s) {
        if(s.isEmpty()){
            messageToPassword = "Поле не може бути пустим";
            return false;
        } else if(!Pattern.compile( "[a-zA-Z]" ).matcher(s).find())
        {
            messageToPassword = "Вводьте лише символи латиницею без пробілів";
            return false;
        } else if(!Pattern.compile( "[0-9]" ).matcher(s).find()){
            messageToPassword = "Щонайменше 1 цифра";
            return false;
        } else if(!Pattern.compile( "(?=.*[A-Z])" ).matcher(s).find()){
            messageToPassword = "Щонайменше 1 велика буква";
            return false;
        } else return true;
    }


}
