package challenges.multi.blockqueue;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public BlockingQueueProducer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		
		for(int i=1; i<=3; i++) {
			
			try {
				System.out.println(" producing :: "+i);
				queue.put(i);
			} catch (InterruptedException e) {
				
			}
		}
		
		
	}

}
