package Surrounded_Regions;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/22904855
    public void solve(char[][] board) {
        //only floodfill 4 edges
    	if(board == null || board.length <= 1 || board[0].length <= 1){
    		return;
    	}
    	for(int i=0;i<board[0].length;i++){
    		fill(board, 0, i);
    		fill(board, board.length-1, i);
    	}
    	for(int i=0;i<board.length;i++){
    		fill(board, i, 0);
    		fill(board, i, board[0].length-1);
    	}
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board[0].length; j++){
    			if(board[i][j] == 'O'){
    				board[i][j] = 'X';
    			}
    			if(board[i][j] == '#'){
    				board[i][j] = 'O';
    			}
    		}
    	}
    }
    
    private void fill(char[][] board, int i, int j){
    	if(board[i][j] != 'O'){
    		return;
    	}
    	board[i][j] = '#';
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	int len = board[0].length;
    	int code = i*len + j;
    	queue.offer(code);
    	while(!queue.isEmpty()){
    		code = queue.poll();
    		int row = code/len;
    		int col = code%len;
    		if(row>0 && board[row-1][col] == 'O'){
    			queue.offer((row-1)*len+col);
    			board[row-1][col] = '#';
    		} 
    		if(row<board.length-1 && board[row+1][col] == 'O'){
    			queue.offer((row+1)*len+col);
    			board[row+1][col] = '#';
    		}
    		if(col>0 && board[row][col-1] == 'O'){
    			queue.offer(row*len+col-1);
    			board[row][col-1] = '#';
    		}
    		if(col<len-1 && board[row][col+1] == 'O'){
    			queue.offer(row*len+col+1);
    			board[row][col+1] = '#';
    		}
    	}
    }

}
