package Mail;

import java.util.Scanner;
import javax.mail.MessagingException;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub	
		do{
			Scanner scan = new Scanner(System.in);		
			String get;
			do{
				System.out.print("받는 사람: ");
				get = scan.nextLine();
				if (get.matches("")){
					System.exit(0);;
				}else if(get.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
					System.out.println("한글이 들어갔습니다. 다시 입력해주세요");
					}
				else{
					break;
					}
			}while(true);
					
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
			
			Send snd;

			for (int i = 0; i < getname.length; i++){
				snd = new Send(getname[i], send, title, body);
				snd.start();
					/*try {
						snd.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
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
