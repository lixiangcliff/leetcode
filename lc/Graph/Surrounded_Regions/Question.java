package Surrounded_Regions;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		char[][] board = {
							{'O', 'O', 'O', 'X','X', 'X', 'X', 'O',},
							{'X', 'O', 'O', 'X','X', 'O', 'O', 'O',},
							{'X', 'O', 'O', 'X','X', 'O', 'X', 'X',},
							{'X', 'O', 'O', 'O','O', 'O', 'X', 'X',},
							{'X', 'O', 'O', 'X','O', 'X', 'X', 'X',},
							{'O', 'O', 'O', 'X','O', 'O', 'X', 'X',},
							{'O', 'X', 'O', 'X','O', 'O', 'O', 'X',},
							{'O', 'O', 'O', 'X','O', 'O', 'O', 'O',},
							};
		/*String[] src = {"OOOOOOOOXOOOOOXOOOOO","OOOOOOOXOOOOOOOOOOOO","XOOXOXOOOOXOOXOOOOOO","OOOOOOOOOOOOOOOOOXXO","OXXOOOOOOXOOOOOOOOOO","OOOOXOOOOOOXOOOOOXXO","OOOOOOOXOOOOOOOOOOOO","OOOOOOOOOOOOOXOOOOOO","OOOOOOOOOOOOOOOOOOXO","OOOOOXOOOOOOOOOOOOOO","OOOOOOOOXOOOOOOOOOOO","OOOOXOOOOXOOOOOOOOOO","OOOOOOOOXOOOOOOOOOOO","XOOOOOOOOXXOOOOOOOOO","OOOOOOOOOOOXOOOOOOOO","OOOOXOOOOOOOOXOOOOOX","OOOOOXOOOOOOOOOXOXOO","OXOOOOOOOOOOOOOOOOOO","OOOOOOOOXXOOOXOOXOOX","OOOOOOOOOOOOOOOOOOOO"};
		int row = src.length;
		int col = src[0].length();
		char[][] board = new char[row][col];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = src[i].charAt(j);
				System.out.print(board[i][j] + ",");
			}
			System.out.println("");
		}
		System.out.println("=============");*/
		q.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + ",");
			}
			System.out.println("");
		}
		

	}
	
	/**
	 * https://oj.leetcode.com/problems/surrounded-regions/
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded
	 * by 'X'.
	 * A region is captured by flipping all 'O's into 'X's in that surrounded
	 * region.
	 * 
	 * For example, 
	 * X X X X 
	 * X O O X
	 * X X O X 
	 * X O X X 
	 * 
	 * After running your function, the board should be:
	 * X X X X
	 * X X X X
	 * X X X X
	 * X O X X
	 */
	
	//思想：
	//1.对上下左右边缘做Flood fill算法（即对四周的每一个'O'做以此bfs），把所有边缘上的'O'都替换成另一个字符，比如'#'。
	//2.将剩下的所有'O'都应该被替换成'X'，并且将所有'#'都还原成'O'
	//http://blog.csdn.net/linhuanmars/article/details/22904855
	public void solve(char[][] board) {
		// only floodfill 4 edges
		if (board == null || board.length <= 1 || board[0].length <= 1) {
			return;
		}
		int rowLen = board.length;
		int colLen = board[0].length;
		// Flood fill第一和最后一行
		for (int j = 0; j < colLen; j++) {
			helper(board, 0, j);
			helper(board, rowLen - 1, j);
		}
		// Flood fill最左和最右列
		for (int i = 1; i < rowLen - 1; i++) {
			helper(board, i, 0);
			helper(board, i, colLen - 1);
		}
		// 反转中间的"O" 以及 恢复边缘的"#"
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (board[i][j] == 'O') { // 反转中间的 'O'
					board[i][j] = 'X';
				}
				if (board[i][j] == '#') { // 恢复边缘的"#"
					board[i][j] = 'O';
				}
			}
		}
	}

	//用BFS来Flood fill（此题是标记和边缘上的'O'连通的所有'O'）
	private void helper(char[][] board, int i, int j) {
		if (board[i][j] != 'O') {
			return;
		}
		board[i][j] = '#'; // 到这步说明board[i][j] == 'O'，所以暂时把它标记为'#'
		LinkedList<Integer> queue = new LinkedList<Integer>(); //queue中存内容（曾经）为'O'的position
		int colLen = board[0].length;
		int pos = i * colLen + j; // 【注】用1个整数来表示node在board中的位置，这种方法可以将原来用两个参数来表示坐标的方法(i,j)，变成只用一个（方便在queue中存储）
		queue.offer(pos);
		while (!queue.isEmpty()) {
			pos = queue.poll();
			int row = pos / colLen; // 从pos中恢复出原来的i的位置信息
			int col = pos % colLen; // 从pos中恢复出原来的j的位置信息
			if (row > 0 && board[row - 1][col] == 'O') { // 如果当前点上边点，为'O'
				queue.offer((row - 1) * colLen + col); // 将该点上边点放入队列
				board[row - 1][col] = '#'; // 将该点上边点标记为'#'
			}
			if (row < board.length - 1 && board[row + 1][col] == 'O') { // 如果当前点下边点，为'O'
				queue.offer((row + 1) * colLen + col);
				board[row + 1][col] = '#';
			}
			if (col > 0 && board[row][col - 1] == 'O') { // 如果当前点左边点，为'O'
				queue.offer(row * colLen + col - 1);
				board[row][col - 1] = '#';
			}
			if (col < colLen - 1 && board[row][col + 1] == 'O') { // 如果当前点右边点，为'O'
				queue.offer(row * colLen + col + 1);
				board[row][col + 1] = '#';
			}
		}
	}

}
