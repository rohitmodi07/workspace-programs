package challenges.multi;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	 
    public static void main(String args[]) 
    {
 
        // creating CyclicBarrier (checkPoint) with 
        // 4 parties (Bikers) threads that need to call await()
        final CyclicBarrier checkPoint = new CyclicBarrier(4, new Runnable(){
            @Override
            public void run(){
                //This task will be executed once all biker threads will reach barrier
                System.out.println("\nAll bikers have arrived to checkpoint. Lets refill the petrol\n");
            }
        });
 
        //starting each of thread
        Thread biker1 = new Thread(new Biker(checkPoint), "Biker Thread 1");
        Thread biker2 = new Thread(new Biker(checkPoint), "Biker Thread 2");
        Thread biker3 = new Thread(new Biker(checkPoint), "Biker Thread 3");
        Thread biker4 = new Thread(new Biker(checkPoint), "Biker Thread 4");
 
        biker1.start();
        biker2.start();
        biker3.start();
        biker4.start();
        
        System.out.println(" process has completed ");
         
       
    }
}

