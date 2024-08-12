package dynamicprog.matrix;

import java.util.Arrays;


public class RatInMaze {
	

	private int[][] path;
	private int[][] matrix;
	private int row;
	private int col;
	
	public RatInMaze(int[][] matrix) {
		this.matrix = matrix;
		this.row = matrix.length;
		this.col = matrix[0].length;
		
		this.path = new int[row][col];
	}
	 
    public boolean findPathForRat(){
    	if(matrix == null || matrix.length<1)
    		return false;
    	
    	boolean doesPathExist = solveRatMaze(0,0);
    	showPath();
    	
    	return doesPathExist;
    }


	private boolean solveRatMaze(int i, int j) {
		
		if(i == row-1 && j == col-1) {
			path[i][j] = 1;
			return true;
		}
		
		if(i>=0 && i<row && j>=0 && j<col && matrix[i][j] == 1) {
			
			path[i][j] = 1;
			
			if(solveRatMaze(i+1, j)) {
				return true;
			}
			if(solveRatMaze(i, j+1)) {
				return true;
			}
			
			path[i][j] = 0;
			return false;
			
		}
			
		
		return false;
	}
	
	// to display path
   public void showPath() {
      System.out.println("The solution maze:");
      for (int i = 0; i < row; i++) {
         System.out.println(Arrays.toString(path[i]));
      }
   }


	public static void main(String[] args) throws InterruptedException {
		
		
		int[][] maze = {
					      {1, 0, 0, 0, 0},
					      {1, 1, 0, 1, 0},
					      {0, 1, 1, 1, 0},
					      {0, 0, 0, 1, 0},
					      {1, 1, 1, 1, 0}
					   };
		
		RatInMaze tp = new RatInMaze(maze);
		System.out.println(tp.findPathForRat());
		
	}

}
