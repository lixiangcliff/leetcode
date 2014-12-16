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
	
	
	//另一个思想是，每次遍历当前加入的数，是否仍然使棋盘合法。
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
	
	//http://blog.csdn.net/linhuanmars/article/details/20748171
	//【注】boolean[] visited = new boolean[9]的位置不同，原则是没处理9个元素就出reset(new)一次visited
	public boolean isValidSudoku2(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}
		// rows
		for (int i = 0; i < 9; i++) {
			boolean[] visited = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (visited[(int) (board[i][j] - '1')]) {// 已经曾经被访问过了
						return false;
					}
					visited[(int) (board[i][j] - '1')] = true;
				}// 如果board[i][j] == '.' 什么也不需要做。因为'.'有几个，位置在哪里都无所谓
			}
		}
		// columns
		for (int j = 0; j < 9; j++) {
			boolean[] visited = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (visited[(int) (board[i][j] - '1')]) {
						return false;
					}
					visited[(int) (board[i][j] - '1')] = true;
				}
			}
		}
		// for each 3*3 square
		// 看图！block示意图如下
		// 0 1 2
		// 3 4 5
		// 6 7 8
		for (int block = 0; block < 9; block++) {// block 从0到9 对应了九个3*3的小block
			boolean[] visited = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {// block取0,1,2时，i要取0,1,2
				// 【注】j和i的取值方式不同！
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {// block取0,3,6时，j要取0,1,2
					if (board[i][j] != '.') {
						if (visited[(int) (board[i][j] - '1')]) {
							return false;
						}
						visited[(int) (board[i][j] - '1')] = true;
					}
				}
			}
		}
		return true;
	}
    
    

}
