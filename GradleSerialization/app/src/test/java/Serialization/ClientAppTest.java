package Serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ClientAppTest {
    @Test
    void testSendMessagesToStream() throws IOException, ClassNotFoundException {
        Message message1 = new Message("User1", "User2", "Hello!");
        Message message2 = new Message("User3", "User4", "How are you?");
        List<Message> messages = Arrays.asList(message1, message2);

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);

        ClientApp.sendMessagesToStream(messages, out);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);

        Message read1 = (Message) in.readObject();
        Message read2 = (Message) in.readObject();

        assertEquals("User1", read1.getSender());
        assertEquals("User2", read1.getRecipient());
        assertEquals("Hello!", read1.getText());

        assertEquals("User3", read2.getSender());
        assertEquals("User4", read2.getRecipient());
        assertEquals("How are you?", read2.getText());
    }
}
