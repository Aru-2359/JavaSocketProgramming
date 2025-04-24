import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5555);
            System.out.println("Server is ready...");

            Socket s = ss.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(s.getInputStream());

            String msg = dis.readUTF();
            System.out.println("Message: " + msg);

            dis.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
