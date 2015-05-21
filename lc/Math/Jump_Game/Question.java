package Jump_Game;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,2,1,0,4};
		Question q = new Question();
		System.out.println(q.canJump(A));
	}
	
	/**
	 * https://oj.leetcode.com/problems/jump-game/
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array. Each element in the array represents your
	 * maximum jump length at that position. Determine if you are able to reach
	 * the last index.
	 * 
	 * For example: 
	 * A = [2,3,1,1,4], return true. 
	 * A = [3,2,1,0,4], return false.
	 */
	
	//http://www.cnblogs.com/yuzhangcmu/p/4039840.html
	//greedy O(n)时间复杂度，O(1)空间复杂度。
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int maxReach = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (maxReach < i) { // 无法到达前i处
				return false;
			}
			maxReach = Math.max(maxReach, nums[i] + i); // 更新maxReach
			if (maxReach >= nums.length - 1) { // 已经可以直接到最右
				return true;
			}
		}
		return true;
	}
	
	//DP 1Seq
	//http://www.ninechapter.com/solutions/jump-game/
	//1.state: result[i]表示能否最终跳到位置i
	//2.function: 则result[i] = 能够从第1个位置跳到第i个位置 || 能够从2跳到i ||...|| 能够从i-1跳到i
	//能从j跳到i的条件是：result[j] && A[j] + j >= i
	//通项公式general formula: result[i] = OR(result[j] && j < i && A[j] + j >= i) （j取值从1到i-1） ;
	//3.initialize: result[1] = true
	//4.answer: result[A.length]
	//result和A有1个位差
	//O(n^2)时间复杂度，O(n)空间复杂度。不是最优解，但是容易想。
	public boolean canJumpDP(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}
		boolean[] result = new boolean[A.length + 1];
		result[1] = true; // 赋初值！【重要】
		for (int i = 2; i <= A.length; i++) {
			for (int j = i - 1; j >= 1; j--) { //之所以j不从左往右扫是为了pass这个testcase：input {1,1,1.....1,1,1} （巨多个1...）
				if (result[j] && A[j - 1] + j >= i) { // 找到任何一个j能跳到i，则可以直接把result[i]置true，并跳出循环。【注】位差
					result[i] = true;
					break;
				}
			}
		}
		return result[A.length];
	}
	
}
