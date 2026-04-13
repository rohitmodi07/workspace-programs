package challenges.allarray;

import java.util.Arrays;

public class FIndSumProdAllExceptSelf {
	
	public static int[] prodExcptSelf(int[] arr) {
		if(arr == null || arr.length<1)
			return null;
		int n = arr.length;
		int[] ans = new int[n];
		ans[0] = 1;
		
		for(int i=1; i<n; i++) {
			ans[i] = ans[i-1]*arr[i-1];
		}
		
		int prod = 1;
		for(int i=n-2; i>=0; i--) {
			prod = prod*arr[i+1];
			ans[i] = ans[i]*prod;
		}
		return ans;
	}
	
	public static int[] sumExcptSelf(int[] arr) {
		if(arr == null || arr.length<1)
			return null;
		int n = arr.length;
		int[] ans = new int[n];
		ans[0] = 0;
		
		for(int i=1; i<n; i++) {
			ans[i] = ans[i-1] + arr[i-1];
		}
		
		int sum = 0;
		for(int i=n-2; i>=0; i--) {
			sum = sum + arr[i+1];
			ans[i] = ans[i] + sum;
		}
		return ans;
	}

	

	public static void main(String[] args) throws Exception {

		int[] arr = {1,2,3,4};
	
		System.out.println(" prod except self ::: "+Arrays.toString(sumExcptSelf(arr)));
		
	}

}
