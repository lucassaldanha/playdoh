package com.lsoftware.playdoh.util;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileUtils {

    public InputStream readFileFromClasspath(String filename) throws FileNotFoundException {
        InputStream in = FileUtils.class.getClassLoader().getResourceAsStream(filename);

        if(in == null) {
            throw new FileNotFoundException("Can't find file " + filename);
        }

        return in;
    }
}
