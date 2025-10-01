package Serialization;

import java.io.*;

public class ClientApp {
    public static void main(String[] args) throws IOException {
        Message message = new Message("User1", "User2", "Hello, how r u?");
        message.display();

        FileOutputStream fileOut = new FileOutputStream("MessageInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(message);
        out.close();
        fileOut.close();

        System.out.println("Object info saved!");
    }
}
