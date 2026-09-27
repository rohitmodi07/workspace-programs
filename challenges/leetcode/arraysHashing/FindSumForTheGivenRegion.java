package leetcode.arraysHashing;


public class FindSumForTheGivenRegion {
	
	/*
	 * Input: ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
       [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], 
       [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]

       Output: [null, 8, 11, 12]
	 * 
	 */
	
	private int[][] matrix;
	
    public FindSumForTheGivenRegion(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
    	if(row1<0 || row1>=matrix.length || row2<0 || row2>=matrix.length || col1<0 || col1>=matrix[0].length ||
    			col2<0 || col2>=matrix[0].length || row2<row1 || col2<col1) {
    		return -1;
    	}
    	
    	int sum = 0;
    	
    	for(int i=row1; i<=row2; i++) {
    		
    		for(int j=col1; j<=col2; j++) {
    			
    			sum = sum + matrix[i][j];
    			
    		}
    		
    	}
    	
    	return sum;
    		
    	
    }
   


	public static void main(String[] args) {
		
		int[][] matrix = {
				
				{3, 0, 1, 4, 2}, 
				{5, 6, 3, 2, 1}, 
				{1, 2, 0, 1, 5}, 
				{4, 1, 0, 1, 7}, 
				{1, 0, 3, 0, 5}
		};
		
		FindSumForTheGivenRegion tp = new FindSumForTheGivenRegion(matrix);
		
		System.out.println(tp.sumRegion(2, 1, 4, 3));
		System.out.println(tp.sumRegion(1, 1, 2, 2));
		System.out.println(tp.sumRegion(1, 2, 2, 4));
	}

}
