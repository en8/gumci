package Mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Server extends Thread{
	Socket client;
	
	Server(Socket client){
		this.client = client;
	}
	
	public void run(){
		try{
			InputStream in;
			in = client.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String line = null;
			
			int i = 0;
			String[] str = new String[4];
	
			while((line = br.readLine()) != null){
				str[i] = line;
				System.out.println(str[i]);
				if (i == 3){
					Passage p = new Passage();
					p.passage(str[0], str[1], str[2], str[3]);
					System.out.println(client.getInetAddress() +"님의 메세지가 완료되었습니다.");
				}
				i++;
			}
			br.close();
			client.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}