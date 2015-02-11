package Unique_Paths;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(uniquePaths(100, 100)); 
	}

	/***
	 * https://oj.leetcode.com/problems/unique-paths/
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below). The robot can only move either down or right at
	 * any point in time. The robot is trying to reach the bottom-right corner
	 * of the grid (marked 'Finish' in the diagram below). 
	 * How many possible unique paths are there?
	 * 
	 * http://leetcode.com/wp-content/uploads/2014/12/robot_maze.png
	 * Above is a 3 x 7 grid. How many possible unique paths are there?
	 * 
	 * Note: m and n will be at most 100.
	 */
	
	//DP, matrix, O(n^2) space
	//http://answer.ninechapter.com/solutions/unique-paths/
	//1.state: result[i][j]表示从[0][0]到[i][j],一共有多少种不同path
	//2:function: result[i][j] = result[i - 1][j] + result[i][j - 1];
	//3.initialize: result[0][0] = 1
	//				result[0][j] = 1
	//				result[i][0] = 1
	//4.answer: result[m - 1][n - 1]
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) { // 给第一行,  第一列赋初值
					result[i][j] = 1;
				} else {
					result[i][j] = result[i - 1][j] + result[i][j - 1];
				}
			}
		}
		return result[m - 1][n - 1]; //最右下角的即为所求
	}
	
	//DP, matrix, O(n) space
	//http://blog.csdn.net/linhuanmars/article/details/22135231
	public int uniquePathsBigO_n_Space(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[] result = new int[n]; // result[j]表示从[0][0]位置，到当前第i行，第j列有多少种走法
		result[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				result[j] += result[j - 1]; 
			}
		}
		return result[n - 1];
	}
}
