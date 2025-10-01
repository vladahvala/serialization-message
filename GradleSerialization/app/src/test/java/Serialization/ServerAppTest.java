package Serialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ServerAppTest {

    @Test
    void testHandleClient() throws IOException {
        // test messages
        Message message1 = new Message("User1", "User2", "Hello!");
        Message message2 = new Message("User3", "User4", "How are you?");
        List<Message> messages = Arrays.asList(message1, message2);

        // redirecting System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // simulating client sending messages
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        for (Message msg : messages) {
            objOut.writeObject(msg);
        }
        objOut.close();

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());

        // Mock Socket
        Socket mockSocket = new Socket() {
            @Override
            public InputStream getInputStream() {
                return byteIn;
            }

            @Override
            public void close() {
            }
        };

        ServerApp.handleClient(mockSocket);

        // capturing and checking console output
        String output = outContent.toString();
        assertTrue(output.contains("User1 -> User2: Hello!"));
        assertTrue(output.contains("User3 -> User4: How are you?"));

        // restoring original System.out
        System.setOut(originalOut);
    }
}
