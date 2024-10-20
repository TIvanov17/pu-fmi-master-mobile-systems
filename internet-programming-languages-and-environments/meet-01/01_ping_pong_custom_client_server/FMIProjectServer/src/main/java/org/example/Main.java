package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

  private static final int SERVER_PORT = 1423;
  private static final int COUNT_BREAK = 10;
  private static final int COMMON_CODE = 9;
  private static final int EXIT_CODE = 1;

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
    System.out.println("Server start");

    Socket connectionSocket = serverSocket.accept();
    System.out.println("Waiting for connection");

    InputStream request = connectionSocket.getInputStream();
    OutputStream response = connectionSocket.getOutputStream();

    int iterationCount = 0;
    while(connectionSocket.isConnected()){
      // write response to client
      if(iterationCount == COUNT_BREAK){
        response.write(EXIT_CODE);
      }else{
        response.write(COMMON_CODE);
      }
      System.out.println("Response From Client: " + request.read());
      iterationCount++;
    }

    request.close();
    response.close();
    connectionSocket.close();
    System.out.println("Server end");
  }
}