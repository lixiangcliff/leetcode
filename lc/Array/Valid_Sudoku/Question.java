package Valid_Sudoku;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		boolean[] visited = new boolean[10]; 
		Arrays.fill(visited, false);
		char[] line = {'1','2', '3', '5', '.', '.' , '6', '7','8'};*/
		Question q = new Question();
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
		System.out.println(q.isValidSudoku(board));

	}
	
	/**
	 * https://oj.leetcode.com/problems/valid-sudoku/
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	 * (http://sudoku.com.au/TheRules.aspx)
	 * 
	 * The Sudoku board could be partially filled, where empty cells are filled
	 * with the character '.'.
	 * 
	 * Note: A valid Sudoku board (partially filled) is not necessarily
	 * solvable. Only the filled cells need to be validated.
	 */
	
	//思想是，每次遍历当前加入的数，是否仍然使棋盘合法。
	//http://blog.csdn.net/linhuanmars/article/details/20748761
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (!isValid(board, i, j)) {
					return false;
				}
			}
		}
		return true; 
	}
	
	private boolean isValid(char[][] board, int i, int j){
		for (int k = 0; k < 9; k++) { // 检测同一行
			if (k != j && board[i][k] == board[i][j]) {
				return false;
			}
		}
		for (int k = 0; k < 9; k++) { // 检测同一列
			if (k != i && board[k][j] == board[i][j]) {
				return false;
			}
		}
		for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) { // 可以理解为，以3个为一个单位，向下取整。
			for (int m = j / 3 * 3; m < j / 3 * 3 + 3; m++) {
				if ((k != i || m != j) && board[i][j] == board[k][m]) { // k != i || m != j 意味着[i][j]个和 [k][m]不是同一个点
					return false;
				}
			}
		}
		return true;
	}
	
	//另一个方法是用hashset，但是时间复杂度是一样的(棋盘点数 * 3)。
	//http://www.cnblogs.com/yuzhangcmu/p/4067608.html 
}
