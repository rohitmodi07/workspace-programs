package leetcode.graphs;

import java.util.Arrays;

public class CheapestFlight {
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

	      if(flights == null || flights.length<1)
	    	  return -1;
	      
	      
	      int[] dp = new int[n];
	      Arrays.fill(dp, Integer.MAX_VALUE);
	      
	      dp[src] = 0;
	      
	      System.out.println(" dp at start : "+Arrays.toString(dp));
	      
	      for(int i=0; i<=k; i++) {   // k=1,src = 0, dst = 3 , {0,1,200},{1,2,100},{1,3,300},{2,3,100}
	    	  
	    	  int[] tempDp = Arrays.copyOf(dp, n);
	    	  
	    	  for(int[] f : flights) {
	    		  int s = f[0];
	    		  int d = f[1];
	    		  int p = f[2];
	    		  
	    		  System.out.println(" dp["+s+"] - "+dp[s]);
	    		  System.out.println(" tempDp["+d+"] - "+tempDp[d]);
	    		  
	    		  if(dp[s] == Integer.MAX_VALUE) {
	    			  continue;
	    		  }
	    		  
	    		  if(dp[s]+p<tempDp[d]) {
	    			  tempDp[d] = dp[s]+p;
	    		  }
	    		  System.out.println(" tempDp in loop : "+Arrays.toString(tempDp));
	    		  
	    	  }
	    	  dp = tempDp;
	    	  
	    	  System.out.println(" dp at end of loop : "+Arrays.toString(dp));
	    	  
	      }
	      
	      System.out.println(" dp before result : "+Arrays.toString(dp));
	      
	      return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
	      

	    }
		

		public static void main(String[] args){
			
			int[][] flights = {{0,1,200},{1,2,100},{1,3,300},{2,3,100}};
			System.out.println(findCheapestPrice(4,flights, 0, 3, 1));
			
	    }

}
