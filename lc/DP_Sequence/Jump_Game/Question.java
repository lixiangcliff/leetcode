package Jump_Game;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,2,3};
		//System.out.println(canJump(A));
	}
	
	/**
	 * https://oj.leetcode.com/problems/jump-game/
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
		Each element in the array represents your maximum jump length at that position.
		Determine if you are able to reach the last index.
		
		For example:
		A = [2,3,1,1,4], return true.
		A = [3,2,1,0,4], return false.
	 */
	//http://www.ninechapter.com/solutions/jump-game/
	//1.state: result[i]表示能否最终跳到位置i
	//2.function: 则result[i] = 能够从0跳到i || 能够从1跳到i ||...|| 能够从i-1跳到i
	//能从j跳到i的条件是：result[j] && A[j] + j >= i
	//通项公式general formula: result[i] = OR(result[j] && j < i && A[j] + j >= i) （j取值从0到i-1） ;
	//3.initialize: result[0] = true
	//4.answer: result[A.length - 1]
	//O(n^2)时间复杂度，不是最优解，但是容易想。
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}
		boolean[] result = new boolean[A.length];
		result[0] = true; // 赋初值！【重要】
		for (int i = 1; i < A.length; i++) {
			for (int j = 0; j < i; j++) {
				if (result[j] && A[j] + j >= i) { // 找到任何一个j能跳到i，则可以直接把result[i]置true，并跳出循环。
					result[i] = true;
					break;
				}
			}
		}
		return result[A.length - 1];
	}
	
	//DP 1D
	//O(n) time complex
	//http://blog.csdn.net/linhuanmars/article/details/21354751
	public boolean canJump_BigO_n(int[] A) {
		if (A == null || A.length==0){
			return false;
		}
		int global = 0;
		for (int i = 0; i< A.length-1;i++) { 
			if (global < i) { //means current global cannot reach current i;
				return false;
			}
			int local = A[i] + i;//at current i, local is the longest index it can reach
			global = Math.max(local, global); //"global" is longest index it can ever reach for each current i;
			if (global >= A.length-1) { // already find one index that can jump to the end directly
				return true;
			}
		}
		return (global >= A.length-1);
	}

}
