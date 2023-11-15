package calculator.client;

import calculator.model.ServerInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Calculator Client
 */
public class CalculatorClient {

    public static void main(String[] args) throws Exception {
        ServerInfo serverInfo = new ServerInfo();
        Socket socket = new Socket(serverInfo.getHost(), serverInfo.getPort());

        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn =  new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        InputThread inputThread = new InputThread(in);
        inputThread.start();

        while (true) {
            Thread.sleep(100);
            System.out.println("format: [number] [operator] [number]");
            line = stdIn.readLine();

            if (line.equals("exit")) break;

            out.write(line + "\n");
            out.flush();
        }

        socket.close();
    }
}
