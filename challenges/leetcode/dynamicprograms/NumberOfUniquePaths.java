package leetcode.dynamicprograms;

public class NumberOfUniquePaths {
	
	public static int uniquePath(int row, int col) {
		if(row == 0 || col == 0)
			return -1;
		int[][] dp = new int[row][col];
		
		for(int i=0; i<row; i++) {
			dp[i][0] = 1;
		}
		
		for(int j=0; j<col; j++) {
			dp[0][j] = 1;
		}
		
		for(int i=1; i<row; i++) {
			for(int j=1; j<col; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[row-1][col-1];
	}
	


	public static void main(String[] args) {
		
		System.out.println(" number of paths :::: "+uniquePath(3, 7)); // 28
		System.out.println(" number of paths :::: "+uniquePath(3, 2)); // 3
		
	}

}
