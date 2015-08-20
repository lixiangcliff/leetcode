package Longest_Increasing_Subsequence;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] nums = {9,3,6,2,7};
		System.out.println(s.longestIncreasingSubsequence(nums));
	}

	/**
	 * http://lintcode.com/en/problem/longest-increasing-subsequence/
	 * Given a sequence of integers, find the longest increasing subsequence
	 * (LIS).
	 * You code should return the length of the LIS.
	 * 
	 * Example 
	 * For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
	 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
	 * 
	 * Challenge Expand Time complexity O(n^2) or O(nlogn)
	 */
	
	//http://www.ninechapter.com/solutions/longest-increasing-subsequence/
	//1.state: result[i]代表直到前i个字符，以i结尾的LIS的长度
	//2.function: 则result[i] = max(result[j]+1); （j范围为[1~i) && a[j] <= a[i]）
	//3.initialize: result[i] = 1（i范围[0,a.length]。最差情况都是倒序的，则当前i的LIS为1）
	//4.answer: max(result[0], result[1]...result[nums.length];
	//O(n^2)时间复杂度
	public int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = 1;
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i]) { // 找到一个比i数值小的位置。
					result[i] = Math.max(result[i], result[j] + 1);
				}
			}
			max = Math.max(max, result[i]);
		}
		return max;
	}
}
