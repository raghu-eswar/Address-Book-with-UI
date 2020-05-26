package com.addressBook.servlets;

import java.util.ArrayList;
import java.util.List;

public class User {
    String userName;
    String password;
    public List<String> addressBookNames;
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.addressBookNames = new ArrayList<>();
    }

    public User() {

    }
}
