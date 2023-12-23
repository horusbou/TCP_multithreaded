import org.example.GreetingClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Client_Greeting_Server {

    @Test
    public void greetingTheServer() throws IOException {
        GreetingClient client = new GreetingClient("127.0.0.1", 6666);
        client.startConnection();
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }
}
