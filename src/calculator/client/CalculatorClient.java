package calculator.client;

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
        Socket socket = new Socket("localhost", 6789);

        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        InputThread inputThread = new InputThread(in);
        inputThread.start();

        while (true) {
            System.out.println("format: [number] [operator] [number]");
            line = stdIn.readLine();

            if (line.equals("exit")) break;

            out.write(line + "\n");
            out.flush();
        }

        socket.close();
    }
}
