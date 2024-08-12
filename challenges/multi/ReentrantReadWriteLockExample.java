package challenges.multi;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReentrantReadWriteLockExample { 

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true); 

    private static String message = "a"; 
    private static ArrayList<String> arrInt = new ArrayList<String>(); 
    private volatile static int i=0;
 
    public static void main(String[] args) throws InterruptedException{
 
        Thread t1 = new Thread(new Read(), "reader_1"); 
        Thread t2 = new Thread(new Read(), "reader_2");
        Thread t3 = new Thread(new Read(), "reader_3");

        Thread t4 = new Thread(new WriteA(), "writer_1"); 

        Thread t5 = new Thread(new WriteB(), "writer_2"); 

        t1.start(); 

        t2.start(); 

        t3.start(); 
        
        t4.start(); 

        t5.start(); 
        
        //t1.join(); 

        //t2.join(); 

        //t3.join(); 
        
        if(arrInt.size()>=19){
        	System.out.println("Addition in ArrayList has completed : ");
        }

    }
    static class Read implements Runnable { 
 
        public void run() { 
        	System.out.println("Start time : "+System.currentTimeMillis());
            for(int i = 0; i<= 10; i ++) { 

                if(lock.isWriteLocked()) { 

                    System.out.println("I'll take the lock from Write"); 

                } 

                lock.readLock().lock(); 

                System.out.println("ReadThread " + Thread.currentThread().getName() + " ---> Message is " + message ); 
                System.out.println("ReadThread " + Thread.currentThread().getName() + " ---> Size is " + arrInt.size() );

                lock.readLock().unlock(); 

                } 
                System.out.println("End time : "+System.currentTimeMillis());
            } 

        } 
    static class WriteA implements Runnable { 
 
        public void run() { 
            System.out.println("Start time : "+System.currentTimeMillis());
            for(int i = 0; i<= 10; i ++) { 
         
                try { 

                    lock.writeLock().lock(); 

                    message = message.concat("a");
                    arrInt.add(message);

                } finally { 

                    lock.writeLock().unlock(); 

                } 

            } 
            
            System.out.println("End time : "+System.currentTimeMillis());
            } 

        } 

    static class WriteB implements Runnable { 

        public void run() { 
        	System.out.println("Start time : "+System.currentTimeMillis());
            for(int i = 0; i<= 10; i ++) { 

                try { 

                    lock.writeLock().lock(); 

                    message = message.concat("b"); 
                    arrInt.add(message);

                } finally { 

                    lock.writeLock().unlock(); 

                } 

            } 
            System.out.println("End time : "+System.currentTimeMillis());
            } 

        } 

} 

