package Serialization;

public class MainApp {
    public static void main(String[] args) {
        // starting server in a separate thread
        new Thread(() -> ServerApp.startServer()).start();

        // sending message
        Message message = new Message("User1", "User2", "Hello!");
        ClientApp.sendMessage(message);
    }
}
