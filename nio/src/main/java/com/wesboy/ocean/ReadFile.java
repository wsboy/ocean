package com.wesboy.ocean;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
