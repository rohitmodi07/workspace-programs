package challenges.allarray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteDemoFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executors = Executors.newFixedThreadPool(4);
		List<Future<Integer>> listoffuture = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Future<Integer> future = executors.submit(new CallApi(i));
			listoffuture.add(future);
		}
		
		executors.shutdown();
		
		for (int i = 0; i < listoffuture.size(); i++) {
			Future<Integer> fut = listoffuture.get(i);
			System.out.println(fut.get());
		}
		
		

	}

}
