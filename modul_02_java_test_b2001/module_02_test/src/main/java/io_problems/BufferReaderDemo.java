package io_problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {
    /**
     *
     *  Use BufferReader to read from buffer while reading Key-To-Success.txt from main/java/resources
     *
     * */
    public static void main(String[] args) throws IOException {

        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") +"/modul_02_java_test_b2001/module_02_test/src/main/resources/Key-To-Success"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}
