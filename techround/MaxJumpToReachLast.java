package techround;

public class MaxJumpToReachLast {

		
public static boolean canJump(int[] nums) { //{2,3,1,1,4}
		
        int jump = nums[0];               // 2 
        int n = nums.length;                  // 5
        if (jump == 0 && n > 1) {
            return false;
        }
        int i = 1;
        while(i < n) {
            jump--;
            if (jump < nums[i]) {
                 jump = nums[i];
            }
            if (jump <= 0 && i != n-1) {
                return false;
            }
            i++;
        }
        return true;
    }
	
	public static void main(String[] args) {
		
		int[] arr = {2,3,1,1,4};
        System.out.println(" max jump to reach last element :::: "+canJump(arr));
        
        int[] arr1 = {3,2,1,0,4};
        System.out.println(" max jump to reach last element :::: "+canJump(arr1));
		
	}

}
