package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        EchoServer server=new EchoServer(6666);
        server.start();

    }
}