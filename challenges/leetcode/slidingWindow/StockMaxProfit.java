package leetcode.slidingWindow;

public class StockMaxProfit {
	
	// best time to buy and sell stocks
		/*
		 * Input: prices = [10,1,5,6,7,1]     Output: 6
		 * Input: prices = [10,8,7,5,2]       Output: 0
		 */
		
		public static int maxProfit(int[] stocks) {
			if(stocks == null || stocks.length<1)
				return -1;
			int min = 1;
			int max = 1;
			
			for(int i=0; i<stocks.length-1; i++) {
				if(stocks[i]<stocks[i+1]) {
					min = Math.min(min, stocks[i]);
					max = Math.max(max, stocks[i+1]);
				}
			}
			
			return max-min;
			
		}
		
		

		public static void main(String[] args) {

			int[] nums = {10,1,5,6,7,1};
			System.out.println(" max profit in stocks ::::: "+maxProfit(nums));
			
			int[] nums1 = {10,8,6,5,1};
			System.out.println(" max profit in stocks ::::: "+maxProfit(nums1));
		}

}
