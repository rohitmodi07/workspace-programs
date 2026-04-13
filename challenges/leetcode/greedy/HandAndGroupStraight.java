package leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandAndGroupStraight {
	
	/*
	 * Input: hand = [1,2,4,2,3,5,3,4], groupSize = 4

       Output: true
       
       Input: hand = [1,2,3,3,4,5,6,7], groupSize = 4

       Output: false
	 */
	
	public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);
        for (int num : hand) {
            if (count.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (count.getOrDefault(i, 0) == 0) return false;
                    count.put(i, count.get(i) - 1);
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		
		
		
		
	}

}
