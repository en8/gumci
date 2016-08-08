package Mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail{
	
	List list = new ArrayList();
	
	String sendpeople;
	String title;
	String body;
	String divide[];
	int cnt;
	int ipcnt=0;
	String[] ipary = {"223.130.121.106","223.130.121.107"};
	String ip = ipary[ipcnt];
	
	
	Mail(String getpeople,String sendpeople, String title, String body){
		divide = getpeople.split(",");
		for (int i = 0; i < divide.length; i++){
			list.add(divide[i]);
		}
		this.cnt = divide.length;
		this.sendpeople = sendpeople;
		this.title = title;
		this.body = body;
		
	}
	
	void mail() {
		
		for(int i = 0; i < cnt; i++){
			
			Properties props = new Properties();
			
		    props.put("mail.transport.protocol", "smtp");
		    props.put("mail.smtp.host", ip);
		    props.put("mail.smtp.port", "25");  //props 에 처음 세팅
		    
		    Session session = Session.getDefaultInstance(props); //props 과 message 연결
		    
		    try{
		    	MimeMessage message = new MimeMessage(session);
		   	 	InternetAddress to = new InternetAddress(sendpeople);
		   	 	message.setFrom(to);
		   	 	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(list.get(i).toString()));
		   	 	message.setSubject(title);
		   	 	message.setContent(body, "text/plain; charset=utf-8");
	    	 	message.setSentDate(new Date());
	    	 	Transport.send(message);
	    	 	
	    	 	Database d = new Database();
				d.data(list.get(i).toString(),sendpeople,title,body,-1);
				list.remove(i);
				i = i - 1;
				cnt = cnt - 1;
		     }
		     catch (MessagingException mex){
		    	if (mex.getMessage() == "Invalid Addresses"){
		    		System.out.println("주소가 잘못되었습니다. 삭제합니다");
		    		System.out.println("보낸사람 메일주소 : "+sendpeople);
		    		System.out.println("받는사람 메일주소 : " + list.get(i).toString());
		    		list.remove(i);
		    		i--;
		    		cnt--;
		    	}else{
		    		//오류 메세지 알아내기
		    		System.out.println(mex);
		    		System.out.println("ip롤링 메시지");
		    	}
		     }
		    catch(Exception e){
		    	e.printStackTrace();
		    } 
		}
		if(list.isEmpty() == false){
	    	this.cnt = list.size();
			this.ipcnt = ipcnt + 1;
			this.ip = ipary[ipcnt];
			mail();
		}
	}
		
}