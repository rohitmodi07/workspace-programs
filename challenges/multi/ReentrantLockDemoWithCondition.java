package challenges.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockDemoWithCondition {
	
	private int size;
	private Lock lock;
	private Condition consumerCondition;
	private Condition producerCondition;
	private List<Integer> intlist;
	
	public ReentrantLockDemoWithCondition(int size) {
		this.size = size;
		this.lock = new ReentrantLock(true);
		this.consumerCondition = lock.newCondition();
		this.producerCondition = lock.newCondition();
		this.intlist = new ArrayList<>(size);
	}
	
	public void producer() throws InterruptedException {
		lock.lock();
		
		try {
			for(int i=0; i<10; i++) {
				
				if(size == intlist.size()) {
					producerCondition.await();
				}
				intlist.add(i);
				System.out.println("producing " + i);
				consumerCondition.signalAll();
			}
			
		}finally {
			lock.unlock();
		}
	}
	
	public void consumer() throws InterruptedException {
		lock.lock();
		
		try {
			for(int i=0; i<10; i++) {
				
				if(intlist.isEmpty()) {
					consumerCondition.await();
				}
				System.out.println("consuming " + intlist.remove(0));
				producerCondition.signalAll();
			}
			
		}finally {
			lock.unlock();
		}
	}
	
	    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	
    	ReentrantLockDemoWithCondition tp = new ReentrantLockDemoWithCondition(2);
    	
        Thread t1 = new Thread(new Runnable() {
        	public void run() {
        		try {
					tp.producer();
				} catch (InterruptedException e) {
					
				}
        	}
        });
        
        Thread t2 = new Thread(new Runnable() {
        	public void run() {
        		try {
					tp.consumer();
				} catch (InterruptedException e) {
					
				}
        	}
        });
        
        t1.start();
        t2.start();
	
    }

}
