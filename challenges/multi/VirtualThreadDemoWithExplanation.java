package challenges.multi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class VirtualThreadDemoWithExplanation {
	
	private List<Integer> nlist;
	private Map<Integer, String> nmap;
	private Set<String> hset;
	
	public VirtualThreadDemoWithExplanation() {
		this.nlist = new ArrayList<>();
		this.nmap = new HashMap<>();
		this.hset = new HashSet<>();
	}
	
	public void addInList() {
		System.out.println(" Thread name in addInList :- "+Thread.currentThread());
		for(int i=1; i<=10; i++) {
			nlist.add(i);
		}
	}
	
	public void addInMap() {
		System.out.println(" Thread name in addInMap :- "+Thread.currentThread());
		Map<Integer, String> tmap = new HashMap<>();
		tmap.put(1, "one");
		tmap.put(2, "one");
		tmap.put(3, "one");
		tmap.put(4, "one");
		tmap.put(5, "one");
		
		this.nmap =tmap;
	}
	
	public void addInSet() {
		System.out.println(" Thread name in addInSet :- "+Thread.currentThread());
		hset.add("one");
		hset.add("two");
		hset.add("three");
		hset.add("four");
		hset.add("five");
	}

	public static void main(String[] args) throws InterruptedException {
		
		VirtualThreadDemoWithExplanation lt = new VirtualThreadDemoWithExplanation();
		
		ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor();
		
		List<Integer> nlist = new ArrayList<>();
		Map<Integer, String> nmap = new HashMap<>();
		Set<String> hset = new HashSet<>();
		
		for(int i=1; i<=5; i++) {
			exec.submit(() -> {
				lt.addInList();
				lt.addInMap();
				lt.addInSet();
			});
		}
		
		
		exec.shutdown();
		exec.awaitTermination(100, TimeUnit.MILLISECONDS);
		
		System.out.println(" list content :: "+lt.nlist);
		System.out.println(" map content :: "+lt.nmap);
		System.out.println(" set content :: "+lt.hset);
		
		/*
		 * Multiple virtual threads gets created and they utilize available platform thread(thread equivalent to CPU core) 
		 * to run the task and rotate the platform thread among them.
		 * for example, if we have a platform thread which created 5 virtual thread internally to run 20 task
		 * then these virtual threads can utilize any platform thread, 3 virtual thread can run one one platform thread
		 * and 2 can run in another platform thread
		 * 
		 * so without Virtual thread :
		 * 
		 * 1 task can be run by one platform thread
		 * 
		 * with Virtual thread
		 * 
		 * multiple task can be run by one platform thread 
		 * 
		 * 
		 * 
		 * OUTPUT -
		 * 
		 *   Thread name in addInList :- VirtualThread[#26]/runnable@ForkJoinPool-1-worker-5
			 Thread name in addInList :- VirtualThread[#21]/runnable@ForkJoinPool-1-worker-1
			 Thread name in addInList :- VirtualThread[#24]/runnable@ForkJoinPool-1-worker-3
			 Thread name in addInMap :- VirtualThread[#21]/runnable@ForkJoinPool-1-worker-3
			 Thread name in addInMap :- VirtualThread[#24]/runnable@ForkJoinPool-1-worker-2
			 Thread name in addInList :- VirtualThread[#23]/runnable@ForkJoinPool-1-worker-2
			 Thread name in addInList :- VirtualThread[#25]/runnable@ForkJoinPool-1-worker-4
			 Thread name in addInMap :- VirtualThread[#25]/runnable@ForkJoinPool-1-worker-2
			 Thread name in addInSet :- VirtualThread[#25]/runnable@ForkJoinPool-1-worker-2
			 Thread name in addInMap :- VirtualThread[#26]/runnable@ForkJoinPool-1-worker-5
			 Thread name in addInSet :- VirtualThread[#21]/runnable@ForkJoinPool-1-worker-3
			 Thread name in addInSet :- VirtualThread[#24]/runnable@ForkJoinPool-1-worker-2
			 Thread name in addInMap :- VirtualThread[#23]/runnable@ForkJoinPool-1-worker-5
			 Thread name in addInSet :- VirtualThread[#26]/runnable@ForkJoinPool-1-worker-5
			 Thread name in addInSet :- VirtualThread[#23]/runnable@ForkJoinPool-1-worker-4
			 list content :: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
			 map content :: {1=one, 2=one, 3=one, 4=one, 5=one}
			 set content :: [four, one, two, three, five]
		 * 
		 */
		
		
	}

}
