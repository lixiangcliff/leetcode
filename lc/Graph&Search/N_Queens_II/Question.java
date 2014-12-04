package N_Queens_II;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalNQueens(8));

	}
	//http://blog.csdn.net/linhuanmars/article/details/20668017
    public static int totalNQueens(int n) {
    	int [] result = {0};
    	int[] columnForRow = new int[n];
    	helper(n, 0, columnForRow, result);
    	return result[0];
    }
    
    private static void helper(int n, int row, int[] columnForRow, int[] result) {
    	if(row == n){
    		result[0]++;
    		return;
    	}
    	// to choose a valid column for current row
    	for(int i=0;i<n;i++){
    		columnForRow[row] = i;  
    		if(isValid(row, columnForRow)){
    			helper(n, row+1, columnForRow, result); // if current row is valid, continue to next row;
    		}
    	}
    }
    
    //to check if new-add row: "row"'s column: columnForRow[row] can still make the board valid
    private static boolean isValid(int row, int[] columnForRow){
    	for(int i=0; i<row; i++){ 
    		if(columnForRow[row] == columnForRow[i] || Math.abs(row-i) == Math.abs(columnForRow[row]-columnForRow[i])){
    			return false;
    		}
    	}
    	return true;
    }

}
