package Mail;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Info{
	void info(String getname, String sendname, String subject, String content){
		//받는사람 보내는사람 제목 내용
		
		System.out.println("받는 사람은 : " + getname);
		System.out.println("보내는 사람은 : " + sendname);
		System.out.println("제목 : " + subject);
		System.out.println("내용 : " + content);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초 a"); 
		Date dt = new Date();
		System.out.println("보낸시간은 : " +sdf.format(dt).toString());
		
		Enter Enter = new Enter();
		Enter.enter(getname, sendname, subject, content);
	}
}