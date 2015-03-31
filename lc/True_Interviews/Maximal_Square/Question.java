package Maximal_Square;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Maximum size square sub-matrix with all 1s (NOT rectangle)
	 * http://www.mitbbs.com/article_t/JobHunting/32922767.html
	 */
	
	//“计算的时候check取min( width,height)相乘？”
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
				max = Math.max(max, (rightIdx - leftIdx - 1) * curH); // 改这行为下面2行
				int minEdge = Math.min(rightIdx - leftIdx - 1, curH);
				max = Math.max(max, minEdge * minEdge);
			}
			stack.push(rightIdx); 
		}
    	return max;
    }
}
