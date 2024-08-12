package challenges.multi;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

class Service implements Runnable{
	
	
    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;
    private ArrayList<Integer> arl = new ArrayList<Integer>();
    int count;
  
    public Service(String name, int timeToStart, CountDownLatch latch, ArrayList<Integer> arl, int count){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
        this.arl=arl;
        this.count=count;
    }
  
    @Override
    public void run() {
        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println( name + " is Up");
        for(int i=0;i<10;i++){
        	if(arl.size()<=30){
        	 arl.add(count);
        	 count++;
        	}
        }
        System.out.println("The count is :"+count);
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
  
}
