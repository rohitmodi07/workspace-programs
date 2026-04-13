package leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticOceanWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        
        for (int c = 0; c< cols; c++){
            dfs(0, c, rows, cols, pac, heights[0][c], heights);
            dfs(rows-1, c,rows, cols, atl, heights[rows-1][c], heights);
        }
        for (int r = 0; r<rows; r++){
            dfs(r, 0,rows, cols, pac, heights[r][0], heights);
            dfs(r, cols-1,rows, cols, atl, heights[r][cols-1], heights);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++){
                if (pac[i][j] && atl[i][j])
                    result.add(Arrays.asList(i,j));
            }
        return result;
    }
    private static void dfs(int r, int c, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights){
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || prevHeight > heights[r][c])
            return;
        visited[r][c]= true;
        dfs(r+1, c, rows, cols, visited, heights[r][c], heights);
        dfs(r-1, c, rows, cols, visited, heights[r][c], heights);
        dfs(r, c+1, rows, cols, visited, heights[r][c], heights);
        dfs(r, c-1, rows, cols, visited, heights[r][c], heights);
        
    }
    
    public static void main(String[] args) {
		int[][] height = {{1,2,2,3,5},
				          {3,2,3,4,4},
				          {2,4,5,3,1},
				          {6,7,1,4,5},
				          {5,1,1,2,4}
				
		};
		
		System.out.println(pacificAtlantic(height));
		
	}
}
