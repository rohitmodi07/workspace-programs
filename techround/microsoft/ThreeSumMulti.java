package techround.microsoft;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumMulti {
	
	public static int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            res = (res + map.getOrDefault(target - A[i], 0)) % mod;
            
            for (int j = 0; j < i; j++) {
                int temp = A[i] + A[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }


	public static void main(String[] args) {
		
		int[] arr = {1,1,2,2,3,4};
		
		System.out.println(threeSumMulti(arr, 6));
		
	}

}
