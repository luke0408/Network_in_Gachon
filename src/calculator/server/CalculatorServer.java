package calculator.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Calculator Server
 */
public class CalculatorServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);

        while (true) {
            Socket socket = serverSocket.accept();
            CalculaterThread thread = new CalculaterThread(socket);
            thread.start();
        }
    }
}