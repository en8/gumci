package Mail;

import java.io.PrintWriter;

public interface Database {

	String id = "root";
	String pw = "0000";
	String db = "jdbc:mysql://223.130.121.106:3306/mail?autoReconnect=true&useSSL=false";
	String driver = "org.gjt.mm.mysql.Driver";

	public default void enter(boolean enter){
		if(enter == false){
			System.out.println("데이터베이스에 접속하지 못햇습니다");
		}
	}
	
	void insertm(String to, String from, String title, String body,boolean send);
	void inserti(String to, String from, int i,int j);
	void delete(String s, int i);
	void select(String s,int i,PrintWriter pw);
	
}