package Mail;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MailData implements Database{
	
	List list = new ArrayList(); //ip 목록
	
	private Connection con = null;
	private PreparedStatement state = null;
	private ResultSet result = null;
	
	int x = 0;
	int columncnt = 0;
	int cnt = 0;
	String[][] str = null;
	
	MailData(){
		try{
			Class.forName(driver); //driver 등록
			con = DriverManager.getConnection(db,id,pw);
		}catch(Exception e){
			enter(false);
			e.printStackTrace();
		}
	}
	void ip(){
		String ip = "SELECT * FROM `ip`";
		try{
			state = con.prepareStatement(ip);
			result = state.executeQuery();
			while(result.next()){
				list.add(result.getString("ip"));
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void insertm(String to, String from, String title, String body, boolean send){
		String im = "INSERT INTO `message` (getname,sendname,time,subject,text,state) VALUES(?,?,NOW(),?,?,?);";
		try {
			state = con.prepareStatement(im);
			state.setString(1, to);
			state.setString(2, from);
			state.setString(3, title);
			state.setString(4, body);
			if(send == true){
				state.setString(5, "1");
				state.executeUpdate();
			}else{
				state.setString(5, "2");
				state.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void inserti(String to, String from, int i, int j){
		String ii = "INSERT INTO `info` (time,getname,sendname,count,failcount) VALUES(NOW(),?,?,?,?);";
		
		try {
			state = con.prepareStatement(ii);
			state.setString(1, to);
			state.setString(2, from);
			state.setInt(3, i);
			state.setInt(4, j);
			state.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void select(String s,int i,PrintWriter pw){
		String column = "SELECT COUNT(*) FROM information_schema.columns WHERE table_name='message';";
		String sm;
		try{
			state = con.prepareStatement(column);
			result = state.executeQuery();
			while(result.next()){
				columncnt = result.getInt("COUNT(*)");
			}
			if(i > 0){
				sm = "SELECT * FROM `message` where sendname = ? order by number desc limit ?";
				state = con.prepareStatement(sm);
				state.setInt(2, i);
			}else{
				sm = "SELECT * FROM `message` where sendname = ?";
				state = con.prepareStatement(sm);
			}
			/*
			 sm = "SELECT * FROM `message` where sendname = ? and where state = SUCCESSED order by number desc limit ?";
			 */
			state.setString(1, s);
			result = state.executeQuery();
			
			result.last();
			x = result.getRow();
			System.out.println(x);
			str =  new String[x][columncnt];
			result.first();
			
			while(result.next()){
				for (int j = 0; j < columncnt ; j++){
					str[cnt][j] = result.getString(j + 1);
					pw.println(str[cnt][j]);
					System.out.println("하이하이");
				}cnt++;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("message 테이블의 내용을 출력할수 없습니다.");
		}
	}
	@Override
	public void delete(String s,int i) {
		String del;
		try{
			if(i > 0){
				del = "DELETE FROM `message` WHERE sendname = ? order by number desc limit ?";
				state = con.prepareStatement(del);
				state.setInt(2, i);;
			}else{
				del = "DELETE FROM `message` WHERE sendname = ?";
				state = con.prepareStatement(del);
			}
			state.setString(1, s);
			state.executeUpdate();
		}catch(SQLException e) {
			System.out.println("message테이블의 내용을 삭제할수 없습니다");
		}
	}

}
