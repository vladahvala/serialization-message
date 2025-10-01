package Serialization;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000...");

            Socket socket = serverSocket.accept();
            handleClient(socket);

            System.out.println("All messages received. Shutting down server...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
            System.out.println("Client connected!");
            Message message;

            while (true) {
                try {
                    message = (Message) in.readObject();
                    message.display();
                } catch (EOFException e) {
                    System.out.println("Client disconnected.");
                    break; // Сlient ended the socket
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
