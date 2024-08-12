package dynamicprog.matrix;

public class FloodFillAlgorithmDemo {
	
	public static void floodFillAlgo(int[][] arr) {
		if(arr == null)
			return;
		
		flood_Fill(arr, 3, 2, 6);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("  ");
		}
	}
	
	public static void flood_Fill(int[][] arr, int x, int y, int newNum) {
		int oldNum = arr[x][y];
		floodFill_Numbers(arr, x, y, oldNum, newNum);
	}

	public static void floodFill_Numbers(int[][] arr, int x, int y, int oldNum, int newNum) {
		
		if(x<0 || y<0 || x>=10 || y>=10) {
			return;
		}
		if(arr[x][y] != oldNum) {
			return;
		}
		
		arr[x][y] = newNum;
		floodFill_Numbers(arr, x+1, y, oldNum, newNum);
		floodFill_Numbers(arr, x-1, y, oldNum, newNum);
		floodFill_Numbers(arr, x, y+1, oldNum, newNum);
		floodFill_Numbers(arr, x, y-1, oldNum, newNum);
		
	}

	public static void main(String[] args) {
    
		int [][] darr = new int[][] {
			{0,2,3,4,7,8,4,3,2,1}, 
			{0,2,3,4,5,7,4,3,2,1},
			{0,2,3,5,5,5,4,3,2,1},
			{0,2,3,4,5,5,4,3,2,1},
			{0,2,3,4,5,5,4,3,2,1},
		    {0,2,3,5,5,5,4,3,2,1},
		    {0,2,3,4,5,5,5,3,2,1},
		    {0,2,3,4,5,5,4,3,2,1},
		    {0,2,3,4,5,3,4,3,2,1},
		    {0,2,3,4,3,7,4,3,5,1}};
		    
		    floodFillAlgo(darr);

	}

}
