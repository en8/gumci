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

public class Send {
	MailData data = new MailData();
	
	List list = new ArrayList();
	List flist = new ArrayList();
	String allpeople;
	String sendpeople;
	String title;
	String body;
	String divide[];

	int lcnt = 0; // 리스트의 전체의 값 카운트
	
	
	boolean sw = false;
	
	Send(String getpeople,String sendpeople, String title, String body){
		divide = getpeople.split(",");
		for (int i = 0; i < divide.length; i++){
			list.add(divide[i]);
		}
		this.allpeople = getpeople;
		this.lcnt = divide.length;
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
		int scnt = 0; //성공한 값 카운트
		int ipcnt = 0; //database ip순서
		int cnt = 0; //증가되는 값 카운트 
		int fcnt=0; // 실패해서 증가되는 값
		
		do{
			props.put("mail.transport.protocol", protocol);
			props.put("mail.smtp.host", data.list.get(ipcnt));
			props.put("mail.smtp.port", port);  //props 에 처음 세팅
			for(cnt = 0; cnt < lcnt; cnt++){ //현재i증가
				try{
					session = Session.getDefaultInstance(props);
					message = new MimeMessage(session);
					to = new InternetAddress(sendpeople);
					message.setFrom(to);
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(list.get(cnt).toString()));
					message.setSubject(title);
					message.setContent(body, "text/plain; charset=utf-8");
					message.setSentDate(new Date());
					Transport.send(message); //오류가나면 오류메시지로
					data.insertm(list.get(cnt).toString(), sendpeople, title, body,true);
					
					scnt = scnt + 1; //성공한 값 카운트
					
					}
					catch (MessagingException mex){
						if (mex.getMessage() == "Invalid Addresses"){
							System.out.println("주소가 잘못되었습니다. 받는사람 메일주소 : "+ list.get(cnt).toString());
							data.insertm(list.get(cnt).toString(), sendpeople, title, body,false);
							flist.add(list.get(cnt));
						}else{
							if(ipcnt == 1){
								sw = true;
							}
							System.out.println(mex);
							System.out.println("ip롤링 할 메시지 저장");
							list.add(0,list.get(cnt).toString());
							fcnt++;
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			if(fcnt == 0){
				data.inserti(allpeople, sendpeople,scnt,flist.size());
				sw = true;
			}
			else{
				lcnt = fcnt;
				fcnt = 0;
				ipcnt++;
			}
		}while(sw == false);
		
	}
}