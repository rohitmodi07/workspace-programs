package challenges.multi.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMainDemo {
	
	public static void main(String[] args) {
		
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
		
		Thread t1 = new Thread(new BlockingQueueProducer(queue));
		Thread t2 = new Thread(new BlockingQueueConsumer(queue));
		Thread t3 = new Thread(new BlockingQueueConsumer(queue));
		Thread t4 = new Thread(new BlockingQueueConsumer(queue));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
