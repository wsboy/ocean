package com.wesboy.ocean.File;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class BIOClient {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8080);

            OutputStream os = client.getOutputStream();

            String name = UUID.randomUUID().toString();

            //发送给服务端
            os.write(name.getBytes());
            os.close();
            client.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
