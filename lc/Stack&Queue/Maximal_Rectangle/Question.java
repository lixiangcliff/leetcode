package Maximal_Rectangle;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//
	//http://blog.csdn.net/linhuanmars/article/details/24444491
    public int maximalRectangle(char[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
    		return 0;
    	}
    	int max = 0;
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int[] height = new int[col];
    	for(int i=0;i<row;i++){
    		for(int j=0;j<col;j++){
    			//height[j] = matrix[i][j] == 0 ? 0 : height[j]+1;// wrong!! matrix is a char[][]!
    			height[j] = matrix[i][j] == '0' ? 0 : height[j]+1;
    		}
    		int curArea = largestRectangleArea(height);
    		max = Math.max(curArea, max);
    	}
    	return max;
    }
	
	//from https://oj.leetcode.com/problems/largest-rectangle-in-histogram/    
	private int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0){
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();//store index
		int max = 0;
		for (int i=0;i<height.length;i++){
			while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
				int index = stack.pop();
				int curArea = stack.isEmpty() ? height[index]*i : height[index]*(i-stack.peek()-1);
				max =  Math.max(max, curArea);
			}
			stack.push(i);
		}
		while(!stack.isEmpty()){
			int index = stack.pop();
			int curArea = stack.isEmpty() ? height[index]*height.length : height[index]*(height.length - stack.peek()-1);
			max = Math.max(curArea, max);
		}
		return max;
	}

}
