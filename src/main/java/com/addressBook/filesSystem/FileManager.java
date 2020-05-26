package com.addressBook.filesSystem;

import java.io.File;
import java.io.IOException;

public interface FileManager {

    boolean writeIntoFile(File file, Object object)throws IOException;
    public boolean writeIntoFile(String path, Object object);
    <E> E readFile(String path, Class<E> eClass)throws IOException;
}
