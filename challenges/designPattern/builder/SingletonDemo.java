package challenges.designPattern.builder;

public class SingletonDemo {
	
	//Eager initialization
	/*
	private static final SingletonDemo instance = new SingletonDemo();
	
	private SingletonDemo() {
		
	}
	
	public static SingletonDemo getInstance() {
		return instance;
	}
	
	*/
	
	//lazy initialization
	
	/*
	
	private static SingletonDemo instance;
	
	private SingletonDemo() {}
	
	public static SingletonDemo getInstance() {
		if(instance == null) {
			instance = new SingletonDemo();
		}
		return instance;
	}
	
	*/
	
	//synchronized method
	
	/*
	
	private static SingletonDemo instance;
	
	private SingletonDemo() {}
	
	public static synchronized SingletonDemo getInstance() {
		instance = new SingletonDemo();
		return instance;
	}
	*/
	
	//synchronized block
	
	/*
	
	public static SingletonDemo instance;
	
	private SingletonDemo() {}
	
	public static SingletonDemo getInstance() {
		synchronized(instance) {
			instance = new SingletonDemo();
			return instance;
		}
	}
	
	*/
	
	//best way for having singleton 
	
	private static class BillPug{
		
		private static SingletonDemo instance = new SingletonDemo();
		
	}
	
	private SingletonDemo() {}
	
	public static SingletonDemo getInstance() {
		return BillPug.instance;
	}

}
