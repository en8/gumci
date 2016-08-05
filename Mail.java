package Mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail{ //눈에 안보이는 쓰레드 클래스를 상속
		
	
	void run(String getpeople,String sendpeople,String title,String body){
			// TODO Auto-generated method stub;
			Properties props = new Properties();
			
		    props.put("mail.transport.protocol", "smtp");
		    props.put("mail.smtp.host", "223.130.121.106");
		    props.put("mail.smtp.port", "25");  //props 에 처음 세팅
		    
		    Session session = Session.getDefaultInstance(props); //props 과 message 연결
		    
		    try{
		    	MimeMessage message = new MimeMessage(session);
		   	 	InternetAddress to = new InternetAddress(sendpeople);
		   	 	message.setFrom(to);
		   	 	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getpeople));
		   	 	message.setSubject(title);
		   	 	message.setContent(body, "text/plain; charset=utf-8");
	    	 	message.setSentDate(new Date());
	    	 	Transport.send(message);
	    	 	
	    	 	Database d = new Database();
			d.data(getpeople,sendpeople,title,body,-1);
	    	 	
		     }
		     catch (MessagingException mex){
		    	if (mex.getMessage() == "Invalid Addresses"){
		    		System.out.println("주소가 잘못되었습니다.");
		    		System.out.println("보낸사람 메일주소 : "+sendpeople);
		    		System.out.println("받는사람 메일주소 : " + getpeople);
		    		System.exit(0);
		    	}else{
		    		System.out.println(mex);
		    		mex.printStackTrace();
		    	}
		     }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		}
	}
