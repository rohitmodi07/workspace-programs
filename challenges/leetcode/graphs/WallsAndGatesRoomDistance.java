package leetcode.graphs;

import java.util.Arrays;

public class WallsAndGatesRoomDistance {
	
	/* Output -
     *  [3, -1, 0, 1]
		[2, 2, 1, -1]
		[1, -1, 2, -1]
		[0, -1, 3, 4]
     */
	
	public static int[][] islandAndTreasureWalls(int[][] matrix){
		if(matrix == null || matrix.length<1)
			return null;
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(matrix[i][j] == 0) {
				  dfs(matrix, i, j, 0);
				}
			}
		}
		return matrix;
	}


	private static void dfs(int[][] matrix, int i, int j, int dist) {
		
		if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]<dist)
			return;
		
		matrix[i][j] = dist;
		
		dfs(matrix, i+1, j, dist+1);
		dfs(matrix, i-1, j, dist+1);
		dfs(matrix, i, j+1, dist+1);
		dfs(matrix, i, j-1, dist+1);
		
	}


	public static void main(String[] args) {
		
		/*
		 * INF - water
		 * 0 - wall
		 * 1 - gate
		 */
		
		int INF = Integer.MAX_VALUE;
        int[][] matrix = {
            {INF, -1,  0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0,   -1, INF, INF}
        };
		
        int[][] mat = islandAndTreasureWalls(matrix);
        
        for(int[] m : mat) {
        	System.out.println(Arrays.toString(m));
        }
		
		
	}

}
