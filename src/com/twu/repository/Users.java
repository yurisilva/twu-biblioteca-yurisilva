package com.twu.repository;

import com.twu.beans.User;
import java.util.ArrayList;
import java.util.List;

public class Users {
    private static List<User> users = new ArrayList<>();
    private String loggedUser = "";

    public Users() {
        users = new ArrayList<User>() {
            {
                add(new User("1234567", "123","Joey Tribbiani","joey@friends.com","(919)641-8490"));
                add(new User("0000001", "123","Scar","scar@lionking.com","(919)641-8890"));
            }
        };
    }

    public boolean login(String userNumber, String userPassword) {
        for (User user: users) {
            if (user.getLibraryNumber().equals(userNumber) && user.myPasswordIs(userPassword))
            {
                loggedUser = userNumber;
                return true;
            }
        }

        return false;
    }

    public String getLoggedUser(){
        return loggedUser;
    }

    public boolean isUserLogged() { return loggedUser != ""; }

    public String getUserInfo(String loggedUser) {
        try {
            User user = getUserById(loggedUser);
            if (user != null) return String.format("%s\n%s\n%s", user.getName(), user.getEmail(), user.getPhoneNumber());

        } catch (Exception e) {

        }

        return "User not found.";
    }

    private User getUserById(String loggedUser) throws Exception{
        for (User user : users) {
            if (user.getLibraryNumber().equals(loggedUser)) {
                return user;
            }
        }

        throw new Exception("User not found!");

    }
}
