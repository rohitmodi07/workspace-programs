package challenges.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class ProdConsuReentrantLock {
	
	private int size;
	private List<Integer> ilist;
	private Lock lock;
	private Condition consumerCondition;
	private Condition producerCondition;
	
	public ProdConsuReentrantLock(int size) {
		this.size = size;
		this.ilist = new ArrayList<>(size);
		this.lock = new ReentrantLock(true);
		this.consumerCondition = lock.newCondition();
		this.producerCondition = lock.newCondition();
	}
	
	public void procuder(int data) throws InterruptedException {
		lock.lock();
		try {
			
			while(ilist.size() == size) {
				producerCondition.await();
			}
			System.out.println(Thread.currentThread().getName()+" producing :::: "+data);
			ilist.add(data);
			consumerCondition.signalAll();
			
		} finally {
			lock.unlock();
		}
		
	}
	
	public void consumer() throws InterruptedException {
		lock.lock();
		try {
			
			while(ilist.isEmpty()) {
				consumerCondition.await();
			}
			System.out.println(Thread.currentThread().getName()+" consuming ::::: "+ilist.remove(0));
			producerCondition.signalAll();
			
		} finally {
			lock.unlock();
		}
		
	}
	

	public static void main(String[] args){   
		
		ProdConsuReentrantLock tp = new ProdConsuReentrantLock(5);
		
		Thread t0 = new Thread(() -> {
        	for(int i=0; i<5; i++) {
        		try {
					tp.procuder(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }, "t0");
		
        Thread t1 = new Thread(() -> {
        	for(int i=5; i<10; i++) {
        		try {
					tp.procuder(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }, "t1");
        
        Thread t2 = new Thread(() -> {
        	
        	for(int i=0; i<2; i++) {
        		try {
					tp.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        }, "T2");
        
        Thread t3 = new Thread(() -> {
        	for(int i=0; i<2; i++) {
        		try {
					tp.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        }, "T3");
        
        
        Thread t4 = new Thread(() -> {
        	for(int i=0; i<2; i++) {
        		try {
					tp.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        }, "T4");
        
        Thread t5 = new Thread(() -> {
        	for(int i=0; i<2; i++) {
        		try {
					tp.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        }, "T5");
        
        Thread t6 = new Thread(() -> {
        	for(int i=0; i<2; i++) {
	    		try {
					tp.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
    	
    }, "T6");
        
        
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
      	
	   
    }

}
