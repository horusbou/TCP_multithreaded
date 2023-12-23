package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer  {
    private ServerSocket serverSocket;
    private int port;
    public GreetingServer(int port){
        this.port = port;
    }


    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        while (true){
            new ClientMultiThreadHandler(serverSocket.accept()).start();
        }

    }

    private static class ClientMultiThreadHandler extends Thread{
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private static int i=0;

        public ClientMultiThreadHandler(Socket socket){
            this.clientSocket  = socket;
            this.setName(String.valueOf(i++));
        }
        public void run(){

            try {
                out = new PrintWriter(clientSocket.getOutputStream(),true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }
                    System.out.println("received from client"+this.getName()+": "+inputLine);
                    out.println(inputLine);
                }
                this.stopClientConnection();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void stopClientConnection()  {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }




}
