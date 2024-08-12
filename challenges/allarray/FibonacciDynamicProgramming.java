package challenges.allarray;

import java.util.Arrays;

public class FibonacciDynamicProgramming {
	
public static int fibonacciNumber(int n) { //1,1,2,3,5,8
		
		if(n<=2)
			return 1;
		return fibonacciNumber(n-1) + fibonacciNumber(n-2);
		
	}
	
    public static int fibonacciNumberMemoization(int n, int[] memo) { //1,1,2,3,5,8
		
		int result = 0;
		
		if(n == memo[n]) {
			return memo[n];
		}
		
		if(n<=2) {
			result =  1;
		}else {
			result = fibonacciNumberMemoization(n-1, memo) + fibonacciNumberMemoization(n-2, memo);
		}
		memo[n] = result;
		System.out.println(" memo is ::::: "+Arrays.toString(memo));
		return result;
		
	}
    
    public static int fibonacciNumberMemoizationNonRec(int n) { //1,1,2,3,5,8
		
		int result = 0;
		int[] memo = new int[n+1];
		
		for(int i=1; i<n+1; i++) {
			if(i<=2) {
				result =  1;
			}else {
				result = memo[i-1] + memo[i-2];
			}
			memo[i] = result;
			
		}
		
		return memo[n];
		
	}
	
    //dynamic programming - sliding window
    
    public static int findMaxSum(int[] arr, int target) {
    	
    	if(arr == null || arr.length<1) {
    		return -1;
    	}
    	int currentSum = 0;
    	int max = Integer.MAX_VALUE;
    	
    	for(int i=0; i<arr.length; i++) {
    		currentSum = currentSum + arr[i];
    		
    		if(i>=(target-1)) {
    			max = Math.max(max, currentSum);
    			currentSum = currentSum - arr[i-(target-1)];
    		}
    	}
    	return currentSum;
    	
    }
    
    public static int fact(int n, int[] memo) {
		
		if(memo[n] == n) {
			return memo[n];
		}
		
		int result = 1;
		if(n == 1) {
			result = 1;
		}else {
			result = n*fact(n-1, memo);
		}
		
		memo[n] = result;
		return result;
	}

	public static void main(String[] args) {
		    
		int n = 6;
		System.out.println("fib :::: "+fibonacciNumberMemoization(n, new int[n+1]));
		
		
		
    }

}
