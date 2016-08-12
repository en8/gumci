package Mail;

public interface Database {

	String id = "root";
	String pw = "0000";
	String db = "jdbc:mysql://223.130.121.106:3306/mail?autoReconnect=true&useSSL=false";
	String driver = "org.gjt.mm.mysql.Driver";
	
	String im = "INSERT INTO `message` (getname,sendname,time,subject,text,state) VALUES(?,?,NOW(),?,?,?);";
	String ii = "INSERT INTO `info` (time,getname,sendname,count,failcount) VALUES(NOW(),?,?,?,?);";
	String sm = "SELECT * FROM `message` where sendname = ?";
	String ip = "SELECT * FROM `ip`";
	String del = "DELETE FROM `message`";
	
	String column = "SELECT COUNT(*) FROM information_schema.columns WHERE table_name='message';";

	public default void enter(boolean enter){
		if(enter == false){
			System.out.println("데이터베이스에 접속하지 못햇습니다");
		}
	}
	
	void insertm(String to, String from, String title, String body,boolean send);
	void inserti(String to, String from, int i,int j);
	void delete();
	void show(String s);
	
	
}