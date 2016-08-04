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
		for(int i = 0; i < divide.length; i ++){
		Thread mail = new Mail(divide[i],from,title,body);
		mail.start();
		}
		try {
			Thread.currentThread().join();
			Database data = new Database();
			data.data(to,from,title,body);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}