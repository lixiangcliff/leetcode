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
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
		The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
		How many possible unique paths are there?
		
		Above is a 3 x 7 grid. How many possible unique paths are there?
		
		Note: m and n will be at most 100.
	 */
	// http://answer.ninechapter.com/solutions/unique-paths/
	//result[i][j]表示从[0][0]到[i][j],一共有多少种不同path
	//通项公式general formula: result[i][j] = result[i - 1][j] + result[i][j - 1];
	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] result = new int[m][n];
		//给第一列赋初值
		for (int i = 0; i < m; i++) {
			result[i][0] = 1;
		}
		//给第一行赋初值
		for (int i = 1; i < n; i++) {
			result[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		}
		//最右下角的即为所求
		return result[m - 1][n - 1];
	}

}
