package Jump_Game_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,4};
		System.out.println(jump(A));
	}
	

	/**
	 * https://oj.leetcode.com/problems/jump-game-ii/
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
		Each element in the array represents your maximum jump length at that position.
		Your goal is to reach the last index in the minimum number of jumps.
		
		For example:
		Given array A = [2,3,1,1,4]
		The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
	 */
	//http://www.ninechapter.com/solutions/jump-game-ii/
	//1.state: result[i]代表跳到i最少需要几步
	//2.function: 则result[i] = min(result[j]+1; 前提是j<i && 能够从j跳到i)
	//(其中，能从j跳到i的条件是：result[j] && A[j] + j >= i)
	//(之所以有result[j]+1，是因为到达[j]需要result[j]步，而又有能从j跳到i，即有再加1步，就跳到i了)
	//3.initialize: result[0] = 0
	//4.answer: result[A.length - 1]
	//O(n^2)时间复杂度，不是最优解，但是容易想。
	public static int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] result = new int[A.length];
		result[0] = 0;
		for (int i = 1; i < A.length; i++) {
			result[i] = -1; //表示不存在跳到i的办法。（如果下面循环结束result[i]仍然为-1，则说明根本没有办法跳到当前的i）
			for (int j = 0; j < i; j++) {
				//result[j] != -1  表示最起码有办法跳到j ；
				//A[j] + j >= i 表示有办法从j跳到i
				if (result[j] != -1 && A[j] + j >= i) { 
					result[i] = result[j] + 1; //到达[j]需要result[j]步，而又有能从j跳到i，即有再加1步，就跳到i了
					break;//【注】，为什么在这里就可以跳出了？而不需要列出所有可行的j，然后再找其中的最小值？
				}
			}
		}
		return result[A.length - 1];
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21356187
	/*
	 * example that helps understanding:
	 * 
	 * 		 index: 0 1 2 3 4
	 * input array: 2 3 1 1 4
	 * longestJump: 3 4 3 4 8
	 * last  reach: 0 2 2 4 4  //each column means the farthest it can currently reach. e.g col2: value is 2, means it can reach to index 2 at the most, so we have to make one step(update lastReach into reach) to move further 
	 * 		 reach: 2 4 4 4 8
	 * 		  step:	0 1 1 2 2	
	 * 
	 */
	public int jump_BigO_n(int[] A) {
		if(A== null || A.length == 0){
			return 0;
		}
		int reach = 0;
		int lastReach = 0;
		int step = 0;
		for(int i=0;i<A.length && reach >= i;i++){
			int longestJump = A[i] + i;
			if(lastReach < i){ //means lastReach cannot reach current i, we must make one more step to reach here; (meanwhile to update lastReach)
				step++;
				lastReach = reach;
			}
			reach = Math.max(longestJump, reach);
		}
		return reach >= A.length-1 ? step : 0;
	}

}
