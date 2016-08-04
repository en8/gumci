package Mail;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Print{
	void print(String to, String from, String title, String body){
		//받는사람 보내는사람 제목 내용
		
		System.out.println("받는 사람은 : " + to);
		System.out.println("보내는 사람은 : " + from);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + body);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초 a"); 
		Date dt = new Date();
		System.out.println("보낸시간은 : " +sdf.format(dt).toString());
		
	}
}