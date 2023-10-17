package com.example;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789);
        System.out.println("Connesso al server");
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        FileOutputStream FileOutputStream = new FileOutputStream("./src/main/resources/images/artworks-Qyo22qbHLCezysCU-7BiDIw-t500x500.jpg");
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = in.read(buffer)) > 0) {
            FileOutputStream.write(buffer, 0, bytesRead);
        }

        System.out.println("File scaricato con successo");
        FileOutputStream.close();
        in.close();
        socket.close();
    }
}

