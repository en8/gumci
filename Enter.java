package Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
//import java.sql.ResultSetMetaData;

public class Enter {
	
	void enter(String getname, String sendname, String subject, String content){
			try
			{
				
				Class.forName("org.gjt.mm.mysql.Driver"); //driver 등록
				
				Connection con  = DriverManager.getConnection("jdbc:mysql://223.130.121.106:3306/mail","root","0000"); 
				Statement state = con.createStatement(); //작성된 결과돌려죽
				Statement state1 = con.createStatement();
					
				String[] get = getname.split(",");
				for(int i=0; i < get.length; i++){
					state.executeUpdate("INSERT INTO message (getname,sendname,time,subject,text) VALUES('"+get[i]+"','"+sendname+"',NOW(),'"+subject+"','"+content+"');");
				}
				state.executeUpdate("INSERT INTO info (time,sendname,count) VALUES(NOW(),'"+sendname+"','"+get.length+"');");
	        
				ResultSet result = state.executeQuery("SELECT * FROM message;");
				
				ResultSet result1 = state1.executeQuery("SELECT count(*) FROM information_schema.columns WHERE table_name = 'message'");
				
				if (result1.next()){
					int cnt = result1.getInt(1);
					while(result.next())
					{
						for (int p = 1; p < cnt+1; p++){
							if (p==6){
								System.out.println(result.getString(p));
							}else{
								System.out.print(result.getString(p)+"\t");
							}
						}
					}
				}
				/*
				ResultSetMetaData md = result.getMetaData();
				int count = md.getColumnCount();
				*/
				Scanner scan = new Scanner(System.in);
				System.out.print("데이터를 삭제하시겠습니까?1. 전체 삭제 2. 현재 삭제  3. 아니요 : ");
				String ots = scan.next();
				if (ots.equals("1")== true || ots.equals("전체 삭제")== true){
					state.executeUpdate("DELETE FROM message");
				}else if (ots.equals("2")== true || ots.equals("현재 삭제")== true){
					state.executeUpdate("DELETE FROM message WHERE number > (SELECT * FROM (SELECT MAX(number) - "+get.length+" FROM message) AS TEMP);");
				}

				con.close();
			}catch(Exception e){
				System.out.println("연결 안됨");
				e.printStackTrace();
			};
		}	
}
