package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClient {
    public static void main(String[] args) throws IOException {
        GreetingClient client = new GreetingClient("127.0.0.1", 6666);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine;
        client.startConnection();
        while((readLine = reader.readLine())!=null){
            client.sendMessage(readLine);
            String response = client.recvMessage();
            System.out.println("received from server: "+response);
        }
        client.stopConnection();




    }
}