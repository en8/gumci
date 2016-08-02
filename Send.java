package Mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send extends Thread{
		String mymail = "";
		String yourmail = "";
		String head = "";
		String body = "";
		
		String port = "223.130.121.106";

		Send(String me, String you, String subject, String content){
			mymail = me;
			yourmail = you;
			head = subject;
			body = content;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Properties props = new Properties();
		     props.put("mail.transport.protocol", "smtp");
		     props.put("mail.smtp.host", port);
		     props.put("mail.smtp.port", "25");
		     
		     Session session = Session.getDefaultInstance(props);
		     
		     try{
		    	 MimeMessage message = new MimeMessage(session);
		    	 InternetAddress to = new InternetAddress(yourmail);
		    	 message.setFrom(to);
		    	 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mymail));
		    	 message.setSubject(head);
		    	 message.setContent(body, "text/plain; charset=utf-8");
		    	 message.setSentDate(new Date());
		    	 System.out.println(mymail);
		    	 Transport.send(message);
		     }
		     
		     catch (MessagingException mex){
		    	 if (mex.getMessage() != "Invalid Addresses"){
		    		 System.out.println(mex.getMessage());
		    		 mex.printStackTrace();
		    		 System.out.println("IP를 바꿉니다");
		    		 System.out.println(port);
		    		 port = "223.130.121.107";
		    		 run();
		    	 }else{
		    		 System.out.println("주소가 잘못되었습니다.");
		    		 System.out.println("보낸사람 메일주소 : "+mymail);
		    		 System.out.println("받는사람 메일주소 : " + yourmail);
		    		 System.exit(0);
		    	 }
		     }
		     catch(Exception e){
		    	 e.printStackTrace();
		     }
		}
	}