package challenges.multi;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String args[]) {
    	
       ArrayList<Integer> arl = new ArrayList<Integer>();
       int count = 1;
       final CountDownLatch latch = new CountDownLatch(3);
       Thread cacheService = new Thread(new Service("CacheService", 100, latch, arl, count));
       Thread alertService = new Thread(new Service("AlertService", 100, latch, arl, count+10));
       Thread validationService = new Thread(new Service("ValidationService", 100, latch, arl, count+20));
      
       cacheService.start(); //separate thread will initialize CacheService
       alertService.start(); //another thread for AlertService initialization
       validationService.start();
      
       // application should not start processing any thread until all service is up

      // and ready to do there job.
       // Countdown latch is idle choice here, main thread will start with count 3

      // and wait until count reaches zero. each thread once up and read will do 

      // a count down. this will ensure that main thread is not started processing

      // until all services is up.
      
       //count is 3 since we have 3 Threads (Services)
      
       try{
            latch.await();  //main thread is waiting on CountDownLatch to finish
            System.out.println("All services are up, Application is starting now : "+arl.size());
            if(arl.size()>=28){
            	System.out.println("--1.write your logic--");
            }else{
            	System.out.println("--2.write your logic--");
            }
       }catch(InterruptedException ie){
           ie.printStackTrace();
       }
      
    }
  
}
