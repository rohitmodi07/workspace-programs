package challenges.allarray;

public class FIndMaxProdMaxSumSubArray {
	
	//search in rotated array
	
		public static boolean searchInRA(int[] arr, int key) { //4,5,6,7,1,2,3
			if(arr == null || arr.length<1)
				return false;
			int val = arr[0];
			if(key == val) {
				return true;
			}else if(key>val) {
				for(int i=0; i<arr.length; i++) {
					if(key == arr[i]) {
						return true;
					}
				}
				return false;
			}else {
				for(int i=arr.length-1; i>0; i--) {
					if(key == arr[i]) {
						return true;
					}
				}
				return false;
			}
			
		}
		
		//find minimum in rotated array
		
		public static int findMinNum(int[] arr) {
			if(arr == null || arr.length<1)
				return -1;
			int min = arr[arr.length-1];
			for(int i=arr.length-1; i>=0; i--) {
				min = min>arr[i] ? arr[i] : min;
			}
			return min;
		}
		
		//find largest sum
		
		public static int findLargestSum(int[] arr){
			if(arr == null || arr.length<1)
				return -1;
			int max = 0;
			int i = 0;
			
			while(i<arr.length) {
				int j = i+1;
				int sum = arr[i];
				while(j<arr.length) {
					sum = sum + arr[j];
					max = sum>max ? sum : max;
					j++;
				}
				i++;
			}
			return max;
		}
		
		//find largest prod
		
		public static int findLargestProd(int[] arr){ // 2,3,-2,4
			if(arr == null || arr.length<1)
				return -1;
			int max = 0;
			int i = 0;
			
			while(i<arr.length) {
				int j = i+1;
				int sum = arr[i];
				while(j<arr.length) {
					sum = sum * arr[j];
					max = sum>max ? sum : max;
					j++;
				}
				i++;
			}
			return max;
		}
		
		public static int maxSubArray(int[] nums) {
	        int maxSum = Integer.MIN_VALUE;
	        int currentSum = 0;
	        
	        for (int i = 0; i < nums.length; i++) {
	            currentSum += nums[i];
	            
	            if (currentSum > maxSum) {
	                maxSum = currentSum;
	            }
	            
	            if (currentSum < 0) {
	                currentSum = 0;
	            }
	        }
	        
	        return maxSum;
	    }
		
		public static int maxSubArrayProd(int[] nums) {
	        int maxSum = Integer.MIN_VALUE;
	        int currentSum = 0;
	        
	        for (int i = 0; i < nums.length; i++) {
	            currentSum *= nums[i];
	            
	            if (currentSum > maxSum) {
	                maxSum = currentSum;
	            }
	            
	            if (currentSum < 0) {
	                currentSum = 0;
	            }
	        }
	        
	        return maxSum;
	    }
		
	    public int maxProduct(int[] nums) {
	        
	        int max = nums[0], min = nums[0], ans = nums[0];
	        int n = nums.length;
	        
	        for (int i = 1; i < n; i++) {
	        
				// Swapping min and max
	            if (nums[i] < 0){
	                int temp = max;
	                max = min;
	                min = temp;
	            }
	                


	            max = Math.max(nums[i], max * nums[i]);
	            min = Math.min(nums[i], min * nums[i]);


	            ans = Math.max(ans, max);
	        }
	        
	        return ans;

	    }
		
		

		public static void main(String[] args) {
			
			int[] arr = {4,5,6,7,8,1,2,3};
			
			//System.out.println(" does element exist ::::: "+searchInRA(arr, 2));
			//System.out.println(" does element exist ::::: "+searchInRA(arr, 6));
			//System.out.println(" does element exist ::::: "+searchInRA(arr, 10));
			
			//System.out.println(" does element exist ::::: "+findMinNum(arr));
			
			int[] ar = {-2,1,-3,4,-1,2,1,-5,4};
			//System.out.println(" max sum ::::: "+findLargestSum(ar));
			
			int[] num = {5,4,-1,-10,7,8};
			//System.out.println(" max sum ::::: "+maxSubArray(num));
			
			int[] num1 = {2,3,-2,4};
			//System.out.println(" max prod ::::: "+maxSubArrayProd(num1));
			
	    }

}
