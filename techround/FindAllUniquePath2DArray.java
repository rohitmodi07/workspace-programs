package techround;

import java.util.Arrays;

public class FindAllUniquePath2DArray {
	
	public static int uniquePaths(int m, int n) {

		  int[][] dp=new int[m][n];
		    
		  Arrays.stream(dp).forEach(d -> Arrays.fill(d, 1)); //filling 2D dp array with 1
		    
		  for(int i=1;i<m;i++){
		      for(int j=1;j<n;j++){
		          dp[i][j]=dp[i-1][j] + dp[i][j-1]; //sum of diagonal elements
		  }
		}
		    return dp[m-1][n-1]; //return value of final position
	}
	
	public static int uniquePath(int m, int n) {
	        int ans = 1;
	        for(int i = m+n-2, j = 1; i >= Math.max(m, n); i--, j++) {
	            ans = (ans * i) / j;
	        }
	        return ans;
	    }
	
	public static void main(String[] args) {
		
		System.out.println(" unique path :::::: "+uniquePath(3, 7));
		
	}

}
