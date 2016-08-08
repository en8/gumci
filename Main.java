package Mail;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			
			ServerSocket server = new ServerSocket(1532); //포트 1532인 서버소켓을 만든다
				
			while(true){
				Socket client = server.accept();  //서버가 client응답에 맞추어 소켓인 client 를생성한다
				InetAddress address = client.getInetAddress();
				System.out.println(address.getHostAddress()+"접속");
				Thread t = new Server(client);
				t.setDaemon(true);
				t.start();
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
