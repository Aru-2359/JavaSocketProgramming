import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyServer{
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(5000);
			System.out.println("Sever started. Waiting for client...");
			
			Socket s = ss.accept();
			System.out.println("Client connected!");
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			Scanner sc = new Scanner(System.in);

			String clientMsg = "", serverMsg = "";

			while(!clientMsg.equalsIgnoreCase("exit")){
				clientMsg = din.readUTF();
				System.out.println("Client: " + clientMsg);
				if(clientMsg.equalsIgnoreCase("exit")) break;
				System.out.print("You: ");
				serverMsg = sc.nextLine();
				dout.writeUTF(serverMsg);
				dout.flush();
			}
			din.close();
			dout.close();
			s.close();
			ss.close();
			sc.close();
			System.out.println("Chat ended.");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}