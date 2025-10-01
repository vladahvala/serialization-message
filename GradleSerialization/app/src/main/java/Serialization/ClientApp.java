package Serialization;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp {

    public static void sendMessage(Message message) {
        try (Socket socket = new Socket("localhost", 5000);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
            out.writeObject(message);
            System.out.println("Message sent to server!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
