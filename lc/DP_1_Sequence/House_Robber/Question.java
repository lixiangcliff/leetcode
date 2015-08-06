package House_Robber;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/house-robber/
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that 
	 * adjacent houses have security system connected and it will automatically contact the police
	 *  if two adjacent houses were broken into on the same night.
		Given a list of non-negative integers representing the amount of money of each house, 
		determine the maximum amount of money you can rob tonight without alerting the police.
	 */

	//1 seq DP http://www.cnblogs.com/pkuYang/p/4391020.html
	//res[i]前i个数的符合条件的最大sum res[i]
	//res[i] = Math(res[i - 1], res[i - 2] + num[i]) 即不取num[i]和取num[i]
	public int rob(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return num[0];
		}
		int[] res = new int[num.length];
		res[0] = num[0];
		res[1] = Math.max(num[0], num[1]);
		for (int i = 2; i < num.length; i++) {
			res[i] = Math.max(res[i - 1], num[i] + res[i - 2]); 		
		}
		return res[num.length - 1];
	}
}
