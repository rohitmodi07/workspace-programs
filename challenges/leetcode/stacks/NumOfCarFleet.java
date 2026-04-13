package leetcode.stacks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumOfCarFleet {
	
	/*
	 * Input: target = 10, position = [1,4], speed = [3,2]

       Output: 1
       
       Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]

       Output: 3


	 */
	
    public static int carFleet(int target, int[] position, int[] speed) {
        if(position == null || speed == null || position.length<1 || speed.length<1)
        	return -1;
        
        Set<Integer> ilist = new HashSet<>();
        
        for(int i=0; i<position.length; i++) {   // 10  position1 = {4,1,0,7}; speed1 = {2,2,1,1};
        	int remDist = target-position[i];
        	
    		int sd = remDist/speed[i];
    		
    		ilist.add(sd);
        	
        }
        return ilist.size();
    }
    
    public static int carFleet1(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        
        
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        
        for(int[] p : pair) {
        	System.out.println(Arrays.toString(p));
        }
        
        
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            
            System.out.println(" stack - "+stack);
  
            
            if (stack.size() >= 2 &&
                stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }
        return stack.size();
    }


	public static void main(String[] args) {

		int[] position = {1,4};
		int[] speed = {3,2};
		
		System.out.println(" number of fleet ::: "+carFleet(10, position, speed));
		
		int[] position1 = {4,1,0,7};
		int[] speed1 = {2,2,1,1};
		
		System.out.println(" number of fleet ::: "+carFleet(10, position1, speed1));
		
	}

}
