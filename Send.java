package Mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send extends Thread{ //눈에 안보이는 쓰레드 클래스를 상속
		String mymail = "";
		String yourmail = "";
		String head = "";
		String body = "";
		String ip = "223.130.121.106";
		
		Send(String mymail, String yourmail, String head, String body){
			this.mymail = mymail;
			this.yourmail = yourmail;
			this.head = head;
			this.body = body;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub;
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
		    props.put("mail.transport.protocol", "smtp");
		    props.put("mail.smtp.host", ip);
		    props.put("mail.smtp.port", "25");  //props 에 처음 세팅
		    
		    Session session = Session.getDefaultInstance(props); //props 과 message 연결
		    
		    try{
		    	MimeMessage message = new MimeMessage(session);
		   	 	InternetAddress to = new InternetAddress(yourmail);
		   	 	message.setFrom(to);
		   	 	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mymail));
		   	 	message.setSubject(head);
		   	 	message.setContent(body, "text/plain; charset=utf-8");
	    	 	message.setSentDate(new Date());
	    	 	Transport.send(message);
	    	 	props.clear();
	    	 	
		     }
		     catch (MessagingException mex){
		    	if (mex.getMessage() == "Invalid Addresses"){
		    		System.out.println("주소가 잘못되었습니다.");
		    		System.out.println("보낸사람 메일주소 : "+mymail);
		    		System.out.println("받는사람 메일주소 : " + yourmail);
		    		System.exit(0);
		    	}else{
		    		System.out.println(mex);
		    		mex.printStackTrace();
		    		// ip = "223.130.121.107"
		    	}
		     }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		}
	}