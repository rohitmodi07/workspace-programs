package challenges.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		List<Integer> ilist = new ArrayList<>();
		
		Thread t1 = new Thread(new Producer(queue, ilist));
		Thread t2 = new Thread(new Consumer(queue, ilist));
		
		t1.start();
		t2.start();

	}

}
