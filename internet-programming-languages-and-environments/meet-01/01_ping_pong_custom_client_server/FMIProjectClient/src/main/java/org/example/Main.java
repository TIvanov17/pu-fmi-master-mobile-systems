package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

  private static final int SERVER_PORT = 1423;

  private static final int REQUEST_CODE = 8;

  public static void main(String[] args) throws IOException {

    Socket clientSocket = new Socket("localhost", SERVER_PORT);

    OutputStream request = clientSocket.getOutputStream();
    InputStream response = clientSocket.getInputStream();

    while(clientSocket.isConnected()){

      // create request to server;
      request.write(REQUEST_CODE);

      // wait response from server;
      int responseValue = response.read();
      System.out.println("Server Response With: " + responseValue);

      if(responseValue == 1){
        break;
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e){
      }
    }

    request.close();
    response.close();
    clientSocket.close();
  }
}