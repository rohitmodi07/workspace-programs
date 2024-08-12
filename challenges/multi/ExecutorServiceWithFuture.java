package challenges.multi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceWithFuture {

public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		WorkerDemo wd1 = new WorkerDemo(100, "John", 10000, "computer");
		WorkerDemo wd2 = new WorkerDemo(300, "Cena", 30000, "hr");
		WorkerDemo wd3 = new WorkerDemo(200, "sally", 20000, "admin");
		WorkerDemo wd4 = new WorkerDemo(500, "kim", 50000, "facility");
		WorkerDemo wd5 = new WorkerDemo(400, "drek", 40000, "support");
		
		List<WorkerDemo> wlist = Arrays.asList(wd1, wd2, wd3, wd4, wd5);
		
		Map<Integer, WorkerDemo> nwlist = new HashMap<>();
		
		ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		
		List<Future<WorkerDemo>> flist = new ArrayList<>();
		
		for(WorkerDemo wdemo : wlist) {
			Future<WorkerDemo> ft = exec.submit(new Callable<WorkerDemo>() {
				public WorkerDemo call() {
					return wdemo;
				}
			});
			
			flist.add(ft);
		}
		
		while(!exec.awaitTermination(20, TimeUnit.MILLISECONDS)) {
			exec.shutdown();
		}
		
		for(Future<WorkerDemo> fdemo : flist) {
			System.out.println(" future objects ::: "+fdemo.get().wId());
		}
		
		
		/*
		
		for(WorkerDemo wdemo : wlist) {
			exec.submit(new Runnable() {
				public void run() {
					nwlist.put(wdemo.wId(), wdemo);
				}
			});
		}
		
		while(!exec.awaitTermination(20, TimeUnit.MILLISECONDS)) {
			exec.shutdown();
		}
		
		System.out.println(" map is ::::: "+nwlist);
		
		*/
		
		
    }

}
