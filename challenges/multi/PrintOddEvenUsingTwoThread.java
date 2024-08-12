package challenges.multi;


public class PrintOddEvenUsingTwoThread {
	
  public  void  printEvenOddElement(int num) throws InterruptedException {
		
		String op = Thread.currentThread().getName();
		
		 synchronized (this) {
			
			for(int i=1; i<=num; i++) {
				
				if(i%2 == 0 && "even".equalsIgnoreCase(op)) {
					notifyAll();
					System.out.println(" even number : : "+i);
					wait();
				}else if(i%2 == 1 && "odd".contentEquals(op)){
					notifyAll();
					System.out.println(" odd number : : "+i);
					wait();
				}
			}
		 }
		
	}
  
	    
	    
    public static void main(String[] args) throws InterruptedException {
    	
    	PrintOddEvenUsingTwoThread tp = new PrintOddEvenUsingTwoThread();
        
    	Thread even = new Thread(new Runnable() {
    		public void run() {
    			try {
					tp.printEvenOddElement(10);;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}, "even");
    	
    	Thread odd = new Thread(new Runnable() {
    		public void run() {
    			try {
					tp.printEvenOddElement(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}, "odd");
    	
    	odd.start();
    	even.start();
    	
    	
    }

}
