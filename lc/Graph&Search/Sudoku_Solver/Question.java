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
	//http://blog.csdn.net/linhuanmars/article/details/20748761
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
        	return;
        }
        helper(board, 0, 0);
    }
	
    //helper返回的是知道处理到第[i][j]位置，board是否符合sudoku的要求
	private boolean helper(char[][] board, int i, int j){
		if (j == 9) { // 完成了一行，递归进入下一行的首位
			return helper(board, i + 1, 0);
		}
		if (i == 9) { // 完成所有行
			return true;
		}
		if (board[i][j] == '.') { // 如果board[i][j] == '.'
			for (int k = 1; k <= 9; k++) { // 于是尝试把1到9填入[i][j], 看是否合法
				board[i][j] = (char) (k + '0'); // 把填入的整数转为字符格式;
				if (isValid(board, i, j)) { // 如果把当前k值填入[i][j]可以使board继续合法
					if (helper(board, i, j + 1)) { // 就往board右挪一位，继续递归
						return true;
					}
				}
			}
			board[i][j] = '.'; // recover original situation
		} else {
			return helper(board, i, j + 1); // 当前[i][j]为不是'.', 则继续递归处理下一位
		}
		return false; // 即board[i][j] == '.'，但是针对[i][j]从1到9 都不能使board合法，则false
	}
	
	//同Valid Sudoku （https://oj.leetcode.com/problems/valid-sudoku/）
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
}
