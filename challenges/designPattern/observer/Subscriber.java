package challenges.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
	private String name;
	private List<Channel> channelList;
	
	public Subscriber(String name) {
		this.name = name;
		this.channelList = new ArrayList<>();
	}
	
	public void subscribe(Channel channel) {
		this.channelList.add(channel);
	}
	
	public void unSubscribe(Channel channel) {
		this.channelList.remove(channel);
	}
	
	public void update(String channelName) {
		System.out.println(" new video uploaded by ::: "+channelName);
	}

}
