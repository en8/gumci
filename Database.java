package Mail;

public interface Database {

	public default void enter(boolean enter){
		if(enter == false){
			System.out.println("데이터베이스에 접속하지 못햇습니다");
		}
	}
	
	void insertm(String to, String from, String title, String body);
	void inserti(String to, String from, int i);
	void select();
	void delete();
}