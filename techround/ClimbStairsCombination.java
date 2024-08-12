package techround;

public class ClimbStairsCombination {
	
	//Solution 1
	
	public static int getAllStepCombination(int n) {
		if(n<1)
			return -1;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		int first = 1;
		int second = 2;
		int temp = 0;
		
		for (int i = 3; i <= n; i++) {
			temp = second;                   // 2, 3
			second = second + first;         // 3, 5
			first = temp;                    // 2, 3
		}
		return second;
	}
	
	//Solution 2
	
	public static int climbStairs(int n) { //used fibonacci to get all the combination of steps
	     if(n <= 1) {
			 return 1;
	     }
	     
	     int[] arr = new int[n];
	     arr[0] = arr[1] = 1;
	     
	     for(int i = 2; i < n; i++) {
			 arr[i] = arr[i-1] + arr[i-2];
	     }
		 return arr[n-1] + arr[n-2];
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" combination of steps  ::::: "+getAllStepCombination(4));
	}

}
