package Mail;

import java.util.Scanner;
import javax.mail.MessagingException;

public class Main {
	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub	
		do{
			Scanner scan = new Scanner(System.in);
			
			System.out.print("받는 사람 : ");		
			String get= scan.nextLine();
			
			if (get.matches("")){
				System.out.println("종료");
				break;
			}
			System.out.println("");
			System.out.print("보내는 사람 : ");
			String send = scan.nextLine();
			System.out.println("");
			
			System.out.print("제목 입력 : ");
			String title = scan.nextLine();
			System.out.println("");
			
			System.out.print("내용 입력 : ");
			String body = scan.nextLine();
			System.out.println("");
			
			String[] getname = get.split(",");
			Send snd[];
			snd = new Send[getname.length];
			for (int i = 0; i < snd.length; i++){
				snd[i] = new Send(getname[i], send, title, body);
				snd[i].start();
				System.out.println(snd[i]);
			}
			
			 
			Info Info = new Info(); // 받는사람, 보내는사람, 제목, 내용
			Info.info(get, send, title, body);
			
			System.out.println("##################################################################################################");
			System.out.print("메일을 또 보내시겠습니까? 1. Yes 2. No : ");
			String st = scan.nextLine();
			if(st.equals("2")== true || st.equals("No")== true){
				break;
			}
		}while (true);
	}
}
