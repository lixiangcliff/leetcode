package Maximal_Square;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		char[][] matrix = {{'1','1','0','1'},{'1','1','0','1'},{'1','1','1','1'}};
		System.out.println(q.maximalSquare(matrix));
	}
	
	/**
	 * https://leetcode.com/problems/maximal-square/
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
	 * For example, given the following matrix:

		1 0 1 0 0
		1 0 1 1 1
		1 1 1 1 1
		1 0 0 1 0
		Return 4.
	 */
	
	//similar to Maximal_Rectangle
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int[] height = new int[col]; // 
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) { 
				height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1; 
			}
			int curArea = largestRectangleArea(height); 
			max = Math.max(curArea, max);
		}
		return max;
	}

	// from https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
    public int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	int max = 0;
		for (int i = 0; i <= height.length; i++) { 
			int rightIdx = i;
			int rightH = i == height.length ? 0 : height[i]; 
			while (!stack.isEmpty() && rightH < height[stack.peek()]) { 
				int curH = height[stack.pop()];
				int leftIdx = stack.isEmpty() ? -1 : stack.peek(); 
				int edge = Math.min(rightIdx - leftIdx - 1, curH); //【注】和rectangle的唯一区别
				max = Math.max(max, edge * edge); 
			}
			stack.push(rightIdx); 
		}
    	return max;
    }

}
