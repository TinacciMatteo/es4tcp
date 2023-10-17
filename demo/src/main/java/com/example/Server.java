import java.io.*;
import java.net.*;

public class erver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server in ascolto sulla porta 6789...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connessione accettata da " + clientSocket);

            Thread t = new Thread(() -> {
                try {
                    ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                    System.out.println("invio del file");
                    FileInputStream FileInputStream = new FileInputStream("./src/main/resources/images/artworks-Qyo22qbHLCezysCU-7BiDIw-t500x500.jpg");
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = FileInputStream.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                    System.out.println("file inviato con successo.");
                    FileInputStream.close();
                    out.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            t.start();
        }
    }
}
