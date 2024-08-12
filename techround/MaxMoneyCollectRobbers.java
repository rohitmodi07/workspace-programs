package techround;

public class MaxMoneyCollectRobbers {
	
	public static int rob(int[] nums) {
	    if (nums.length == 0) return 0;
	    int prev1 = 0;
	    int prev2 = 0;
	    for (int num : nums) {
	        int tmp = prev1;
	        prev1 = Math.max(prev2 + num, prev1);
	        prev2 = tmp;
	    }
	    return prev1;
	}
	
	public static int maxMoneyRobbed1(int[] arr) {
		if(arr.length<1)
			return -1;
		
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i];
			for (int j = i+2; j < arr.length;) {
				sum = sum + arr[j];
				j = j+2;
			}
			max = sum>max ? sum : max;
		}
		
		return max;
	}
	//houses arranged in circle
	public static int maxMoneyRobbedInCircle(int[] arr) {
		if(arr.length<1)
			return -1;
		
		int max = 0;
        int count = 0;
        int leng = arr.length;
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i];
			count++;
			leng = count == 1 ? arr.length-1 : arr.length;
			
			for (int j = i+2; j < leng;) {
				sum = sum + arr[j];
				j = j+2;
			}
			max = sum>max ? sum : max;
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {2,7,9,3,1}; //{1,2,3,7,9}
		System.out.println(" The max money robbed ::::::: "+maxMoneyRobbed1(arr));
		
		int[] arr1 = {1,2,3,1}; //{1,2,3,7,9}
		System.out.println(" The max money robbed ::::::: "+rob(arr1));
		
		int[] arr2 = {2,3,2}; //{1,2,3,7,9}
		System.out.println(" The max money robbed ::::::: "+maxMoneyRobbedInCircle(arr2));
		
		int[] arr3 = {1,2,3,7,9}; //{1,2,3,7,9}
		System.out.println(" The max money robbed ::::::: "+maxMoneyRobbedInCircle(arr3));
	}

}
