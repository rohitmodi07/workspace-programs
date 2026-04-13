package leetcode.dynamicprograms;

import java.util.Map;
import java.util.HashMap;

public class SellStockWithMaxProfit {
	
	private static Map<String, Integer> smap = new HashMap<>();
	
	public static int maxProfitWithMap(int[] stockPrice) { // 1,3,4,6,0,4
		if(stockPrice == null || stockPrice.length<1)
			return -1;
		
		return dfs(0, true, stockPrice);
	}
	
	
	private static int dfs(int i, boolean buying, int[] stockPrice) {
		
		if(i>=stockPrice.length) {
			return 0;
		}
		
		String key = i+"-"+buying;
		
		if(smap.containsKey(key)) {
			return smap.get(key);
		}
		
		if(buying) {
			int buy = dfs(i+1, false, stockPrice)-stockPrice[i];
			int cooldown = dfs(i+1, buying, stockPrice);
			
			smap.put(key, Math.max(cooldown, buy));
		}else {
			int sell = dfs(i+2, true, stockPrice)+stockPrice[i];
			int cooldown = dfs(i+1, buying, stockPrice);	
			smap.put(key, Math.max(cooldown, sell));
		}
		
		return smap.get(key);
	}


	public static int maxProfitLC(int[] prices) {
        int n = prices.length;
        int dp1_buy = 0, dp1_sell = 0;
        int dp2_buy = 0;

        for (int i = n - 1; i >= 0; i--) {
            int dp_buy = Math.max(dp1_sell - prices[i], dp1_buy);
            int dp_sell = Math.max(dp2_buy + prices[i], dp1_sell);
            dp2_buy = dp1_buy;
            dp1_buy = dp_buy;
            dp1_sell = dp_sell;
        }

        return dp1_buy;
    }

	public static void main(String[] args){       
    
		int[] stocks = {1,3,4,6,0,4};
		System.out.println(" max stock value :::: "+maxProfitWithMap(stocks));
		
		int[] nums = {1,3,4,0,4};
		//System.out.println(" max profit :: "+maxStock(nums));
		
		int[] nums1 = {1};
		//System.out.println(" max profit :: "+maxStock(nums1));
		
		
		int[] nums2 = {1,3,4,2,4,1,5,2};
		//System.out.println(" max profit :: "+maxStock(nums2));
    	
    }

}
