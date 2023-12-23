package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GreetingClient {
    private Socket clientSocket;
    private int serverPort;
    private String serverIp;
    private PrintWriter out;
    private BufferedReader in;

    public GreetingClient(String serverIp,int serverPort){
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }
    public void startConnection() throws IOException {
        clientSocket = new Socket(this.serverIp,this.serverPort);
        out = new PrintWriter(clientSocket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String line = in.readLine();
        return line;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }


}
