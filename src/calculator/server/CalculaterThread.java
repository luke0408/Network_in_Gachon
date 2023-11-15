package calculator.server;

import calculator.utils.Operation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class CalculaterThread extends Thread{

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    
    public CalculaterThread(Socket socket) throws Exception  {
        this.socket = socket;
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        String line = null;

        try {
            while (true) {
                line = in.readLine();
                String[] tokens = line.split(" ");

                if (line.equals("exit")) break;
                if (checkInput(tokens)) continue;

                double x = Double.parseDouble(tokens[0]);
                double y = Double.parseDouble(tokens[2]);
                double result = Operation.of(tokens[1]).apply(x, y);

                out.write(result + "\n");
                out.write("====================================\n");
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkInput(String[] tokens) {
        if (tokens.length != 3) {
            out.println("Invalid input");
            out.flush();
            return true;
        }
        return false;
    }
}
