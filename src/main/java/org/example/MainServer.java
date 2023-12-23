package org.example;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException {
        GreetingServer server=new GreetingServer(6666);
        server.start();

    }
}