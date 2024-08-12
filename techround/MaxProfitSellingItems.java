package techround;

public class MaxProfitSellingItems {

	  public int solveKnapsack(int[] profits, int[] weights, int capacity) {		    
	    int max = 0;
	    for(int i=0; i<weights.length; i++){		     
	       for(int j=i+1; j<weights.length; j++){
	           if(weights[i]+weights[j] == capacity){
	              max = max<(profits[i]+profits[j]) ? profits[i]+profits[j] : max;
	           }
	       }
	    }
	    return max == 0 ? -1 : max;
	  }
	  
	  public static int solveKnapsackProblem(int[] profits, int[] weights, int capacity) {		    
		  
		  if(profits.length<1 || weights.length<1 || capacity<1)
			  return -1;
		  return knapsackAlgo(profits, weights, capacity, 0);
		  
		  
	  }

	  private static int knapsackAlgo(int[] profits, int[] weights, int capacity, int index) {
		  
		  if (capacity <= 0 || index >= profits.length)
		      return 0;
		
		  int profit1 = 0;
		  
		  if(weights[index] <= capacity) {
			  profit1 = profits[index] + knapsackAlgo(profits, weights, capacity-weights[index], index+1);
		  }
		  int profit2 = knapsackAlgo(profits, weights, capacity, index+1);
		  
		  return Math.max(profit1, profit2);
	  }
	  
	//dynamic programming
	  
     public int solveKnapsackProblemDP(int[] profits, int[] weights, int capacity) {		    
		  
		  if(profits.length<1 || weights.length<1 || capacity<1)
			  return -1;
		  int[][] dp = new int[profits.length][capacity+1];
		  return knapsackAlgoDP(dp, profits, weights, capacity, 0);
		  
		  
	  }

	  private int knapsackAlgoDP(int[][] dp, int[] profits, int[] weights, int capacity, int index) {
		  
		  if (capacity <= 0 || index >= profits.length)
		      return 0;
		  
		  if(dp[index][capacity] != 0) {
			  return dp[index][capacity];
		  }
		
		  int profit1 = 0;
		  
		  if(weights[index] <= capacity) {
			  profit1 = profits[index] + knapsackAlgo(profits, weights, capacity-weights[index], index+1);
		  }
		  int profit2 = knapsackAlgo(profits, weights, capacity, index+1);
		  dp[index][capacity] = Math.max(profit1, profit2);
		  
		  return dp[index][capacity];
	  }

	public static void main(String[] args) {
		MaxProfitSellingItems ks = new MaxProfitSellingItems();
	    int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    int maxProfit = ks.solveKnapsackProblemDP(profits, weights, 7);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	    maxProfit = ks.solveKnapsackProblemDP(profits, weights, 6);
	    System.out.println("Total knapsack profit ---> " + maxProfit);
	  }
}
