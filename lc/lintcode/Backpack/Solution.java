package Backpack;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 3, 5, 7};
		int m = 12;
		Solution s = new Solution();
		System.out.println(s.backPack(m, A));
	}
	/**
	 * http://lintcode.com/en/problem/backpack/
	 * Given n items with size A[i], an integer m denotes the size of a
	 * backpack. How full you can fill this backpack?
	 * 
	 * Note You can not divide any item into small pieces.
	 * 
	 * Example 
	 * If we have 4 items with size [2, 3, 5, 7], the backpack size is
	 * 11, we can select 2, 3 and 5, so that the max size we can fill this
	 * backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so
	 * that we can fulfill the backpack.
	 * 
	 * You function should return the max size we can fill in the given
	 * backpack.
	 */
	
	//1.state: result[i][m]代表A的前i个数字，取出一些，是否能组成和为m。
	//2.function: result[i][m] = result[i - 1][m - A[i]] OR result[i - 1][m] 
	//	result[i - 1][m - A[i]]表示“和”中选取A[i], 即在前i - 1个数能取出“和”为m - A[i]，那么在第i个数取A[i]就行了
	//	result[i - 1][m]表示“和”中不选取A[i]，即在前i - 1个数就已经取好了“和”为m
	//3.initialize: result[0][0] = true;
	//				result[i][0] = true;
	//				result[0][j] = false;
	//4.answer: 找从右往左(result[A.length][m], result[A.length][m - 1]...第一个为true的result[A.length][n]，返回n);
	//【注】技巧是，DP数组表示“能不能”取出来，然后求结果时候，就从“能”取的里找最大的。
	//【注】result[][]和A有位差
    public int backPack(int m, int[] A) {
        // write your code here
    	if (A == null || A.length == 0) {
    		return 0;
    	}
    	boolean[][] result = new boolean[A.length + 1][m + 1];
    	//result[0][0] = true;
    	for (int i = 0; i <= A.length; i++) {
    		for (int j = 0; j <= m; j++) {
    			if (i == 0 && j == 0) {
    				result[i][j] = true;
    			} else if (i == 0) {
    				result[i][j] = false;
    			} else if (j == 0) {
        			result[i][0] = true;
        		} else if ((j >= A[i - 1] && result[i - 1][j - A[i - 1]]) || result[i - 1][j]) { //A有位差
    				result[i][j] = true;
    			}
    		}
    	}
    	for (int j = m; j >= 0; j--) {
    		if (result[A.length][j]) {
    			return j;
    		}
    	}
    	return 0;
    }
}
