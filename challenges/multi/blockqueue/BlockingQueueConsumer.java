package challenges.multi.blockqueue;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public BlockingQueueConsumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		
			try {
				System.out.println(" consuming :: "+queue.take());
			} catch (InterruptedException e) {
				
			}
		
		
		
	}

}
