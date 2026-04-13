package leetcode.dynamicprograms;

public class NumOfCoinsComboMakeToAmount {
	
	public static int numOfCoinsComboToAmount(int[] coins, int amount) {
		if(coins == null || coins.length<1)
			return -1;
		int[] dp = new int[amount+1];
		dp[0] = 1;
		
		for(int i=coins.length-1; i>=0; i--) {
			for(int j=1; j<=amount; j++) {
				if(j>=coins[i]) {
					dp[j] = dp[j] + dp[j-coins[i]];
				}
			}
		}
		
		
		return dp[amount];
	}
	

	public static void main(String[] args){       
    
		int[] coins = {2,4};
    	System.out.println(" min number of coins :::: "+numOfCoinsComboToAmount(coins, 7));
    }

}
