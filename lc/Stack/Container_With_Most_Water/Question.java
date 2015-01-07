package Container_With_Most_Water;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] matrix = {1,2,3,4,5};
		int[] matrix = {2,1};
		System.out.println(maxArea(matrix));

	}
	
	/**
	 * https://oj.leetcode.com/problems/container-with-most-water/
	 * Given n non-negative integers a1, a2, ..., an, where each represents a
	 * point at coordinate (i, ai). n vertical lines are drawn such that the two
	 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
	 * together with x-axis forms a container, such that the container contains
	 * the most water.
	 * 
	 * Note: You may not slant the container.
	 */
	//idea from http://answer.ninechapter.com/solutions/container-with-most-water/
	// for any i, the maxium area will be the farthest j that has a[j] > a[i];
	//that's why we start "left" from 0 and "right" from length-1
	// http://blog.csdn.net/wzy_1988/article/details/17248209
	/*
	 * 思想：每次计算面积时的bottleneck是左右两个"侧边"中较低的那一个。
	 * 假如左边的低，那么就把左边向右移动。这是因为右边向左移动只会使面积更小。
	 * (面积=底边*min(左，右)，右边向左的话，底边变小，而min(左,右)不变)
	 */
	public static int maxArea(int[] height) {
		if (height== null || height.length < 2){
			return 0;
		}
    	int max = 0;
    	int left = 0;
    	int right = height.length-1;
    	while (left < right){
    		max = Math.max(max, Math.min(height[left], height[right])*(right-left) );
    		//means left is the smaller one--the bottleneck, we want to move to right trying to find a bigger left, to increase bottleneck
    		if (height[left] < height[right]){ 
    			left++;
    		} else{
    			right--;
    		}
    	}
        return max; 
    }
}
