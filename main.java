package Mail;


import java.util.Scanner;

import javax.mail.MessagingException;

public class main {
	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub
		String get;
		String send;
		String title;
		String body;
		
		String st;
		
		boolean stop = true;
			
		while(stop == true){
			Scanner scan = new Scanner(System.in);
		
			System.out.print("받는 사람 : ");		
			get= scan.nextLine();
			System.out.println("");
			System.out.print("보내는 사람 : ");
			send = scan.nextLine();
			System.out.println("");
			System.out.print("제목 입력 : ");
			title = scan.nextLine();
			System.out.println("");
			System.out.print("내용 입력 : ");
			body = scan.nextLine();
			System.out.println("");
			
			mail mail = new mail(get, send, title, body); // 받는사람, 보내는사람, 제목, 내용
			
			System.out.println("##################################################################################################");
			System.out.print("메일을 또 보내시겠습니까? 1. Yes 2. No : ");
			st = scan.nextLine();
			if(st.equals("1")== true || st.equals("yes")== true){
			}
			else{
				stop = false;
			}
		}
	}
}