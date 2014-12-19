package Largest_Rectangle_in_Histogram;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
	
	/**
	 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * http://leetcode.com/wp-content/uploads/2012/04/histogram.png
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3].
	 * 
	 * http://leetcode.com/wp-content/uploads/2012/04/histogram_area.png
	 * The largest rectangle is shown in the shaded area, which has area = 10
	 * unit.
	 * 
	 * For example, Given height = [2,1,5,6,2,3], return 10.
	 */
	//http://blog.csdn.net/linhuanmars/article/details/20524507
    public static int largestRectangleArea(int[] height) {
    	if(height == null || height.length == 0){
    		return 0;
    	}
    	LinkedList<Integer> stack = new LinkedList<Integer>();//store index
    	int max = 0;
    	for (int i=0;i<height.length;i++){
    		//while(!stack.isEmpty() && height[i] <= stack.peek()){ // wrong!! need always distinguish well "index" and "height value"!
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
