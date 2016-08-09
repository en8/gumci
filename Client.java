package Client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Socket sock = new Socket("192.168.59.45", 1532);
			
			OutputStream out = sock.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			
			
			InputStream in = sock.getInputStream(); //미리 버퍼에 데이터를 가져다놓음
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); //문자 in을 효율적으로 크기를 잡는다.
			
			String to = null;
			String from = null;
			String title = null;
				
			Scanner scan = new Scanner(System.in);
			
			do{
				System.out.print("수신자 : ");
				to = scan.nextLine();
				System.out.println("");
				System.out.print("발신자 : ");
				from = scan.nextLine();
				System.out.println("");
				System.out.print("제목 입력 : ");
				title = scan.nextLine();
				System.out.println("");
			}while(to.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$") == false 
					|| from.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$") == false 
					|| title.matches("") == true
					);
			System.out.print("내용 입력 : ");
			String body = scan.nextLine();
			System.out.println("");
			
			String line = null;
			
			while((line = br.readLine()) != null){
				pw.println(to);
				pw.println(from);
				pw.println(title);
				pw.println(body);
				
				System.out.println(line);
			}
			
			System.out.println(line);
			
			pw.flush();
			sock.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		}
	}
}
