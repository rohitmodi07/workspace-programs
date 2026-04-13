package leetcode.graphs;

public class MaxAreaAmongMultipleIsland {
	
	public static int maxAreaIsland(int[][] matrix) {
		if(matrix == null || matrix.length<1)
			return -1;
		int row = matrix.length;
		int col = matrix[0].length;
		
		int area = 0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(matrix[i][j] == 1) {
					area = Math.max(area, dfs(matrix, i, j));
				}
			}
		}
		return area;
	}
	
	
	private static int dfs(int[][] matrix, int i, int j) {
		
		if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j] == 0)
			return 0;
		
		matrix[i][j] = 0;
		int res = 1;
		res += dfs(matrix, i+1, j);
		res += dfs(matrix, i-1, j);
		res += dfs(matrix, i, j-1);
		res += dfs(matrix, i, j+1);
		
		return res;
	}


	public static void main(String[] args) {
		
		int[][] matrix = {{0,1,1,0,1},
				          {1,0,1,0,1},
				          {1,1,1,0,1},
				          {1,1,0,0,1}
				          };
        System.out.println(" max area :::: "+maxAreaIsland(matrix));
		
	}

}
