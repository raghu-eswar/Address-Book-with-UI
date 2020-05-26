package com.addressBook.filesSystem;

public class FileManagerFactory {

    public FileManager getFileManager() {
        return new JsonFileManager();
    }
}
