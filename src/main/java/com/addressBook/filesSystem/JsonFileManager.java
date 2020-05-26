package com.addressBook.filesSystem;

import com.google.gson.Gson;

import java.io.*;

public class JsonFileManager implements FileManager {
    Gson gson = new Gson();

    @Override
    public boolean writeIntoFile(File file, Object object) {

        try {
            Writer writer = new FileWriter(file);
            writer.write(gson.toJson(object));
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean writeIntoFile(String path, Object object) {
        return writeIntoFile(new File(path), object);
    }

    @Override
    public <E> E readFile(String path, Class<E> eClass) throws IOException{
        Reader reader = new FileReader(new File(path));
        BufferedReader bufferedReader = new BufferedReader(reader);
        E book = gson.fromJson(bufferedReader, eClass);
        reader.close();
        return book;
    }

}





