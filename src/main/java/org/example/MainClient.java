package org.example;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        GreetingClient client = new GreetingClient("127.0.0.1", 6666);
        client.startConnection();
        client.sendMessage("hello server");
        String response = client.recvMessage();

    }
}