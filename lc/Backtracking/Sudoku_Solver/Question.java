package Sudoku_Solver;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((char)(9+'0'));
	}
	
	/**
	 * https://oj.leetcode.com/problems/sudoku-solver/
	 * Write a program to solve a Sudoku puzzle by filling the empty cells.
	 * Empty cells are indicated by the character '.'.
	 * You may assume that there will be only one unique solution.
	 * 
	 * http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
	 * A sudoku puzzle...
	 * 
	 * http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png
	 * ...and its solution numbers marked in red.
	 */
	
	//try this: https://leetcode.com/discuss/30482/straight-forward-java-solution-using-backtracking
	
	//DFS
	//http://www.cnblogs.com/yuzhangcmu/p/4067733.html
	//http://blog.csdn.net/linhuanmars/article/details/20748761
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
        	return;
        }
        helper(board, 0, 0);
    }
	
    //helper返回的是直到处理到第[i][j]位置，board是否符合sudoku的要求
	private boolean helper(char[][] board, int i, int j){
		if (i == 9) { // 完成所有行
			return true;
		}
		if (j == 9) { // 完成了一行，递归进入下一行的首位
			return helper(board, i + 1, 0);
		}
		if (board[i][j] != '.') { 
			return helper(board, i, j + 1); // 继续递归处理下一位
		}
		//否则当前[i][j]就是 '.'
		for (int k = 1; k <= 9; k++) { // 尝试把1到9填入[i][j]
			board[i][j] = (char) (k + '0'); // 把当前k转为字符格式，并填入board (add)
			if (isValid(board, i, j) && helper(board, i, j + 1)) { //【注】如果把当前k值填入[i][j]可以使board合法且该方案可以让下一轮的递归也合法，才是最终的合法。
				return true; // 即“要想使DFS成功返回，条件就是找到满足本轮的解和这个解也要满足下一轮（子问题）。” (recursion) 
			}
			board[i][j] = '.'; // backtracking (remove) 【注】其实backtracking这一行放在for外边也可以，且效率更高些。这样是写为了格式清晰。
		}
		return false; // 即board[i][j] == '.'，但是k从1到9尝试放入[i][j]都不能使board合法，则false
	}
	
	//检查第[i][j]的元素是否会导致board非法。同Valid Sudoku （https://oj.leetcode.com/problems/valid-sudoku/）
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
	
	//Zhe's method:
/*	public void solveSudoku(char[][] board) {
		char[][] result = new char[9][9];
		try {
			helper(board, 0, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void helper(char[][] board, int i, int j) throws Exception {
		if (i == 9) {
			throw (new Exception());
		}
		if (board[i][j] == '.') {
			for (int k = 1; k < 10; k++) {
				if (isValid(board, i, j, k)) {
					board[i][j] = (char) ('0' + k);
					if (j == 8) {
						helper(board, i + 1, 0);
					} else {
						helper(board, i, j + 1);
					}
					board[i][j] = '.';
				}
			}
		} else {
			if (j == 8) {
				helper(board, i + 1, 0);
			} else {
				helper(board, i, j + 1);
			}
		}
	}

	private boolean isValid(char[][] board, int i, int j, int num) {
		for (int k = 0; k < 9; k++) {
			if (board[i][k] == (char) ('0' + num)) {
				return false;
			}
		}
		for (int k = 0; k < 9; k++) {
			if (board[k][j] == (char) ('0' + num)) {
				return false;
			}
		}
		for (int p = (i - i % 3); p < (i - i % 3 + 3); p++) {
			for (int q = (j - j % 3); q < (j - j % 3 + 3); q++) {
				if (board[p][q] == (char) ('0' + num)) {
					return false;
				}
			}
		}
		return true;
	}*/



	
	
}
