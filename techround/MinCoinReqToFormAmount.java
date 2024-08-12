package techround;

import java.util.Arrays;

public class MinCoinReqToFormAmount {

	public static int calculateCoinsToFormSum(int[] coins, int amount) {
		if(coins.length<1 || amount<1)
			return -1;
		
		int[] newcoin = new int[amount + 1];
		Arrays.fill(newcoin, amount + 1);
		newcoin[0] = 0;
		
		System.out.println(" new coin array contains ::: "+Arrays.toString(newcoin));
		
		for (int i = 1; i <= amount; i++) {
			for(int cn : coins) {
				if(i>=cn) {
					newcoin[i] = Math.min(newcoin[i], newcoin[i-cn]+1);
					System.out.println(" i = "+i+ ", newcoin["+i+"] = "+newcoin[i]);
				}
			}
		}
		System.out.println(" new coin array contains ::: "+Arrays.toString(newcoin));
		
		return newcoin[amount]>amount ? -1 : newcoin[amount];
		
	}
	

	public static void main(String[] args) {
				
		int[] arr = {1,2,5};
		
		System.out.println(" combination of steps  ::::: "+calculateCoinsToFormSum(arr, 11));
		
		
	}

}
