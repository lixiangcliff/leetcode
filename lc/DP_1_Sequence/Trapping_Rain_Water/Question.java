package Trapping_Rain_Water;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));

	}
	
	/**
	 * https://oj.leetcode.com/problems/trapping-rain-water/
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 * The above elevation map is represented by array
	 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
	 * section) are being trapped. Thanks Marcos for contributing this image!
	 */
	//enhancement use 2*O(n) instead of 3*O(n)
	//http://blog.unieagle.net/2012/10/31/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Atrapping-rain-water/
	//O(n)的 需要进一步研究：http://blog.csdn.net/linhuanmars/article/details/20888505
    public static int trap(int[] A) {
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	int n = A.length;
    	//从左往右以及从右往左扫描的这两次，总共只需要一个数组即可
    	int[] highest = new int[n];
    	/*
    	 * max，当从左往右时，表示的是当扫描到i时，i左边遇到过的最大值(不包括此时的i)；从右往左类似。
    	 * 而highest[i]里面存的就是在第i位对应的max
    	 */
    	
    	//从左往右
    	int max = 0;
    	for(int i=0;i<n;i++){
    		highest[i] = max;//把之前累计的max放入highest[i]
    		max = Math.max(A[i], max);//如果当前值比max大，则更新max，以备下一个i使用
    	}
    	
    	//从右往左扫，与上面类似
    	max = 0;
    	int water = 0;
    	//从倒数第二个开始
    	for(int i=n-1;i>=0;i--){
    		int leftHigh = highest[i];//先把从左往右扫时候计算出的左边最大值存起来，以备后面计算面积用
    		highest[i] = max;
    		//即 只有左边最高和右边最高两者之间较小的那个，让然别当前高度大，对当前的bar才有面积累加
    		int lower = Math.min(leftHigh, highest[i]);
    		if( lower > A[i]){
    			water += lower - A[i];
    		}
    		max = Math.max(A[i], max);  		
    	}
    	
        return water;
    }

}
