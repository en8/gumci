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
		this.lcnt = divide.length; //초기 리스트값
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
		int cnt = 0; //증가값
		int fcnt=0; // 실패해서 증가되는 값
		
		do{
			props.put("mail.transport.protocol", protocol);
			props.put("mail.smtp.host", data.list.get(ipcnt));
			props.put("mail.smtp.port", port);  //props 에 처음 세팅
			for(cnt = 0; cnt < lcnt; cnt++){ // lcnt엔 처음엔 리스트값이 저장되지만 나중엔 실패한 값이 저장된다
				try{
					session = Session.getDefaultInstance(props);
					message = new MimeMessage(session);
					to = new InternetAddress(sendpeople);
					message.setFrom(to);
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(list.get(cnt).toString()));
					message.setSubject(title);
					message.setContent(body, "text/plain; charset=utf-8");
					message.setSentDate(new Date());
					
					Transport.send(message); //오류가나면 오류메시지로가서 아래의 행들은 실행되지 않음
					
					data.insertm(list.get(cnt).toString(), sendpeople, title, body,true); //성공하면 data클래스의 insertm에 성공과 성공여부를 저장
					scnt = scnt + 1; //성공한 값 카운트
					}
					catch (MessagingException mex){
						if (mex.getMessage() == "Invalid Addresses"){
							System.out.println("주소가 잘못되었습니다. 받는사람 메일주소 : "+ list.get(cnt).toString());
							data.insertm(list.get(cnt).toString(), sendpeople, title, body,false);
							flist.add(list.get(cnt)); //ip 롤링을 제외한 실패요소들은 실패리스트에 저장 그리고 insertm 에 실패를 저장
						}else{
							if(ipcnt == data.list.size() - 1){
								for(int i = cnt; i < lcnt; i++){
									flist.add(list.get(i));
									data.insertm(list.get(i).toString(), sendpeople, title, body,false);
								}
								data.inserti(allpeople, sendpeople,scnt,flist.size());
								sw = true; // 주어진 ip가 부족해서 오류가나면 지금까지의 작업만 저장하고 나머지 것들은 실패리스트에 넣음. 그리고 서버에 성공수와 실패수를 저장하고 sw를 on시켜서 while 문을 빠져나옴
							}
							System.out.println(mex);
							System.out.println("ip롤링 할 메시지 저장");
							list.add(0,list.get(cnt).toString());
							fcnt++; //리스트 0번째에 실패한값을 넣음 그리고 fcnt를 하나 더함
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			if(fcnt == 0){
				data.inserti(allpeople, sendpeople,scnt,flist.size());
				sw = true; // fnct가 0이면 메일 ip롤링할 값이 없다는 것이므로 서버에 성공한값과 실패한 값을 보냄
			}
			else{
				lcnt = fcnt; //리스트값을 실패한 리스트값을 저장
				fcnt = 0; //실패한 값 초기화
				ipcnt++; //ip를 바꿔준다
			}
		}while(sw == false);
		
	}
}