package Serialization;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientApp {

    public static void sendMessage(List<Message> messages) {
        try (Socket socket = new Socket("localhost", 5000);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            for (Message msg : messages) {
                out.writeObject(msg); // sending every msg
                System.out.println("Message sent to server!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // separate method for Junit tests
    public static void sendMessagesToStream(List<Message> messages, ObjectOutputStream out) throws IOException {
        for (Message msg : messages) {
            out.writeObject(msg);
        }
    }
}
