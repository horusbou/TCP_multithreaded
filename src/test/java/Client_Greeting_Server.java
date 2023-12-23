import org.example.GreetingClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Client_Greeting_Server {

    @Test
    public void greetingTheEchoServer() throws IOException {
        GreetingClient client = new GreetingClient("127.0.0.1", 6666);
        client.startConnection();
        String response = client.sendMessage("hello server");
        String response2 = client.sendMessage("hello server 2");
        String response3 = client.sendMessage("hello server 3");
        assertEquals("hello server", response);
        assertEquals("hello server 2", response2);
        assertEquals("hello server 3", response3);
    }
}
