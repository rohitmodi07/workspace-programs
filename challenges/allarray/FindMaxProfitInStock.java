package challenges.allarray;

public class FindMaxProfitInStock {
	
	public static int findMaxProfit(int[] stock) {
		if(stock == null || stock.length<1)
			return -1;
		
		int diff = 0;
		int profit = 0;
		int min = stock[0];
		
		for(int i = 1; i < stock.length; i++) {
			diff = stock[i]-min;
			profit = Math.max(profit, diff);
			min = Math.min(min, stock[i]);
		}
		return profit;
		
	}
	
	public static int maxProfit1(int[] arr) { //7,1,5,3,6,4
		if(arr == null || arr.length<1)
			return -1;
		int max = 0;
		int min = arr[0];
		int i=0;
		
		while(i<arr.length-1) {
			if(arr[i]<arr[i+1]) {
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i+1]);
				
				System.out.println(" min : "+min+ ", max : "+max);
			}
			i++;
		}
		
		
		return max-min;
	}
	    
    public static void main(String[] args) {
    	
    	int[] arr = {7,1,5,3,6,4};
    	
    	System.out.println(maxProfit1(arr));
	
    }

}
