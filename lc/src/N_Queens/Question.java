package N_Queens;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/zhong317/article/details/4586131
	//http://blog.csdn.net/linhuanmars/article/details/20667175
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> result = new ArrayList<String[]>();
    	int[] columnForRow = new int[n];
    	helper(n, 0, columnForRow, result);
    	return result;
    }
    
    private void helper(int n, int row, int[] columnForRow, ArrayList<String[]> result) {
    	if(row == n){
    		String[] item = new String[n];
    		for (int i=0; i<n; i++){
    			StringBuilder sb = new StringBuilder();
	    		for(int j =0;j<n;j++){
	    			//StringBuilder sb = new StringBuilder(); -- wrong place!
	    			//if (i == columnForRow[j]){ // Wrong! columnForRow[i] is current row!
	    			if (j == columnForRow[i]){	//for current row, its column "happens" at which "index" of loop
	    				sb.append('Q');
	    			}else{
	    				sb.append('.');
	    			}
	    			item[i] = sb.toString();
	    		}
    		}
    		result.add(item);
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
    private boolean isValid(int row, int[] columnForRow){
    	//int n = columnForRow.length;
    	//for(int i=0; i<n; i++){ // wrong! only need to check rows that are before current row;
    	for(int i=0; i<row; i++){ 
    		if(columnForRow[row] == columnForRow[i] || Math.abs(row-i) == Math.abs(columnForRow[row]-columnForRow[i])){
    			return false;
    		}
    	}
    	return true;
    }

}
