package dynamicprog.matrix;

public class RotateAMatrix {
	
	
	
	/*
	 *  0,0 - 0,1 - 0,2 -> 0,2 - 1,2 - 2,2
		1,0 - 1,1 - 1,2 -> 0,1 - 1,1 - 2,1
		2,0 - 2,1 - 2,2 -> 0,0 - 1,0 - 2,0
		
		1 2 3       7 4 1
		4 5 6       8 5 2
		7 8 9       9 6 3
	 */
	
	public static int[][] rotateNinetyDegree(int[][] matrix){
		
		if(matrix == null || matrix.length<1)
			return null;
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		System.out.println(" rows :::: "+rows);
		System.out.println(" rows :::: "+cols);
		
		int[][] copy = new int[rows][cols];
		
		int count = matrix.length-1;
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				copy[j][count] = matrix[i][j];
			}
			count--;
		}
		
		return copy;
		
	}
	
	    public void rotate(int[][] matrix) {
	        int l = matrix.length;
	        int i=0;
	        int j= l-1;
	        while(i<j) {
	            for(int count=0; i+count<j; count++){
	                rotate(matrix, i, j, count);
	            }
	            i++; j--;
	        }
	    }

	    public void rotate(int[][] matrix, int i, int j, int count ) {
	        int temp = matrix[i][i+count];
	        matrix[i][i+count] = matrix[j-count][i];
	        matrix[j-count][i] = matrix[j][j-count];
	        matrix[j][j-count] = matrix[i+count][j];
	        matrix[i+count][j] = temp;
	    }
	    
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
	}

}
