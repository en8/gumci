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

public class Bigsend{
	List list = new ArrayList();
	String allpeople;
	String sendpeople;
	String title;
	String body;
	String divide[];
	
	MailData data = new MailData();
	int ipcnt = data.list.size();
	int cnt;
	
	Bigsend(String getpeople,String sendpeople, String title, String body){
		divide = getpeople.split(",");
		for (int i = 0; i < divide.length; i++){
			list.add(divide[i]);
		}
		this.allpeople = getpeople;
		this.cnt = divide.length;
		this.sendpeople = sendpeople;
		this.title = title;
		this.body = body;
	}
	
	private Properties props = new Properties();
	private String protocol = "smtp";
	private String port = "25";
    private Session session; //props 과 message 연결
    private MimeMessage message;
    private InternetAddress to;
    
	void send() {
		for(int i = 0; i < cnt; i++){
		    props.put("mail.transport.protocol", protocol);
		    props.put("mail.smtp.host", data.list.get(0));
		    props.put("mail.smtp.port", port);  //props 에 처음 세팅
		    
		    try{
		    	session = Session.getDefaultInstance(props);
		        message = new MimeMessage(session);
		    	to = new InternetAddress(sendpeople);
		    	message.setFrom(to);
		    	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(list.get(i).toString()));
		    	message.setSubject(title);
		    	message.setContent(body, "text/plain; charset=utf-8");
		    	message.setSentDate(new Date());
		    	Transport.send(message); //오류가나면 오류메시지로
		    	
		    	if (i == cnt){
		    		data.inserti(allpeople, sendpeople, cnt);
		    	}else{
		    		data.insertm(list.get(i).toString(), sendpeople, title, body);
		    	}
		    	
		     }
		    catch (MessagingException mex){
		    	if (mex.getMessage() == "Invalid Addresses"){
		    		System.out.println("주소가 잘못되었습니다. 받는사람 메일주소 : "+ list.get(i).toString() + "삭제합니다");
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
	}		
}