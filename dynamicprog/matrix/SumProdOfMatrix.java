package dynamicprog.matrix;

import java.util.Arrays;

public class SumProdOfMatrix {
	
	public static int[][] addTwoMatrix(int[][] m1, int[][] m2){
		if(m1 == null || m2 == null || m1.length<1 || m2.length<1 || m1.length != m2.length)
			return null;
		
		int row = m1.length;
		int col = m1.length;
		
		int[][] msum = new int[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				msum[i][j] = m1[i][j] + m2[i][j];
			}
		}
		
		return msum;
	}
	
	public static int[][] prodTwoMatrix(int[][] m1, int[][] m2){
		if(m1 == null || m2 == null || m1.length<1 || m2.length<1 || m1.length != m2.length)
			return null;
		
		int row = m1.length;
		int col = m1.length;
		
		int[][] msum = new int[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				msum[i][j] = m1[i][j] * m2[i][j];
			}
		}
		
		return msum;
	}
	
	public static int[][] addTwoDiffRowLenMatrix(int[][] m1, int[][] m2){
		if(m1 == null || m2 == null || m1.length<1 || m2.length<1)
			return null;
		
		
		int row = m1.length>=m2.length ? m1.length : m2.length;
		int col = m1[0].length>=m2[0].length ? m1[0].length : m2[0].length;
		
		int m1len = m1.length-1;
		int m2len = m2.length-1;
		
		int[][] msum = new int[row][col];
		
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(i<=m1len && i<=m2len) {
					msum[i][j] = m1[i][j] + m2[i][j];
				}else if(i>m1len) {
					msum[i][j] = m2[i][j];
				}else if(i>m2len) {
					msum[i][j] = m1[i][j];
				}
				
			}
		}
		
		return msum;
	}
	
	

	public static void main(String[] args) {
		
		int[][] m1 = {{1,1,1},
				      {2,2,2},
				      {3,3,3},
				      {9,9,9}
				      };
		
		int[][] m2 = {{1,1,1},
				      {2,2,2},
				      {3,3,3} 
				      };
		int[][] modmatrix = addTwoDiffRowLenMatrix(m1, m2);
		for(int[] m : modmatrix) {
			System.out.println(Arrays.toString(m));
		}
	}

}
