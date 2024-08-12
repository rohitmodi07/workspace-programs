package challenges.multi;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	private BlockingQueue<Integer> queue;
	private List<Integer> ilist;
	
	public Producer(BlockingQueue<Integer> queue, List<Integer> ilist) {
		this.queue = queue;
		this.ilist = ilist;
	}
	
	public void run() {
		int count = 0;
		while(true) {
			for(int i=0; i<10; i++) {
				try {
					
					System.out.println(" producing ::::: "+i);
					queue.put(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

}
