package Serialization;

import java.io.*;

public class ServerApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(
                "D:\\3 курс\\ООП\\problems\\serialization-message\\GradleSerialization\\MessageInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        Message message = (Message) in.readObject();
        in.close();
        fileIn.close();

        message.display();
    }
}
