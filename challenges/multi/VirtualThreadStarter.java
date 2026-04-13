package challenges.multi;


public class VirtualThreadStarter {
	
   public void printOddEven1(int num) {
		
		
		for(int i=1; i<=num; i++) {
			
			if(i%2 == 1) {
				System.out.println(" odd - "+i);
				
			}else if(i%2 == 0) {
				
				System.out.println(" even - "+i);
				
			}
			
		}
	}


	public static void main(String[] args){
		
		VirtualThreadStarter lt = new VirtualThreadStarter();
		

        // Option 1: Using Thread.startVirtualThread() 
        // Best for quick, simple tasks. Starts immediately.
        //Thread vThread1 = Thread.startVirtualThread(() -> {
        	//lt.printOddEven1(10);
        //});
        
        Thread vt2 = Thread.ofVirtual().name(" odd ", 1).start(() -> {
        	lt.printOddEven1(10);
        });

        // Option 2: Using Thread.ofVirtual()
        // Best when you want to name your thread for easier debugging.
        //Thread vThread2 = Thread.ofVirtual()
        //        .name("custom-worker-", 1) // Names the thread "custom-worker-1"
        //        .start(task);

        // Optional: Wait for them to finish (Virtual threads are daemon by default)
        try {
        	vt2.join();
			 //vThread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("All virtual threads finished.");
		
	
	}


}
