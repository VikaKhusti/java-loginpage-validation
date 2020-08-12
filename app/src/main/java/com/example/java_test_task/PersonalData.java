package com.example.java_test_task;

import java.util.regex.Pattern;

public class PersonalData {
    public static String messageToName = "";
    public static String messageToNumber = "";
    public static String messageToEmail = "";

    public static boolean isNameValid(String s) {
        if(s.isEmpty()){
            messageToName = "Поле не може бути пустим";
            return false;
        } else if(!Pattern.matches(".*\\p{InCyrillic}.*", s)){
            messageToName = "Лише символи кирилицею";
            return false;
        } else return true;
    }

    public static boolean isNumberValid(String s) {
        if(s.isEmpty()){
            messageToNumber = "Поле не може бути пустим";
            return false;
        }else if(s.startsWith("+380") || s.startsWith("380")){
            messageToNumber = "Номер вказувати без тел. коду";
            return false;
        }else if(s.length() != 9){
            messageToNumber = "Номер телефону вказано некоректно";
            return false;
        }else if(!s.matches("[0-9]+")){
            messageToNumber = "Номер телефону вказано некоректно";
            return false;
        }else return true;
    }

    public static boolean isEmailValid(String s){
        if(s.isEmpty()){
            messageToEmail = "Поле не може бути пустим";
            return false;
        }else if(!s.contains("@")){
            messageToEmail = "Ел. адреса вказана некоректно";
            return false;
        } else if(!s.contains(".")) {
            messageToEmail = "Ел. адреса вказана некоректно";
            return false;
        }else return true;
    }
}
