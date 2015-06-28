package com.lsoftware.playdoh.util;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

public class FileUtilsTest {

    private FileUtils fileUtils = new FileUtils();

    @Test
    public void testReadExistentFileFromClasspathSucceeds() throws Exception {
        InputStream inputStream = fileUtils.readFileFromClasspath("user.yml");
        assertNotNull(inputStream);
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadAbsentFileFromClasspathThrowsFileNotFoundException() throws Exception {
        InputStream inputStream = fileUtils.readFileFromClasspath("absent.yml");
    }
}