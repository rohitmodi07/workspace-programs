package challenges.allarray;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultithreadingConcepts implements Runnable{
	
	private int count = 0;
	
	public int calCount() {
		for (int i = 0; i < 100; i++) {
			count++;
		}
		return count;
	}
	
	public void run() {
		System.out.println(calCount());
	}

	public static void main(String[] args) {
		int numofthread = Runtime.getRuntime().availableProcessors();
		System.out.println("number of core running : : "+numofthread);
		ExecutorService executor = Executors.newFixedThreadPool(numofthread);
		for (int i = 0; i < 10; i++) {
			executor.submit(new MultithreadingConcepts());
			System.out.println(Thread.currentThread().getName());
		}
		
		executor.shutdown();
		
		ScheduledExecutorService sexecutor = Executors.newScheduledThreadPool(numofthread);
		sexecutor.schedule(new MultithreadingConcepts(), 10, TimeUnit.MICROSECONDS);
		sexecutor.scheduleAtFixedRate(new MultithreadingConcepts(), 15, 10, TimeUnit.MICROSECONDS);
		sexecutor.scheduleWithFixedDelay(new MultithreadingConcepts(), 15, 10, TimeUnit.MICROSECONDS);

	}
	
	public void metnew() {
		new ThreadPoolExecutor(10, 10, 15, TimeUnit.MICROSECONDS, new LinkedBlockingQueue());
	}

}
