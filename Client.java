package Client;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		
			Socket sock = new Socket("223.130.121.106", 1532); //소케켓에 들어갈 포트번호 호스트주소
			
			OutputStream out = sock.getOutputStream(); //정보들을 바이트단위로 데이터를 전송.
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out)); //PrintWriter 기본데이터형이나 객체를 쓰기 위한 클래스
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
		if(e.getMessage() == "Connection refused: connect"){
			System.out.println("서버를 찾지 못하였습니다");
		}
		}
	}
}
