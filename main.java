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
		
			System.out.print("�޴� ��� : ");		
			get= scan.nextLine();
			System.out.println("");
			System.out.print("������ ��� : ");
			send = scan.nextLine();
			System.out.println("");
			System.out.print("���� �Է� : ");
			title = scan.nextLine();
			System.out.println("");
			System.out.print("���� �Է� : ");
			body = scan.nextLine();
			System.out.println("");
			
			mail mail = new mail(get, send, title, body); // �޴»��, �����»��, ����, ����
			
			System.out.println("##################################################################################################");
			System.out.print("������ �� �����ðڽ��ϱ�? 1. Yes 2. No : ");
			st = scan.nextLine();
			if(st.equals("1")== true || st.equals("yes")== true){
			}
			else{
				stop = false;
			}
		}
	}
}








// ������ �ð��̸��̰ɷ���
