package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

  private static final int SERVER_PORT = 1423;
  private static final String NEW_LINE = "\n\r";

  private static String buildHTTPResponse(String body){
    return "HTTP/1.1 200 OK" + NEW_LINE
        + "Access-Control-Allow-Origin: *" + NEW_LINE
        + "Content-Type: text/html" + NEW_LINE
        + "Content-Length: " + NEW_LINE
        + body.getBytes().length + NEW_LINE + NEW_LINE
        + body;
  }

  public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

    while (serverSocket.isBound()){

      Socket socket = serverSocket.accept();

      OutputStream request = socket.getOutputStream();
      InputStream response = socket.getInputStream();

      request.write(buildHTTPResponse("Hello World").getBytes());

      request.close();
      response.close();
      socket.close();
    }

  }
}