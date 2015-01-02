package Set_Matrix_Zeroes;

import java.util.HashSet;



public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//save space, but still not "in place"
/*    public void setZeroes(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length ==0){
    		return;
    	}
    	HashSet<Integer> row = new HashSet<Integer>();
    	HashSet<Integer> col = new HashSet<Integer>();
    	for (int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
    			if(matrix[i][j] == 0){
    				row.add(i);
    				col.add(j);
    			}
    		}
    	}
    	
    	for (int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[0].length;j++){
    			if(row.contains(i) || col.contains(j)){
    				matrix[i][j] = 0;
    			}
    		}
    	}    	    	
    }*/
    
    //in place method
    //http://answer.ninechapter.com/solutions/set-matrix-zeroes/
    public void setZeroes(int[][] matrix){
    	if (matrix == null || matrix.length == 0 || matrix[0].length ==0){
    		return;
    	}
    	boolean empty_row0 = false;
    	boolean empty_col0 =  false;
    	int row = matrix.length;
    	int col = matrix[0].length;
    	
    	//check whether row0 has "0" 
    	for(int i=0;i<col;i++){
    		if(matrix[0][i] == 0){
    			empty_row0 = true;
    			break;
    		}
    	}
    	
    	//check whether col0 has "0" 
    	for(int i=0;i<row;i++){
    		if(matrix[i][0] == 0){
    			empty_col0 = true;
    			break;
    		}
    	}
    	
    	//use row0 and col0 to mark all the coordinates that are "0"
    	for(int i=1;i<row;i++){
    		for(int j=1;j<col;j++){
    			if(matrix[i][j] == 0){
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
        		}
    		}    		
    	}
    	
    	// assign zero to all satisfied position except row0 and col0
    	for(int i=1;i<row;i++){
    		for(int j=1;j<col;j++){
    			if(matrix[0][j] == 0 || matrix[i][0] == 0){
    				matrix[i][j] = 0;
        		}
    		}    		
    	}
    	
    	// assign zero to row0 if needed
    	if (empty_row0){
    		for(int i=0;i<col;i++){
        		matrix[0][i] = 0;
        	}
    	}
    	
    	// assign zero to col0 if needed
    	if (empty_col0){
    		for(int i=0;i<row;i++){
        		matrix[i][0] = 0;
        	}
    	}
    }
    
}
