import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient{
	public static void main(String[] args){
		try{
			Socket s = new Socket("localhost", 5000);
			System.out.println("Connected to Server!");
			
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			DataInputStream din = new DataInputStream(s.getInputStream());
			Scanner sc = new Scanner(System.in);

			String clientMsg = "", serverMsg = "";

			while(!clientMsg.equalsIgnoreCase("exit")){
				System.out.print("You: ");
				serverMsg = sc.nextLine();
				dout.writeUTF(serverMsg);
				dout.flush();
				if(clientMsg.equalsIgnoreCase("exit")) break;
				serverMsg = din.readUTF();
				System.out.println("Server: " + serverMsg);
				
			}
			din.close();
			dout.close();
			s.close();
			sc.close();
			System.out.println("Chat ended.");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
