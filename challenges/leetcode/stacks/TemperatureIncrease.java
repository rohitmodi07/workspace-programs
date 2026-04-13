package leetcode.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TemperatureIncrease {
	
	/*
     * Input: temperatures = [30,38,30,36,35,40,28]
              Output: [1,4,1,2,1,0,0]

     */
    
    public static List<Integer> dailyTemperatures(int[] temps) {
        if(temps == null || temps.length<1)
        	return new ArrayList<>();
        
        List<Integer> ilist = new ArrayList<>();
        
        for(int i=0; i<temps.length; i++) {
        	boolean doesIncr = false;
        	int count = 0;
        	
        	for(int j=i+1; j<temps.length; j++) {
        		count++;
        		if(temps[j]>temps[i]) {
        			doesIncr = true;
        			break;
        		}
        	}
        	if(doesIncr) {
        		ilist.add(count);
        	}else {
        		ilist.add(0);
        	}
        	count = 0;
        }
        return ilist;
    }
	
    public static int[] dailyTemperatures1(int[] temperatures) { //30,38,30,36,35,40,28
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]
        List<Integer> ilist = new ArrayList<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                System.out.println(" pair :: "+Arrays.toString(pair));
                res[pair[1]] = i - pair[1];
                System.out.println(" res :: "+Arrays.toString(res));
            }
            stack.push(new int[]{t, i});
        }
        //System.out.println(" list :::: "+ilist);
        return res;
    }
    

	public static void main(String[] args) {

		int[] temps = {30,38,30,36,35,40,28};
		System.out.println(" temps ::::: "+dailyTemperatures1(temps));
		
		int[] temps1 = {22,21,20};
		//System.out.println(" temps ::::: "+dailyTemperatures(temps1));
		
	}

}
