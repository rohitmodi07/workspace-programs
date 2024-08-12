package challenges.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo2 {

   private List<Integer> intlist;
	
	public CompletableFutureDemo2() {
		this.intlist = new ArrayList<>();
	}
	
	public List<Integer> addOneToTen(){
		
		for(int i=1; i<=10; i++) {
			intlist.add(i);
		}
		return intlist;
	}
	
    public List<Integer> addElevenToTwenty(){
		
		for(int i=11; i<=20; i++) {
			intlist.add(i);
		}
		return intlist;
	}
    
    public List<Integer> throwException(){
    	
    	int val = 0;
    	
    	int size = intlist.size()/val;
		
		for(int i=11; i<=20; i++) {
			intlist.add(i);
		}
		return intlist;
	}
    
    public List<Integer> rectifyExceptionAndProvideSomeFunction(Throwable e){
    	
    	System.out.println("exception occurred ::::: "+e.getMessage());
    	
		
		for(int i=21; i<=30; i++) {
			intlist.add(i);
		}
		return intlist;
	}
    
    public List<Integer> addThirtyOneToForty(){
		
		for(int i=31; i<=40; i++) {
			intlist.add(i);
		}
		return intlist;
	}
	
	
	    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
    	
    	CompletableFutureDemo2 tp = new CompletableFutureDemo2();
    	
    	CompletableFuture.supplyAsync(() -> tp.addOneToTen())
    	                 .thenApply(lst -> tp.addElevenToTwenty())
    	                 .thenApply(list -> tp.throwException())
    	                 .exceptionally(tp::rectifyExceptionAndProvideSomeFunction)
    	                 .thenApply(lst -> tp.addThirtyOneToForty());
    	                 
    	System.out.println(" list is :::::::::"+tp.intlist);
	
    }
}
