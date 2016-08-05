package Mail;

public class Passage extends Thread {
	String to;
	String from;
	String title;
	String body;
	
	Passage(String to,String from, String title, String body){
		this.to = to;
		this.from = from;
		this.title = title;
		this.body = body;
	}
	public void run(){
		String[] divide = to.split(",");
		Mail mail = new Mail();
		for(int i = 0; i < divide.length; i ++){
			mail.run(divide[i],from,title,body);
			try{
			sleep(1000);
			}catch (InterruptedException e){
			e.printStackTrace();
			}

		}

		Database d = new Database();
		d.data(to,from,title,body,divide.length);
	}
}
