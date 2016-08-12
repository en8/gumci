package Mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class Server extends Thread{
	Socket client;
	
	InputStream in = null;
	BufferedReader br = null;
	OutputStream out = null;
	PrintWriter pw = null;
	
	Server(Socket client){
		this.client = client;
	
		try{
			out = client.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(out));
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void run(){
		try{
			in = client.getInputStream(); //미리 버퍼에 데이터를 가져다놓음
			br = new BufferedReader(new InputStreamReader(in)); //문자 in을 효율적으로 크기를 잡는다.

			String line = null;

			int i = 0;
			String[] str = new String[4];
			
			while((line = br.readLine()) != null){
				str[i] = line;
				System.out.println(line);
				if (i == 3){
					Send m = new Send(str[0], str[1], str[2], str[3]);
					m.send();
					select(str[1],1);
					pw.flush();
					break;
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
	
	public void select(String s,int i){
		MailData data = new MailData(s,i);
		for (int j = 0; j < data.cnt; j++){
			for(int k = 0; k < data.columncnt; k++){
					pw.println(data.str[j][k]);
			}
		}
	}
}