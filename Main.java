package Mail;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(1532);
			System.out.println("하하");
				
			while(true){
				Socket client = server.accept();
				InetAddress address = client.getInetAddress();
				System.out.println(address.getHostAddress()+"접속");
				Thread t = new Server(client);
				t.start();
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
