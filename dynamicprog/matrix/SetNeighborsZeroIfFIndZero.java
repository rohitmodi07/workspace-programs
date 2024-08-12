package dynamicprog.matrix;

import java.util.Arrays;

public class SetNeighborsZeroIfFIndZero {
	
	    public static int[][] setZeroes(int[][] matrix) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        boolean[][] isOriginalZero = new boolean[rows][cols];

	        for(int i=0;i<rows;i++){
	            for(int j=0;j<cols;j++){
	                if(matrix[i][j] == 0)
	                    isOriginalZero[i][j] = true;
	                else
	                    continue;
	            }
	        }

	        for(int i=0;i<rows;i++){
	            for(int j=0;j<cols;j++){
	                int currRow = i;  //2
	                int currCol = j;  //2
	                if(matrix[currRow][currCol]==0 && isOriginalZero[currRow][currCol]){ //2,2
	                    for(int c=0;c<currCol;c++){
	                        matrix[currRow][c] = 0;
	                    }
	                    for(int c=currCol;c<cols;c++){
	                        matrix[currRow][c] = 0;
	                    }

	                    for(int r=0;r<currRow;r++){
	                        matrix[r][currCol] = 0;
	                    }
	                    for(int r=currRow;r<rows;r++){
	                        matrix[r][currCol] = 0;
	                    }
	                }

	                else
	                    continue;
	            }
	        }
	        
	        return matrix;
	    }
	    
	    public static void main(String[] args) {
			
	    	int[][] matrix = {{1,1,1,1}, {1,0,1,1}, {1,1,1,1}};
	    	
	    	int[][] modmatrix = setZeroes(matrix);
	    	
	    	for(int[] arr : modmatrix) {
	    		System.out.println(" modified matrix ::::: "+Arrays.toString(arr));
	    	}
	    	
	    	
	    	
		}

}
