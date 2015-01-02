package Trapping_Rain_Water;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(q.trap(A));

	}
	
	/**
	 * https://oj.leetcode.com/problems/trapping-rain-water/
	 * Given n non-negative integers representing an elevation map where the
	 * width of each bar is 1, compute how much water it is able to trap after
	 * raining.
	 * 
	 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png
	 * The above elevation map is represented by array
	 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
	 * section) are being trapped. Thanks Marcos for contributing this image!
	 */
	
	//O(2n) 时间复杂度
	//类似 Candy 
	//思路就是维护一个长度为n的数组(数组里值就是当前bar对应的左或右桶高)，进行两次扫描，一次从左往右，一次从右往左。
	//1.第一次扫描的时候维护对于每一个bar左边最大的高度（桶高）是多少，存入数组对应元素中，
	//2.第二次扫描的时候维护右边最大的高度，并且比较将左边和右边较小的桶高存入数组对应元素中。
	//这样两遍扫描之后就可以得到每一个bar能承受的最大水量，如果较小的桶高大于bar高，则累加，否则跳过，最终得出结果。
	
	//http://blog.csdn.net/linhuanmars/article/details/20888505
	//http://blog.unieagle.net/2012/10/31/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Atrapping-rain-water/
    public int trap(int[] A) {
		if (A == null || A.length <= 2) {
			return 0;
		}
    	int n = A.length;
    	//从左往右以及从右往左扫描的这两次，总共只需要一个数组即可
    	int[] highest = new int[n];
    	
    	//max，当从左往右时，表示的是当扫描到i时，i左边遇到过的最大值(桶左端高)；从右往左类似。
    	//而highest[i]里面存的就是在第i位对应的max
    	int max = A[0];
    	//从左往右,从第二个开始
		for (int i = 1; i < n; i++) {
			highest[i] = max; // 当前highest[i]置max
			max = Math.max(A[i], max); // 如果当前值比max大，则更新max，以备下一个i使用
		}
    	
    	//从右往左扫，与上面类似
    	max = A[A.length - 1];
    	int result = 0;
    	//从倒数第二个开始
		for (int i = n - 1; i >= 0; i--) {
    		int lower = Math.min(highest[i], max); // lower表示左端和右端桶高中较低的一个
    		if (lower > A[i]) { //即 只有左边最高和右边最高两者之间较小的那个，比当前bar高度大，对当前的bar才有面积累加
    			result += lower - A[i];
    		}
    		max = Math.max(A[i], max); // 更新max
    	}
        return result;
    }
}
