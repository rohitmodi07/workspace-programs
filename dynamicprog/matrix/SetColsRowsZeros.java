package dynamicprog.matrix;

import java.util.Arrays;

public class SetColsRowsZeros {
	
public static int[][] setZeroes(int[][] matrix){
		
		if(matrix == null || matrix.length<1)
			return null;
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int[] rowsArray = new int[rows];
		int[] colsArray = new int[cols];
		
		Arrays.fill(rowsArray, 1);
		Arrays.fill(colsArray, 1);
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(matrix[i][j] == 0) {
					rowsArray[i] = 0;
					colsArray[j] = 0;
				}
			}
		}
		
		System.out.println(" rowsArray :::: "+Arrays.toString(rowsArray));
		System.out.println(" colsArray :::: "+Arrays.toString(colsArray));
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(rowsArray[i] == 0 || colsArray[j] == 0) {
					matrix[i][j] = 0;
				}
			}
			
		}
        
        return matrix;
    }



	public static void main(String[] args) { 
		
		int[] arr = {7,1,2,6,4,3,8,5};
		
		int[][] matrix = {{5,4,3,9}, 
				          {2,0,7,6}, 
				          {1,3,4,0}, 
				          {9,8,3,4}
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
		int[][] m = setZeroes(matrix);
		
		for(int[] a : m) {
			System.out.println(Arrays.toString(a));
		}
    }

}
