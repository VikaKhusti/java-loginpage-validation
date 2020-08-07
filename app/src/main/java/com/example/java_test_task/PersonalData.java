package com.example.java_test_task;

import java.util.regex.Pattern;

public class PersonalData {
    public static String messageToName = "";

    public static boolean isNameValid(String s) {
        if(s.isEmpty()){
            messageToName = "Поле не може бути пустим";
            return false;
        } else if(Pattern.matches(".*\\p{InCyrillic}.*", s)){
            messageToName = "Лише символи кирилицею";
            return false;
        } else return true;
    }
}
