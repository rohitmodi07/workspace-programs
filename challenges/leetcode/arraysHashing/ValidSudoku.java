package leetcode.arraysHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	
public static boolean isValidSudoku(String[][] board) {
    	
    	if(board == null || board.length<1)
    		return false;
    	
    	int row = board.length;
    	int col = board[0].length;
    	
    	
    	for(int r=0; r<9; r++) {
    		
    		Set<String> cset = new HashSet<>();
    		
    		for(int i=0; i<9; i++) {
    			
    			if(board[r][i] == ".") {
    				continue;
    			}
    			if(!cset.add(board[r][i])) {
    				return false;
    			}
    		}
    	}
    	
    	for(int c=0; c<9; c++) {
    		Set<String> cset = new HashSet<>();
    		for(int i=0; i<9; i++) {
    			
    			if(board[i][c] == ".") {
    				continue;
    			}
    			if(!cset.add(board[i][c])) {
    				return false;
    			}
    			
    		}
    	}
    	
    	for(int square=0; square<9; square++) {
    		
    		Set<String> cset = new HashSet<>();
    		
    		for(int i=0; i<3; i++) {
    			
    			for(int j=0; j<3; j++) {
    				
    				int rw = (square/3)*3 + i;
    				int cl = (square%3)*3 + j;
    				
    				if(board[rw][cl] == ".") {
    					continue;
    				}
    				if(!cset.add(board[rw][cl])) {
    					return false;
    				}
    				
    			}
    			
    		}
    		
    		
    	}
    	
    	return true;
        
    }
	

	public static void main(String[] args) throws InterruptedException{       
    
       String[][] board = {
    		   {"1","2",".",".","3",".",".",".","."},
    		   {"4",".",".","5",".",".",".",".","."},
    		   {".","9","8",".",".",".",".",".","3"},
    		   {"5",".",".",".","6",".",".",".","4"},
    		   {".",".",".","8",".","3",".",".","5"},
    		   {"7",".",".",".","2",".",".",".","6"},
    		   {".",".",".",".",".",".","2",".","."},
    		   {".",".",".","4","1","9",".",".","8"},
    		   {".",".",".",".","8",".",".","7","9"}};
       
       System.out.println(" valid sudoku :::: "+isValidSudoku(board));
       
       String[][] board1 = {
    		   {"1","2",".",".","3",".",".",".","."},
    		   {"4",".",".","5",".",".",".",".","."},
    		   {".","9","1",".",".",".",".",".","3"},
    		   {"5",".",".",".","6",".",".",".","4"},
    		   {".",".",".","8",".","3",".",".","5"},
    		   {"7",".",".",".","2",".",".",".","6"},
    		   {".",".",".",".",".",".","2",".","."},
    		   {".",".",".","4","1","9",".",".","8"},
    		   {".",".",".",".","8",".",".","7","9"}};
       
       System.out.println(" valid sudoku :::: "+isValidSudoku(board1));
		
	   
    }

}
