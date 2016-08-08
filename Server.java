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
			in = client.getInputStream(); //미리 버퍼에 데이터를 가져다놓음
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); //문자 in을 효율적으로 크기를 잡는다.
			
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
			System.out.println(e.getMessage());
			if(e.getMessage() == "Connection reset"){
				System.out.println("클라이언트와의 연결이 끊어졌습니다.");
			}
		}	
	}
}