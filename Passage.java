package Mail;

public class Passage{

	public void passage(String to,String from, String title, String body){
		Mail m = new Mail(to,from,title,body);
		m.mail();
		
		Database d = new Database();
		String[] divide = to.split(",");
		d.data(to,from,title,body,divide.length);

	}
}