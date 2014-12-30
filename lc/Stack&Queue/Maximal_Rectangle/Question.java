package Maximal_Rectangle;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		char[][] matrix = { 
				{ '0', '1', '1', '0', '0' }, 
				{ '0', '1', '1', '0', '0' },
				{ '0', '0', '1', '1', '0' }, 
				};
		System.out.println(q.maximalRectangle(matrix));
		
	}
	
	/**
	 * https://oj.leetcode.com/problems/maximal-rectangle/
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest
	 * rectangle containing all ones and return its area.
	 */
	
	//此题用到Stack和DP的知识
	//思想来自：Largest_Rectangle_in_Histogram
	//http://blog.csdn.net/linhuanmars/article/details/24444491
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int[] height = new int[col]; // 直到当前第i行，每一列的累计高度
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) { // DP: 对于height中每个col，遇到'0',就把置reset为0,否则就累积高度。
				height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1; //【注】此处为char '0'而非int 0。
			}
			int curArea = largestRectangleArea(height); //在每一行计算到尾部时，针对该行的计算Rectangle
			max = Math.max(curArea, max);
		}
		return max;
	}

	// from https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
	private int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}
    	LinkedList<Integer> stack = new LinkedList<Integer>();// 【注】stack中存的是各个元素的index
    	int max = 0;
    	// i <= height小技巧，因为要在i==height处虚拟地再补一个“0”高度的元素，来把最后stack里的值都pop出来(如果stack还有值的话)
		for (int i = 0; i <= height.length; i++) {
			int rightIndex = i;
			int rightHeight = i == height.length ? 0 : height[i]; // curHeight = 0的情况， 即上面说的小技巧
			while (!stack.isEmpty()) {
				if (rightHeight < height[stack.peek()]) { //说明当前i就是此时stack的栈顶元素的右端，可以将其pop出来并且计算以pop元素为高的最大矩形面积了
					int popIndex = stack.pop();
					int leftIndex = stack.isEmpty() ? -1 : stack.peek();
					max = Math.max(max, (rightIndex - leftIndex - 1) * height[popIndex]); // 此处面积公式要分清：左端，右端和高分别是什么。
				} else { // 即 如果当前i位置的元素值如果大于等于栈顶值，则直接跳出循环然后把该index压入栈
					break; 
				}
			}
			stack.push(i); // 记得压栈的是index
		}
    	return max;
    }
	/*private int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();// store index
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int index = stack.pop();
				int curArea = stack.isEmpty() ? height[index] * i
						: height[index] * (i - stack.peek() - 1);
				max = Math.max(max, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int index = stack.pop();
			int curArea = stack.isEmpty() ? height[index] * height.length
					: height[index] * (height.length - stack.peek() - 1);
			max = Math.max(curArea, max);
		}
		return max;
	}*/

}
