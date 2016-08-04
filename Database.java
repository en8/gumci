package Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import java.sql.ResultSetMetaData;

public class Database{
	
	void data(String to, String from, String title, String body){
			try
			{
				String[] divide = to.split(",");
				
				Class.forName("org.gjt.mm.mysql.Driver"); //driver 등록
				
				Connection con  = DriverManager.getConnection("jdbc:mysql://223.130.121.106:3306/mail","root","0000"); 
				Statement state = con.createStatement(); //작성된 결과돌려주기
				
				for (int i = 0; i < divide.length; i++){
					state.executeUpdate("INSERT INTO message (getname,sendname,time,subject,text) VALUES('"+divide[i]+"','"+"',NOW(),'"+title+"','"+body+"');");
				}
				state.executeUpdate("INSERT INTO info (time,sendname,count) VALUES(NOW(),'"+from+"','"+divide.length+"');");
				con.close();
			}catch(Exception e){
				System.out.println("연결 안됨");
				e.printStackTrace();
			};
		}	
}
