package challenges.multi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo1 {

	public void addData(CompletableFuture<Integer> cf) {
		cf.thenApply(data -> data *4)
		  .thenApply(data -> data+1)
		  .thenAccept(System.out::println);
	}
	
	
	    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	
    	CompletableFutureDemo1 tp = new CompletableFutureDemo1();
    	
    	CompletableFuture<Integer> cfuture = new CompletableFuture<>();
    	
    	cfuture.complete(10);
    	
    	tp.addData(cfuture);
	
    }
}
