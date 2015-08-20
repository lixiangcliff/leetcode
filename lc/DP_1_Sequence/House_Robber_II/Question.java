package House_Robber_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] nums = {1, 1, 1};
		System.out.println(q.rob(nums));

	}
	
	/**
	 * https://leetcode.com/problems/house-robber-ii/
	 * Note: This is an extension of House Robber.
	 * After robbing those houses on that street, the thief has found himself a new place for his thievery 
	 * so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
	 * That means the first house is the neighbor of the last one. 
	 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
	 * 
	 * Given a list of non-negative integers representing the amount of money of each house, 
	 * determine the maximum amount of money you can rob tonight without alerting the police.
	 */
	
	//如果让nums[0]在可选范围内，那么nums[len - 1]肯定不取；如果让nums[len - 1]在可选范围内，则nums[0]肯定不取；两种情况中取较大的
    public int rob(int[] nums) {
    	if (nums == null || nums.length == 0) {
			return 0;
		}
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	if (nums.length == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	int[] res1 = new int[nums.length];
		res1[0] = nums[0];
		res1[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length - 1; i++) {
			res1[i] = Math.max(res1[i - 1], nums[i] + res1[i - 2]); 
		}
		int[] res2 = new int[nums.length];
		res2[1] = nums[1];
		res2[2] = Math.max(nums[1], nums[2]);
		for (int i = 3; i < nums.length; i++) {
			res2[i] = Math.max(res2[i - 1], nums[i] + res2[i - 2]); 
		}
    	return Math.max(res1[nums.length - 2], res2[nums.length - 1]);
    }
}
