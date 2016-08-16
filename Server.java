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
	
	
	InputStream in = null;  //바이트 단위로 입력               
	BufferedReader br = null; //inputstream 을 한줄단위로 읽기위해 버퍼리더를사용                      문자 입력 스트림으로부터 문자를 읽어 들이거나 문자 출력 스트림으로 문자를 내보낼때 사용 미리버퍼에 데이터를 가져놔서 보다 효율적으로 입출력
	OutputStream out = null; //바이트 단위로 출력   바이트 스트림에서 문자스트림으로 문자스트림에서 바이트스트림
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