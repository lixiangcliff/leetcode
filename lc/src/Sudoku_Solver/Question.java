package Sudoku_Solver;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((char)(9+'0'));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/20748761
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
        	return;
        }
        helper(board, 0, 0);
    }
	
	private boolean helper(char[][] board, int i, int j){
		if(j==9){
			return helper(board, i+1, 0);
		}
		if(i==9){
			return true;
		}
		if(board[i][j] == '.'){
			for(int k=1;k<=9;k++){
				board[i][j] = (char)(k+'0');//convert int k into its char form;
				if (isValid(board, i, j)){
					//return helper(board, i, j+1); // why this is wrong?..
					if(helper(board,i,j+1)){  
                        return true;
					}
				}
			}
			board[i][j] = '.'; // recover original situation
		}else{
			return helper(board, i, j+1);
		}
		return false;
	}
	
	private boolean isValid(char[][] board, int i, int j){
		for(int k=0;k<9;k++){
			if(k!=j && board[i][k] == board[i][j]){
				return false;
			}
		}
		for(int k=0;k<9;k++){
			if(k!=i && board[k][j] == board[i][j]){
				return false;
			}
		}
		for(int k=i/3*3; k<i/3*3+3; k++){ //very skillful!
			for(int m=j/3*3; m<j/3*3+3; m++){
				if ((k != i || m != j) && board[i][j] ==  board[k][m]){
					return false;
				}
			}
		}
		return true;
	}

}
