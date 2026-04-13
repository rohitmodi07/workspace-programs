package challenges.designPattern.singleton;


public class SingletonDesignPatternFlow {
	
	//eager initialization
	
		/*
		
		private static final SingletonDesignPatternFlow instance = new SingletonDesignPatternFlow();
		
		private SingletonDesignPatternFlow() {}
		
		public static SingletonDesignPatternFlow getInstance() {
			return instance;
		}

	    */
		
		//lazy initialization
		
		/*
		private static SingletonDesignPatternFlow instance;
		
		private SingletonDesignPatternFlow() {
			
		}
		
		public static SingletonDesignPatternFlow getInstance() {
			if(instance == null) {
				instance = new SingletonDesignPatternFlow();
			}
			return instance;
		}
		*/
		
		//synchronized method
		
		/*
		 
		private static SingletonDesignPatternFlow instance;
		
		private SingletonDesignPatternFlow() {
			
		}
		
		public static synchronized SingletonDesignPatternFlow getInstance() {
			if(instance == null) {
				instance = new SingletonDesignPatternFlow();
			}
			return instance;
		}
		
		*/
		
		// synchronized block
		
		/*
		
		private static SingletonDesignPatternFlow instance;
		
		private SingletonDesignPatternFlow() {}
		
		public static SingletonDesignPatternFlow getInstance() {
			synchronized (instance) {
				instance = new SingletonDesignPatternFlow();
			}
			return instance;
		}
		
		*/
		
		//best way of implementing Singleton
		
		private static class BillPugg{
			private static SingletonDesignPatternFlow instance = new SingletonDesignPatternFlow();
		}
		
		private SingletonDesignPatternFlow() {}
		
		public static SingletonDesignPatternFlow getInstance() {
			return BillPugg.instance;
		}

}
