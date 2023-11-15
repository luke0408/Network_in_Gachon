package calculator.client;

import java.io.BufferedReader;

public class InputThread extends Thread{
    BufferedReader in = null;

    public InputThread(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println("result: " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
