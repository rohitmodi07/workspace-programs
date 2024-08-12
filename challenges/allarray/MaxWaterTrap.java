package challenges.allarray;

public class MaxWaterTrap {
	
public static int trap(int[] height) {         //0,1,0,2,1,0,1,3,2,1,2,1
		
		if(height == null || height.length<1)
			return -1;
		
        int i=0;
        int j=height.length-1;
        
        int sum=0;
        int left_max=height[0];
        int right_max=height[j];
        while (i<j)
        {
            if(left_max <= right_max)
            {
                sum+=(left_max-height[i]);
                i++;
                left_max=Math.max(left_max,height[i]);
            }
            else 
            {
                sum+=(right_max-height[j]);
                j--;
                right_max=Math.max(right_max,height[j]);
            }
        }
        return sum;
        
    }
	

	public static void main(String[] args) {
		
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(arr));
		
	}

}
