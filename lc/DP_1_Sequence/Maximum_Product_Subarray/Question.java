package Maximum_Product_Subarray;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,-2,4};
		Question q = new Question();
		System.out.println(q.maxProd(A));
	}
	
	/**
	 * https://oj.leetcode.com/problems/maximum-product-subarray/
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest product.
	 * 
	 * For example, 
	 * given the array [2,3,-2,4], 
	 * the contiguous subarray [2,3] has the largest product = 6.
	 */
	
	//DP 1Seq
	//类似: https://oj.leetcode.com/problems/maximum-subarray/
	//http://blog.csdn.net/linhuanmars/article/details/39537283
	//“区别是维护一个局部最优不足以求得后面的全局最优，这是由于乘法的性质不像加法那样，累加结果只要是正的一定是递增，
	//乘法中有可能现在看起来小的一个负数，后面跟另一个负数相乘就会得到最大的乘积。”
	//1.state: maxCur[i]代表直到前i个字符，包涵i最大的product值
	//		   minCur[i]代表直到前i个字符，包涵i最小的product值
	//		   maxProd直到i最大的product值（未必要包涵i）
	//		   minProd直到i最小的product值（未必要包涵i）
	//2.function: maxCur[i] = max(A[i], A[i] * maxCur[i - 1], A[i] * minCur[i - 1]); 
	//			 （意思是：到i为止的最大乘积，可能是A[i]本身；如果A[i]为正，则可能是A[i] * maxCur[i - 1]；如果A[i]为负，则可能是 A[i] * minCur[i - 1]。三者中挑最大）
	//    		      再根据maxCur[i]更新maxProd
	//
	//			  minCur[i] = min(A[i], A[i] * maxCur[i - 1], A[i] * minCur[i - 1]); 
	//			 （意思是：到i为止的最小乘积，可能是A[i]本身；如果A[i]为负，则可能是A[i] * maxCur[i - 1]；如果A[i]为正，则可能是 A[i] * minCur[i - 1]。三者中挑最小）
	//			     再根据minrResult[i]更新minProd
	//3.initialize: minCur[1] = maxCur[1] = maxProd = minProd = A[0];
	//4.answer: maxProd
	public int maxProd(int[] A) {
		if (A == null || A.length == 0) {
			return Integer.MIN_VALUE;
		}
		int[] minCur = new int[A.length + 1];
		int[] maxCur = new int[A.length + 1];
		maxCur[1] = A[0];
		minCur[1] = A[0];
		int maxProd = A[0];
		int minProd = A[0];
		for (int i = 2; i <= A.length; i++) {
			maxCur[i] = Math.max(Math.max(A[i - 1], A[i - 1] * maxCur[i - 1]), A[i - 1] * minCur[i - 1]); //位差
			minCur[i] = Math.min(Math.min(A[i - 1], A[i - 1] * maxCur[i - 1]), A[i - 1] * minCur[i - 1]); //位差
			maxProd = Math.max(maxCur[i], maxProd);
			minProd = Math.max(minCur[i], minProd);
		}
		return maxProd;
	}
}
