package Mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		do{
			try {
				ServerSocket server = new ServerSocket(10000);
				System.out.println("하하");
				Socket sock = server.accept();
				
				InetAddress address = sock.getInetAddress();
				System.out.println(address.getHostAddress()+"접속");
				
				InputStream in = sock.getInputStream();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				
				String line = null;
				
				int i = 0;
				String[] str = new String[4];
				
				while((line = br.readLine()) != null){
					str[i] = line;
					System.out.println(str[i]);
					if (i == 3){
						Thread t = new Passage(str[0],str[1],str[2],str[3]);
						t.start();
					}
					i++;
				}
				br.close();
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(true);
	}
}
