package Mail;

public class Passage{

	public void passage(String to,String from, String title, String body){
		String[] divide = to.split(",");
		
		Mail m = new Mail();
		
		for(int i = 0; i < divide.length; i ++){
			m.mail(divide[i], from, title, body);
		}
		
		Database d = new Database();
		d.data(to,from,title,body,divide.length);

	}
}