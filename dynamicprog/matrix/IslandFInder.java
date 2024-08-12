package dynamicprog.matrix;

class IslandFInder {

    int rows;
    int cols;
    int island = 0;

    public int numIslands(char[][] grid) {

        rows=grid.length;
        cols=grid[0].length;

        for(int row = 0;row<rows;row++)
        {
            search(grid,row);
        }
        return island;

    }
    public void search(final char[][] grid,int row)
    {
        final char []finalrow = grid[row];

        for(int col = 0;col<cols;++col)
        {
            if(finalrow[col]=='1')
            {
                mark(grid,row,col);
                ++island;
            }
        }
    }

    public void mark(char[][] grid,int row,int col)
    {
        grid[row][col]='*';

        if(row>0 && grid[row-1][col]=='1')
            mark(grid,row-1,col);
        if(row+1<rows && grid[row+1][col]=='1')
            mark(grid,row+1,col);
        if(col>0 && grid[row][col-1]=='1')
            mark(grid,row,col-1);
        if(col+1<cols && grid[row][col+1]=='1')
            mark(grid,row,col+1);
    }
    
    //another solution
    
    public int numIslands1(char[][] grid) {
        int ans = 0;

        boolean [][] visited = new boolean [grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j])  continue;
                if(grid[i][j] == '1'){
                    ans++;
                    
                    destroyLand(grid, i, j, visited);
                }
            }
        }
        return ans;
    }

    void destroyLand(char[][] grid , int i, int j, boolean [][] visited){
        if(visited[i][j])   return ;
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length){
            grid[i][j] = '0';
            visited[i][j] = true;
            
            if(i>0 && i<grid.length && grid[i-1][j] == '1')  destroyLand(grid, i-1, j, visited);
            if(i>=0 && i<grid.length-1 && grid[i+1][j] == '1')  destroyLand(grid, i+1, j, visited);
            if(j>0 && j<grid[0].length && grid[i][j-1] == '1')  destroyLand(grid, i, j-1, visited);
            if(j>=0 && j<grid[0].length-1 && grid[i][j+1] == '1')  destroyLand(grid, i, j+1, visited);
            
        }
    }
    
    //one more solution
    
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return numIslands;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = '0'; // mark as visited
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
    
    public static void main(String[] args) {
    	
    	char[][] graph = {
    			            {'1','1','1','1','0'},
    			            {'1','1','0','1','0'},
    			            {'1','1','0','0','0'},
    			            {'0','0','0','0','0'}
                           };
    	
    	IslandFInder tp = new IslandFInder();
    	
    	System.out.println(" number of island ::: "+tp.numIslands2(graph));
    	
    	char[][] graph1 = {
    	                   {'1','1','0','0','0'},
    	                   {'1','1','0','0','0'},
    	                   {'0','0','1','0','0'},
    	                   {'0','0','0','1','1'}
                          };
    	System.out.println(" number of island ::: "+tp.numIslands2(graph1));
    	
    }
}
