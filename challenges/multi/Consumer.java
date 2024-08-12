package challenges.multi;

import java.util.concurrent.BlockingQueue;
import java.util.List;
import java.util.ArrayList;

public class Consumer implements Runnable {
	
	private BlockingQueue<Integer> queue;
	private List<Integer> ilist;
	
	public Consumer(BlockingQueue<Integer> queue, List<Integer> ilist) {
		this.queue = queue;
		this.ilist = ilist;
	}
	
	public void run() {
		int count = 0;
		while(true) {
			try {
				count++;
				System.out.println(" consuming ::::: "+queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(count>8) {
				break;
			}
		}
	}
	

}
