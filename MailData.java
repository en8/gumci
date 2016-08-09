package Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.sql.ResultSetMetaData;

public class MailData implements Database{
	List list = new ArrayList();
	
	private String id = "root";
	private String pw = "0000";
	private String db = "jdbc:mysql://223.130.121.106:3306/mail";
	private String driver = "org.gjt.mm.mysql.Driver";

	private Connection con;
	private ResultSet result;
	private Statement state;
	
	MailData(){
		try{
			Class.forName(driver); //driver 등록
			con = DriverManager.getConnection(db,id,pw);
			state = con.createStatement();
			result = state.executeQuery("SELECT * FROM `ip`");
			while(result.next()){
				list.add(result.getString("ip"));
			}
		}catch(Exception e){
			enter(false);
			e.printStackTrace();
		}
	}
	@Override
	public void insertm(String to, String from, String title, String body){
		try {
			state.executeUpdate("INSERT INTO `message` (getname,sendname,time,subject,text) VALUES('"+to+"','"+from+"',NOW(),'"+title+"','"+body+"');");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void inserti(String to, String from, int i){
		try {
			state.executeUpdate("INSERT INTO `info` (time,getname,sendname,count) VALUES(NOW(),'"+to+"','"+from+"','"+i+"');");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void select() {
		try{
			result = state.executeQuery("SELECT * FROM `message`");
			while( result.next()){
				for (int i = 1; i < 6; i++){
					if(i == 5){
						System.out.println(result.getString(i) + "\n");
					}
					System.out.println(result.getString(i) + "\t");
				}
			}
		}catch(SQLException e) {
			System.out.println("message 테이블의 내용을 출력할수 없습니다.");
		}
	}
	@Override
	public void delete() {
		try{
			state.executeUpdate("DELETE FROM `message`");
		}catch(SQLException e) {
			System.out.println("message테이블의 내용을 삭제할수 없습니다");
		}
	}
}
