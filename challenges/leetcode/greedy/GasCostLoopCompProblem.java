package leetcode.greedy;

import java.util.Arrays;

public class GasCostLoopCompProblem {
	
	/*
	 * Input: gas = [1,2,3,4], cost = [2,2,4,1]

       Output: 3
	 */
	
	
	public static int canCompleteCircuit1(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }

        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {   // [1,2,3,4], cost = [2,2,4,1]
            total += (gas[i] - cost[i]);

            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }

        return start;
    }
	
	public static void main(String[] args) {
		
		int[] gas = {1,2,3,4};
		int[] cost = {2,2,4,1};
		
		System.out.println(canCompleteCircuit1(gas, cost));
		
		
	}

}
