package Longest_Increasing_Continuous_subsequence_II;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution q = new Solution();
		int[][] A = {
				  {1 ,2 ,3 ,4 ,5},
				  {16,17,24,23,6},
				  {15,18,25,22,7},
				  {14,19,20,21,8},
				  {13,12,11,10,9}
			};
		System.out.println(q.longestIncreasingContinuousSubsequenceII(A));
	}
	
	/**
	 * http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence-ii/
	 * Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. 
	 * (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
		Example
		Given a matrix:
		
		[
		  [1 ,2 ,3 ,4 ,5],
		  [16,17,24,23,6],
		  [15,18,25,22,7],
		  [14,19,20,21,8],
		  [13,12,11,10,9]
		]
		return 25
		
		Challenge
		O(nm) time and memory.
	 */
	
	//http://www.cnblogs.com/jianxinzhou/p/4530825.html
	//https://codesolutiony.wordpress.com/2015/05/25/lintcode-longest-increasing-continuous-subsequence-ii/
	public int longestIncreasingContinuousSubsequenceII(int[][] A) {
		int res = 0;
		if (A == null || A.length == 0 || A[0].length == 0) {
			return res;
		}
		int[][] store = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				res = Math.max(res, dfs(A, store, i, j));
			}
		}
		return res;
	}

	//store[i][j]表示在第i，j位置能连续走的最大长度（此函数的返回值也是这个）
	private int dfs(int[][] A, int[][] store, int i, int j) {
		if (store[i][j] != 0) {
			return store[i][j];
		}
		int left = 0, right = 0, up = 0, down = 0; //表示从当前位置[i,j]，往“上下左右”四个方向走，能达到的最长路径
		if (j + 1 < A[0].length && A[i][j + 1] > A[i][j]) { //还可以往右继续走
			right = dfs(A, store, i, j + 1);
		}
		if (j > 0 && A[i][j - 1] > A[i][j]) { //左
			left = dfs(A, store, i, j - 1);
		}
		if (i + 1 < A.length && A[i + 1][j] > A[i][j]) { //下
			down = dfs(A, store, i + 1, j);
		}
		if (i > 0 && A[i - 1][j] > A[i][j]) { //上
			up = dfs(A, store, i - 1, j);
		}
		store[i][j] = Math.max(Math.max(up, down), Math.max(left, right)) + 1; //此位置能得到的最长路径是
		return store[i][j];
	}

}
