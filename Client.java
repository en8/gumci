package Client;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket sock = new Socket("223.130.121.106", 1532);
			
			OutputStream out = sock.getOutputStream();
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			String to = "";
			String from = "";
			String title = "";
				
			Scanner scan = new Scanner(System.in);
			
			while(to.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$") == false || from.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$") == false || title.matches("") == true ){
				System.out.print("수신자 : ");
				to = scan.nextLine();
				System.out.println("");
				System.out.print("발신자 : ");
				from = scan.nextLine();
				System.out.println("");
				System.out.print("제목 입력 : ");
				title = scan.nextLine();
				System.out.println("");
			}
			
			System.out.print("내용 입력 : ");
			String body = scan.nextLine();
			System.out.println("");
			
			pw.println(to);
			pw.println(from);
			pw.println(title);
			pw.println(body);
			
			pw.flush();
			sock.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		}
	}
}
