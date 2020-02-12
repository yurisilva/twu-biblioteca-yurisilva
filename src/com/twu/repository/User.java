package com.twu.repository;

import java.util.HashMap;
import java.util.Map;

public class User {
    private static Map<String, String> users = new HashMap<>();
    private String loggedUser = "";

    public User(){
        users.put("0000001", "123");
        users.put("1234567", "123");
    }

    public boolean login(String userNumber, String userPassword) {
        if (users.containsKey(userNumber) && users.get(userNumber).equals(userPassword))
        {
            loggedUser = userNumber;
            return true;
        }
        else {
            return false;
        }
    }

    public String getLoggedUser(){
        return loggedUser;
    }

    public boolean isUserLogged() { return loggedUser != ""; }
}
