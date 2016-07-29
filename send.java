package Mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class send {

	void send(String na, String neo, String jaemok, String naeyoung){

	     Properties props = new Properties();
	     props.put("mail.transport.protocol", "smtp");
	     props.put("mail.smtp.host", "223.130.121.106");
	     props.put("mail.smtp.port", "25");
	     
	     Session session = Session.getDefaultInstance(props);
	     
	     try{
	    	 MimeMessage message = new MimeMessage(session);
	    	 InternetAddress to = new InternetAddress(neo);
	    	 message.setFrom(to);
	    	 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(na));
	    	 message.setSubject(jaemok);
	    	 message.setContent(naeyoung, "text/plain; charset=utf-8");
	    	 message.setSentDate(new Date());

	    	 Transport.send(message);
	     }
	     catch (MessagingException mex){
	    	 mex.printStackTrace();	    	 
	     }
	     catch(Exception e){
	    	 e.printStackTrace();
	     }
	}	
}
