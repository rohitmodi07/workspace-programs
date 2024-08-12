package challenges.multi;

import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemoRev extends RecursiveTask<Integer>{
	
	int n;
	
	public ForkJoinPoolDemoRev(int n) {
		this.n = n;
	}
	
	public Integer compute() {
		if(n<=1) {
			return n;
		}
		ForkJoinPoolDemoRev f1 = new ForkJoinPoolDemoRev(n-1);
		f1.fork();
		
		ForkJoinPoolDemoRev f2 = new ForkJoinPoolDemoRev(n-2);
		f2.fork();
		
		return f1.join() + f2.join();
	}

	public static void main(String[] args) {
		
		ForkJoinPoolDemoRev fj = new ForkJoinPoolDemoRev(6);
		System.out.println(fj.compute());

	}

}
