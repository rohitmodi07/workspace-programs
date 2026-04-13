package leetcode.graphs;

import java.util.Arrays;

public class NetworkDelayToAllNodes {
	
public static int networkDelayTime(int[][] times, int n, int k) {
    	
    	if(times == null || times.length<1)
    		return -1;
    	
    	int[] dp = new int[n];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	
    	dp[k-1] = 0;
    	
    	for(int i=0; i<n-1; i++) {
    		
    		for(int[] t : times) {
    			int u = t[0]-1, v = t[1]-1, w = t[2];
    			
    			if(dp[u] != Integer.MAX_VALUE && dp[u]+w<dp[v]) {
    				dp[v] = dp[u] + w;
    			}
    			
    		}
    		
    	}
    	
    	int maxVal = Arrays.stream(dp).max().getAsInt();
    	
    	return maxVal == Integer.MAX_VALUE ? -1 : maxVal;
        
    }
	

	public static void main(String[] args){
		
		int[][] times = {{1,2,1}, {3,4,1}, {2,3,1}, {1,4,4}};
		System.out.println(networkDelayTime(times, 4, 1));
		
		int[][] times1 = {{1,2,1}, {2,3,1}};
		System.out.println(networkDelayTime(times1, 3, 2));
		
    }

}
