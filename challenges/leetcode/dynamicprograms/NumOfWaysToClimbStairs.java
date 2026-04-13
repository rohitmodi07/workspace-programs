package leetcode.dynamicprograms;

public class NumOfWaysToClimbStairs {
	
	// number of ways to climb stairs
	
		public static int waysToClimbStairs(int n) {
			if(n<1)
				return -1;
			if(n<=3)
				return n;
			return waysToClimbStairs(n-1) + waysToClimbStairs(n-2);
		}


		public static void main(String[] args) {
			
	        System.out.println(" ways to climb stairs ::: "+waysToClimbStairs(2));
	        System.out.println(" ways to climb stairs ::: "+waysToClimbStairs(3));
	        System.out.println(" ways to climb stairs ::: "+waysToClimbStairs(4));
	        System.out.println(" ways to climb stairs ::: "+waysToClimbStairs(5));
			
			
		}

}
