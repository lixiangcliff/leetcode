package Minimum_Path_Sum;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/minimum-path-sum/
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * Note: You can only move either down or right at any point in time.
	 */
	
	//quite similar to unique path: https://oj.leetcode.com/problems/unique-paths/
	//http://www.ninechapter.com/solutions/minimum-path-sum/
	//1.state: result[i][j]表示从[0][0]到[i][j],sum最小的路径
	//2.function: result[i][j] = min(result[i - 1][j] + result[i][j - 1]) + grid[i][j];
	//3.initialize: result[0][0] = grid[0][0];
	//				result[0][j] = result[0][j - 1] + grid[0][j]
	//				result[i][0] = result[i - 1][0] + grid[i][0]
	//4.answer: result[row - 1][col - 1]
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int[][] result = new int[row][col];
		result[0][0] = grid[0][0];
		// 处理第一行
		for (int j = 1; j < col; j++) {
			result[0][j] = result[0][j - 1] + grid[0][j];
		}
		// 处理第一列
		for (int i = 1; i < row; i++) {
			result[i][0] = result[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				result[i][j] = Math.min(result[i][j - 1], result[i - 1][j]) + grid[i][j];
			}
		}
		return result[row - 1][col - 1];
	}
	
	//DP matrix O(n) space
	//http://blog.csdn.net/linhuanmars/article/details/22257673
	public int minPathSumBigO_n_Space(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int[] result = new int[col]; // 从[0][0]到当前第i行第j列的最小路径和
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) { // 左上角一个
					result[0] = grid[0][0];
				} else if (i == 0) { // 第0行，除了左上角那个
					result[j] = grid[0][j] + result[j - 1]; 
				} else if (j == 0) { // 第0列，除了左上角那个【注】到达[i][0]的唯一路径是[i-1][0]。与处理第0行表达式不一样，但本质是一样的
					result[j] += grid[i][j]; 
				} else {
					result[j] = Math.min(result[j], result[j - 1]) + grid[i][j];
				}
			}
		}
		return result[col - 1];
	}

}
