package Jump_Game_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {2,3,1,1,4};
		int[] A = {3,2,1};
		Question q = new Question();
		System.out.println(q.jump(A));
	}
	

	/**
	 * https://oj.leetcode.com/problems/jump-game-ii/
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array. Each element in the array represents your
	 * maximum jump length at that position. Your goal is to reach the last
	 * index in the minimum number of jumps.
	 * 
	 * For example: 
	 * Given array A = [2,3,1,1,4] The minimum number of jumps to
	 * reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps
	 * to the last index.)
	 */
	
	//其实是two pointer问题
	//Greedy
	//http://www.cnblogs.com/yuzhangcmu/p/4148858.html
	//O(n^2)时间复杂度，O(1)空间复杂度。
	public int jump(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		int l = 0; // 每轮开始位置
		int r = 0; // 每轮结束位置
		int len = nums.length;
		int step = 0;
		int maxReach = nums[0];
		while (l <= r && r <= len - 1) { //【注】如果l > r 表示本轮maxReach未增加，这样下一轮的i就无法到达，则该直接返回异常。
			step++; // 每增加1轮就 多跳1步
			for (int i = l; i <= r; i++) { // 找到本轮的maxReach
				maxReach = Math.max(maxReach, nums[i] + i);
				if (maxReach >= len - 1) { // 已经可以到达最末了
					return step;
				}
			}
			l = r + 1; // l的新位置为本轮还没尝试过的最左边位置
			r = maxReach; // r的新位置为本轮算出的目前最远能达到的位置
		}
		return -1; // 表示无法到达最后
	}
	
	//leetcode不能ac {25000,24999,24998,24997,24996,24995,24994,24993...}
	//DP 1Seq
	//看【注】
	//http://www.ninechapter.com/solutions/jump-game-ii/
	//1.state: result[i]代表跳到第i个位置最少需要几步
	//2.function: 则result[i] = min(result[j]+1; 前提是j<i && 能够从j跳到i)（而其中的最小值，就是第一个符合条件的j，具体看【注】）
	//(其中，能从j跳到i的条件是：result[j] && A[j] + j >= i)
	//(之所以有result[j]+1，是因为到达[j]需要result[j]步，而且它又能从j跳到i，即有再加1步，就跳到i了)
	//3.initialize: result[1] = 0
	//4.answer: result[A.length]
	//result和A有1个位差
	//O(n^2)时间复杂度，O(n)空间复杂度。不是最优解，但是容易想。
	public int jumpDP(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] result = new int[A.length + 1];
		result[1] = 0;
		for (int i = 2; i <= A.length; i++) {
			result[i] = -1; //表示不存在跳到i的办法。（如果下面循环结束result[i]仍然为-1，则说明根本没有办法跳到当前的i）
			for (int j = 1; j < i; j++) {
				//result[j] != -1  表示最起码有办法跳到j ；
				//A[j] + j >= i 表示并且有办法从j跳到i
				if (result[j] != -1 && A[j - 1] + j >= i) { 
					result[i] = result[j] + 1; //到达[j]需要result[j]步，而且它又能从j跳到i，即有再加1步，就跳到i了
					break;//【注】在这里就可以跳出了。而不需要列出所有可行的j，然后再找其中的最小值。
						  //原因是： 对于任何x<y, 总有result[x] <= result[y], 即如果需要m步才能跳到y，那么用m步肯定可以跳到x（反之不然）	
				}
			}
		}
		return result[A.length];
	}
}
