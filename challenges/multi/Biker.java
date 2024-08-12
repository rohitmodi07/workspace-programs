package challenges.multi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Biker implements Runnable 
{
 
    private CyclicBarrier checkPoint;
 
    public Biker(CyclicBarrier checkPoint) {
        this.checkPoint = checkPoint;
    }
 
    // Code to be executed by each biker
    @Override
    public void run() 
    {
        try
        {
            System.out.println(Thread.currentThread().getName() + " has left Manali");
             
            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has left the first checkpoint / barrier");
             
            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has left the second checkpoint / barrier");
             
            checkPoint.await();
            System.out.println(Thread.currentThread().getName() + " has reached Leh");
             
        } 
        catch (InterruptedException ex) 
        {
            ex.printStackTrace();
        }
        catch(BrokenBarrierException e){
        	e.printStackTrace();
        }
    }
}

