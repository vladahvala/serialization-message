package Serialization;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

class MessageTest {

    @Test
    void testMessageCreation() {
        Message msg = new Message("Alice", "Bob", "Hello!");
        assertEquals("Alice", msg.getSender());
        assertEquals("Bob", msg.getRecipient());
        assertEquals("Hello!", msg.getText());
        assertNotNull(msg.getTimestamp());
        assertTrue(msg.getTimestamp().isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    void testDisplay() {
        Message msg = new Message("Alice", "Bob", "Hello!");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        msg.display();
        String output = outContent.toString();

        assertTrue(output.contains("Alice -> Bob: Hello!"));
    }

}
