package challenges.allarray;

import java.util.concurrent.Callable;

public class CallApi implements Callable<Integer>{
	
	private int num;
	
	public CallApi(int num) {
		this.num = num;
	}
	
	public Integer call() {
	
		return num*num;
	}

}
