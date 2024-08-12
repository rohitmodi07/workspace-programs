package dynamicprog.matrix;

import java.util.Arrays;

public class MakeAllColRowZerosIfFIndZero {
	
	public static int[][] processZerosInRowAndCol(int[][] matrix){
		if(matrix == null || matrix.length<1)
			return null;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		for(int i=0; i<rows; i++) {
			
			for(int j=0; j<cols; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][0] = 0;
					
					int curRow = i;
					int curCol = j;
					
					for(int c=0; c<curRow; c++) {
						matrix[c][curCol] = 0;
					}
					for(int c1=curRow; c1<rows; c1++) {
						matrix[c1][curCol] = 0;
					}
					
					for(int r=0; r<curCol; r++) {
						matrix[curRow][r] = 0;
					}
					
					for(int r1=curCol; r1<cols; r1++) {
						matrix[curRow][r1] = 0;
					}
					
				}
			}
			
		}
		
		return matrix;
	}
	
	



	public static void main(String[] args) { 
		
		int[] arr = {7,1,2,6,4,3,8,5};
		
		int[][] matrix = {{1,1,1,1}, 
				          {1,0,1,1}, 
				          {1,1,1,1}
				         };
		
		//1,1 -> 0 then 0,1  1,1  2,1  3,1 and 1,0  1,1  1,2  1,3
		
		/*
		 * {{5,0,3,9}, 
            {0,0,0,0}, 
            {1,0,4,9}, 
            {9,0,3,4}
           };
		 */
		
		System.out.println(" pairs which compute the target :::: ");
		
		int[][] m = processZerosInRowAndCol(matrix);
		
		for(int[] a : m) {
			System.out.println(Arrays.toString(a));
		}
    }

}
