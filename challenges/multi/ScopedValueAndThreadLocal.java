package challenges.multi;



public class ScopedValueAndThreadLocal {
	
	private static final ThreadLocal<Integer> USER_ID = new ThreadLocal<>();
	private static final ScopedValue<Integer> SCOPED_VALUE = ScopedValue.newInstance();
	
	
	// ThreadLocal is mutable and does not share with multiple threads, each thread has its own copy of ThreadLocal variable, so any
	// modification to the variable will be seen by the thread which modify it, others can not see, others still sees its own copy
	// of variable's value
	
	public void processRequest(int userId) {
		USER_ID.set(userId);
		
		try {
			System.out.println(" xyz"+USER_ID.get());
		}finally {
			USER_ID.remove();
		}
	}
	
	// ScopedValue is immutable and shared the value with all the thread, its scope is block level scope - java 21
	/*
	 * How ScopedValue shares its value with millions of thread, it uses StructuredTaskScope which is based on
	 * Structured Concurrency Java 21 feature, which actually break down the task in sub task and then start
	 * executing it, if any one task fails then it failed the complete operation else it shows the success
	 * 
	 */
	
	public void proceeScopedValue(int id) {
		
		ScopedValue.where(SCOPED_VALUE, id).run(() -> {
			System.out.println(SCOPED_VALUE.get());
		});
		
		// here , scope of this variable is over and gets removed from the memory
		
	}
	
	
	public static void main(String[] args) {
		
    	
    	
    	
    	
	}

}
