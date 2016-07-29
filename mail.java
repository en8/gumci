package Mail;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class mail{
	mail(String getname, String sendname, String subject, String content){
		//받는사람 보내는사람 제목 내용
		
		send send = new send();
		
		int i,p;
		
		String ots;
		
		Scanner scan = new Scanner(System.in);
		
		String[] get = getname.split(",");
		
		System.out.println("받는 사람은 : " + getname);
		System.out.println("보내는 사람은 : " + sendname);
		System.out.println("제목 : " + subject);
		System.out.println("내용 : " + content);
		
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초 a"); 
		System.out.println("보낸시간은 : " +sdf.format(dt).toString());
        		
		try
		{	
			String mSel = "select * from message;";
			String iSel = "select * from info;";
			String mdel = "delete from message;";
			String idel = "delete from info;";
			String mpri = "alter table message AUTO_INCREMENT = 1 ";
			String ipri = "alter table info AUTO_INCREMENT = 1 ";
			String last = "delete from message where number > (select * from (select max(number) - "+get.length+" from message)as temp);";
			
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection con  = DriverManager.getConnection("jdbc:mysql://localhost","root","0000");
            Statement state = con.createStatement();
            state.executeUpdate("use mail;");
            
            for(i=0; i < get.length; i++){            	
            	state.executeUpdate("insert into message (getname,sendname,time,text) values('"+get[i]+"','"+sendname+"',NOW(),'"+content+"');");
            	send.send(get[i], sendname, subject, content);
            }
            state.executeUpdate("insert into info (time,sendname,count) values(NOW(),'"+sendname+"','"+get.length+"');");
            ResultSet result = state.executeQuery(mSel);
            
            while(result.next())
            {
            	
            	for (p = 1; p < 6; p++){
            		if (p==5){
            			System.out.println(result.getString(p));
            			
                    }else{
                    	System.out.print(result.getString(p)+"\t");
                    }
            	}
            }
            
            System.out.print("데이터를 삭제하시겠습니까? 1. 삭제   2. 아니요 : ");
            ots = scan.next();
            if (ots.equals("1")== true || ots.equals("전부")== true){
            	state.executeUpdate(last);
            }
            
            con.close();
         }
         catch(Exception e){
             System.out.println("연결 안됨");
             e.printStackTrace();
         }
	}
}