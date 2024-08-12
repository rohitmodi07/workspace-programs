package challenges.designPattern.observer;

public class VideoUploaderService {
	
	public static void main(String[] args) {
		
		Channel ch = new Channel("tech-maze");
		Subscriber sub = new Subscriber("Rohit");
		
		sub.subscribe(ch);
		ch.addSubscriber(sub);
		
		ch.upload();
	}

}
