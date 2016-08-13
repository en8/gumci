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
		Socket sock = null;
		OutputStream out = null;
		PrintWriter pw = null;
		InputStream in = null;
		BufferedReader br = null;
		try {
			
			sock = new Socket("192.168.59.45", 1532);
			
			out = sock.getOutputStream();
			pw = new PrintWriter(new OutputStreamWriter(out));
			
			
			in = sock.getInputStream(); //미리 버퍼에 데이터를 가져다놓음
			br = new BufferedReader(new InputStreamReader(in)); //문자 in을 효율적으로 크기를 잡는다.
			
			String to = null;
			String from = null;
			String title = null;
			String body = null;
			String choose = null;
				
			Scanner scan = new Scanner(System.in);
			
			do{
				System.out.print("수신자 : ");
				to = scan.nextLine();
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.print("발신자 : ");
				from = scan.nextLine();
				System.out.println("--------------------------------------------------------------------------------------");
				System.out.print("제목 입력 : ");
				title = scan.nextLine();
				System.out.println("--------------------------------------------------------------------------------------");
				
			}while(to.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$") == false 
					|| from.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$") == false 
					|| title.matches("") == true
				);
			
			System.out.print("내용 입력 : ");
			body = scan.nextLine();
			System.out.println("--------------------------------------------------------------------------------------");
			
			pw.println(to);
			pw.println(from);
			pw.println(title);
			pw.println(body);
			pw.flush();
			
			String line = null;
			
			int i = 1;
			while((line=br.readLine()) != null){
				if((i % 7) == 0){
					System.out.println(line);
				}else{
					System.out.print(line + "\t");
				}i++;
			}
			
			System.out.println("1. 현재 보낸사람 삭제 2. 전체삭제 3. 관둔다");
			choose = scan.nextLine();
			if(choose == "1" || choose == "2"){
				pw.println(choose);
				pw.flush();
			}
			
			sock.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
