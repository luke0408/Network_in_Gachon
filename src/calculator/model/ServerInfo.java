package calculator.model;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ServerInfo {

    private static String HOST = "localhost";
    private static int PORT = 6789;
    private static DataInputStream in;

    public ServerInfo() {
        try {
            in = new DataInputStream(new FileInputStream("../data/server_info.dat"));
            HOST = in.readUTF();
            PORT = in.readInt();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println("Using default host and port");
            System.out.println(this + "\n");
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.out.println("Using default host and port");
            System.out.println(this + "\n");
        }
    }

    public String getHost() {
        return HOST;
    }

    public int getPort() {
        return PORT;
    }

    @Override
    public String toString() {
        return "ServerInfo{" + "HOST=" + HOST + ", PORT=" + PORT + '}';
    }

}
