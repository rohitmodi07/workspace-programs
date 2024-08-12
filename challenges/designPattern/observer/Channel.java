package challenges.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
	private String channelName;
	private List<Subscriber> subsList;
	
	public Channel(String channelName) {
		this.channelName = channelName;
		this.subsList = new ArrayList<>();
	}
	
	public void addSubscriber(Subscriber sub) {
		this.subsList.add(sub);
	}
	
	public void upload() {
		System.out.println("uploaded a new video");
		notifyAllSubscribers(channelName);
	}

	private void notifyAllSubscribers(String channelName) {
		for(Subscriber sub : subsList) {
			sub.update(channelName);
		}
		
	}

}
