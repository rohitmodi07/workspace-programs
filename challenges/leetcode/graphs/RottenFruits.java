package leetcode.graphs;

import java.util.Arrays;

public class RottenFruits {
	
	// rotten oranges
		/*
		 * Input: grid = [[1,1,0],[0,1,1],[0,1,2]]

	       Output: 4

		 */
		
		public static int rottenOranges(int[][] matrix) {
			if(matrix == null || matrix.length<1)
				return -1;
			
			int row = matrix.length;
			int col = matrix[0].length;
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(matrix[i][j] == 2) {
						depth1stSearch(matrix, i, j, 2); // take grid value 2 as base time
					}
				}
			}
			
			for(int[] m : matrix) {
				System.out.println(Arrays.toString(m));
			}
			
			int max = 2; // since base time is 2 hence assign max time to 2
			
			for(int[] m : matrix) {
				for(int val : m) {
					if(val == 1)       // if 1 still exist that means all fruits not rotten hence return -1
						return -1;
					max = Math.max(val, max);
				}
			}
			
			return max-2;
		}


		private static void depth1stSearch(int[][] matrix, int i, int j, int time) {
			
			if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length)
				return;
			
			if(matrix[i][j] != 1 && matrix[i][j]<time)
				return;
			
			matrix[i][j] = time;
			
			depth1stSearch(matrix, i+1, j, time+1);
			depth1stSearch(matrix, i-1, j, time+1);
			depth1stSearch(matrix, i, j+1, time+1);
			depth1stSearch(matrix, i, j-1, time+1);
			
		}


		public static void main(String[] args) {

	        int[][] matrix = {
	            {1,1,0},
	            {0,1,1},
	            {0,1,2}
	        };
			
	        System.out.println(" minutes took :::: "+rottenOranges(matrix));
			
		}

}
