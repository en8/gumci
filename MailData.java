package Mail;

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
	private ResultSet result = null;
	private PreparedStatement state = null;
	
	int x = 0;
	int columncnt = 0;
	int cnt = 0;
	String[][] str = null;
	
	MailData(){
		try{
			Class.forName(driver); //driver 등록
			con = DriverManager.getConnection(db,id,pw);
			state = con.prepareStatement(ip);
			result = state.executeQuery();
			while(result.next()){
				list.add(result.getString("ip"));
			}	
		}catch(Exception e){
			enter(false);
			e.printStackTrace();
		}
	}
	
	MailData(String s,int i){
		try{
			Class.forName(driver); //driver 등록
			con = DriverManager.getConnection(db,id,pw);
			state = con.prepareStatement(column);
			result = state.executeQuery();
			while(result.next()){
				columncnt = result.getInt("COUNT(*)");
			}
			if (i == 1){
				show(s);
			}else{
				delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void show(String s){
		try{
			state = con.prepareStatement(sm);
			state.setString(1, s);
			result = state.executeQuery();
			
			result.last();
			x = result.getRow();
			
			str =  new String[x][columncnt];
			result.first();
			
			while(result.next()){
				for (int i = 0; i < columncnt ; i++){
					str[cnt][i] = result.getString(i+1);
				}cnt++;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("message 테이블의 내용을 출력할수 없습니다.");
		}
	}
	
	@Override
	public void insertm(String to, String from, String title, String body, boolean send){
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
	public void delete() {
		try{
			state = con.prepareStatement(del);
			state.executeUpdate();
		}catch(SQLException e) {
			System.out.println("message테이블의 내용을 삭제할수 없습니다");
		}
	}
}
