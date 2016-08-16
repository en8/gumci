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
	MailData data;
	
	
	InputStream in = null;
	BufferedReader br = null; //inputstream 을 한줄단위로 읽기위해 버퍼리더를사용
	OutputStream out = null;
	PrintWriter pw = null;
	
	Server(Socket client){
		this.client = client;
		data = new MailData();
		try{
			out = client.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(out)); //기본 데이터형이나 객체를 쓰기위한 클래스
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void run(){
		int cnt = 0;
		
		try{
			in = client.getInputStream(); //미리 버퍼에 데이터를 가져다놓음
			br = new BufferedReader(new InputStreamReader(in)); //문자 in을 효율적으로 크기를 잡는다.

			String line = null;

			int i = 0;
			String[] str = new String[5];
			
			while((line = br.readLine()) != null){
				str[i] = line;
				System.out.println(line);
				if (i == 3){
					Send m = new Send(str[0], str[1], str[2], str[3]);
					m.send();
					cnt = m.divide.length;
					data.select(str[1], cnt, pw);
					pw.flush();
				}
				if(i == 4){
					System.out.println("메시지삭제");
					data.delete(str[1], cnt);
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