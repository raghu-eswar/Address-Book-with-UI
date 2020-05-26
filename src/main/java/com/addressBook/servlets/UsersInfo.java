package com.addressBook.servlets;

import com.addressBook.filesSystem.FileManager;
import com.addressBook.filesSystem.FileManagerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersInfo {

    public List<User> usersList;

    public UsersInfo(String path) throws IOException {
        FileManager fileManager = new FileManagerFactory().getFileManager();
        List<User> list = new ArrayList<>();
        try {
            list = fileManager.readFile(path, UsersInfo.class).usersList;
        } catch (NullPointerException ignored) {}
        this.usersList = list;
    }


}
