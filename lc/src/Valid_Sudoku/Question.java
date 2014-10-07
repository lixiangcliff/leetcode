package Valid_Sudoku;

import java.util.Arrays;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		boolean[] visited = new boolean[10]; 
		Arrays.fill(visited, false);
		char[] line = {'1','2', '3', '5', '.', '.' , '6', '7','8'};*/
		char[][] board = {
				{'1','.', '.', '4', '.', '.' , '7', '.','9'},
				{'9','.', '.', '.', '.', '.' , '.', '.','.'},
				{'.','.', '2', '.', '.', '.' , '.', '.','.'},
				{'.','.', '.', '.', '.', '.' , '.', '.','.'},
				{'.','7', '3', '5', '.', '.' , '.', '.','.'},
				{'.','.', '.', '.', '.', '.' , '6', '.','.'},
				{'.','2', '.', '.', '.', '.' , '.', '.','.'},
				{'.','.', '4', '.', '.', '.' , '.', '.','.'},
				{'8','.', '.', '.', '.', '.' , '.', '7','.'},
				
		};
		//System.out.println(isValidArray(visited, board[0]));
		System.out.println(isValidSudoku(board));

	}
	
    public static boolean isValidSudoku(char[][] board) {
    	if(board == null || board.length != 9 || board[0].length != 9){
    		return false;
    	}
    	
    	boolean[] visited = new boolean[board.length]; 
    	//rows
    	for(int i=0; i<board.length; i++){
    		Arrays.fill(visited, false);
    		if (!isValidArray(visited, board[i])){
    			return false;
    		}
    	}
    	
    	//columns
    	for(int i=0; i<board[0].length; i++){
    		char[] line = new char[board.length];
    		for (int j=0;j<board.length;j++){
    			line[j] = board[j][i];
    		}
    		Arrays.fill(visited, false);
    		if (!isValidArray(visited, line)){
    			return false;
    		}
    	}
    	
    	//for each 3*3 square
    	for (int i=0;i < board.length;i=i+3){
    		for (int j=0;j < board[0].length;j=j+3){
    			char[] line = new char[board.length];
    			int index = 0;
    			for (int k=i;k<i+3;k++){
    				for (int m=j;m<j+3;m++){
    					line[index++] = board[k][m]; 
    				}
    			}
    			
    			Arrays.fill(visited, false);
    			if (!isValidArray(visited, line)){
        			return false;
        		}
    		}
    	}
    	
    	return true;
    }
    
    public static boolean isValidArray(boolean[] visited , char[] line){
    	for(int i=0;i<line.length;i++){
    		if (line[i] == '.'){
    			continue;
    		}
    		int dig = Character.getNumericValue(line[i]);
    		if(visited[dig-1]){
    			return false;
    		}
    		visited[dig-1] = true;
    	}   	
    	return true;
    }

}
