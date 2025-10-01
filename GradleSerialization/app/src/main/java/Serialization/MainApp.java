package Serialization;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // starting server in a separate thread
        new Thread(() -> ServerApp.startServer()).start();

        // sending messages
        Message message1 = new Message("User1", "User2", "Hello!");
        Message message2 = new Message("User3", "User4", "How are you?");
        Message message3 = new Message("User5", "User6", "Goodbye");
        List<Message> messagesToSend = Arrays.asList(message1, message2, message3);
        ClientApp.sendMessage(messagesToSend);
    }
}
