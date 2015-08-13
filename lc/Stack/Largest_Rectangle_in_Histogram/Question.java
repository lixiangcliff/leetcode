package Largest_Rectangle_in_Histogram;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] height = {2,1,5,6,2,3};
		System.out.println(q.largestRectangleArea(height));
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
	
	//Ma老师讲的思路：
	//O(n)。看图！ 以每个元素值为高，左边第一个比它的值小的元素index作为左端，右边第一个比它的值小的元素index作为右端所组成的矩形。然后遍历所有元素，得到最大面积值。
	//对于求左右端的办法，就是用stack：（通过每次处理height中的元素，来对stack进行push和pop操作来得到以每个元素为高的最大矩形面积）
	//push的原则： 当前元素值大于等于栈顶元素值（【注】push和pop的是index）
	//pop原则：当前元素值小于栈顶元素值
	//则对于任何时候的栈顶元素来说，它的左端即为与它相邻并且更靠近栈底的元素的index；它的右端就是导致它pop出来的比它值小的元素的index
	//http://blog.csdn.net/linhuanmars/article/details/20524507
    public int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}
    	LinkedList<Integer> stack = new LinkedList<Integer>();// 【注】stack中存的是各个元素的index
    	int max = 0;
		for (int i = 0; i <= height.length; i++) { // i <= height小技巧，因为要在i==height.length处虚拟地再补一个“0”高度的元素，来把最后stack里的值都pop出来(如果stack还有值的话)
			int rightIdx = i;
			int rightH = i == height.length ? 0 : height[i]; // rightH == 0的情况， 即上面说的小技巧
			while (!stack.isEmpty() && rightH < height[stack.peek()]) { //说明当前i就是此时stack的栈顶元素为高度的右端边界（不包括），可以将其pop出来并且计算以pop元素为高的最大矩形面积了) 
				int curH = height[stack.pop()];
				int leftIdx = stack.isEmpty() ? -1 : stack.peek(); // 【注】当stack为空时，leftIdx值为-1 而不是0
				max = Math.max(max, (rightIdx - leftIdx - 1) * curH); // 此处面积公式要分清：左端，右端和高分别是什么。
			}
			stack.push(rightIdx); // 无论如何最后都要把当前i压入栈
		}
    	return max;
    }
}
