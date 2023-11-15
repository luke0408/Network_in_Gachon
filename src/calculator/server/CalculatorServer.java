package calculator.server;

import calculator.model.ServerInfo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Calculator Server
 */
public class CalculatorServer {

    public static void main(String[] args) throws Exception {
        ServerInfo serverInfo = new ServerInfo();
        ServerSocket serverSocket = new ServerSocket(serverInfo.getPort());

        while (true) {
            Socket socket = serverSocket.accept();
            CalculaterThread thread = new CalculaterThread(socket);
            thread.start();
        }
    }
}