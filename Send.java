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

	int lcnt = 0;
	
	Send(String getpeople,String sendpeople, String title, String body){
		divide = getpeople.split(",");
		for (int i = 0; i < divide.length; i++){
			list.add(divide[i]);
		}
		data.ip();
		
		this.allpeople = getpeople;
		this.lcnt = divide.length; //초기 리스트값
		this.sendpeople = sendpeople;
		this.title = title;
		this.body = body;
	}
	
	private Properties props = new Properties();
	private String protocol = "smtp";
	private String port = "25";
    private Session session;
    private MimeMessage message;
    private InternetAddress to;
    
	void send() {
		boolean sw = false;
		
		int scnt = 0;
		int ipcnt = 0;
		int cnt = 0;
		int fcnt=0;
		
		props.put("mail.transport.protocol", protocol);
		props.put("mail.smtp.port", port);
		
		do{
			props.put("mail.smtp.host", data.list.get(ipcnt));
			session = Session.getDefaultInstance(props);
			for(cnt = 0; cnt < lcnt; cnt++){
				try{
					message = new MimeMessage(session);
					to = new InternetAddress(sendpeople);
					message.setFrom(to);
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(list.get(cnt).toString()));
					message.setSubject(title);
					message.setContent(body, "text/plain; charset=utf-8");
					message.setSentDate(new Date());
					
					Transport.send(message);
					
					data.insertm(list.get(cnt).toString(), sendpeople, title, body,true);
					scnt = scnt + 1;
					
					}
					catch (MessagingException mex){
						if (mex.getMessage() == "Invalid Addresses"){
							System.out.println("주소가 잘못되었습니다. 받는사람 메일주소 : "+ list.get(cnt).toString());
							data.insertm(list.get(cnt).toString(), sendpeople, title, body,false);
							flist.add(list.get(cnt));
						}else{
							if(ipcnt == data.list.size() - 1){
								for(int i = cnt; i < lcnt; i++){
									flist.add(list.get(i));
									data.insertm(list.get(i).toString(), sendpeople, title, body,false);
									System.out.println(mex.getMessage());
								}
							}else if(ipcnt == data.list.size() - 1 && cnt == lcnt){
								data.inserti(allpeople, sendpeople,scnt,flist.size());
								sw = true;
							}
							System.out.println("ip롤링 할 메시지 저장");
							list.add(0,list.get(cnt));
							fcnt++;
							System.out.println(mex.getMessage());
						}
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
				}
			if(fcnt == 0){
				data.inserti(allpeople, sendpeople,scnt,flist.size());
				list.clear();
				sw = true;
			}
			else{
				for(int i = fcnt; i < (lcnt + fcnt); i++){
					System.out.println("여기");
					System.out.println(i);
					System.out.println(lcnt + fcnt);
					System.out.println(list.size());
					System.out.println(list.get(i));
					list.remove(i);
					if(list.size() == 11){
						break;
					}

				}
				lcnt = fcnt;
				fcnt = 0;
				ipcnt++;
			}
		}while(sw == false);
	}
}