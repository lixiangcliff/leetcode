package Longest_Common_Substring;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * http://lintcode.com/en/problem/longest-common-substring/
	 * Given two strings, find the longest common substring.
	 * Return the length of it.
	 * 
	 * Note: The characters in substring should occur continiously in original
	 * string. This is different with subsequnce.
	 */
	
	//http://www.ninechapter.com/solutions/longest-common-substring/
	//1.state: result[i][j]代表A的前i个字符，配上B的前j个字符的LCS的长度。（需要分别以i和j结尾的）
	//2.function: 当A[i] == B[j]， result[i][j] = result[i - 1][j - 1] + 1 （累计+1可以继续）
	//			      当A[i] != B[j]， result[i][j] = 0 （累计归零）
	//3.initialize: result[0][j] = 0;
	//				result[i][0] = 0;
	//4.answer: max(result[0...A.length][B...length]);
	//【注】result[][]和A，B有位差
    public int longestCommonSubstring(String A, String B) {
    	if (A == null || B == null) {
    		return 0;
    	}
    	int max = 0;
    	int[][] result = new int[A.length() + 1][B.length() + 1];
    	for (int i = 0; i <= A.length(); i++) {
    		for (int j = 0; j <= B.length(); j++) {
    			if (i == 0 || j == 0) { //初始化第一行，第一列
    				result[i][j] = 0;
    			} else if (A.charAt(i - 1) == B.charAt(j - 1)) { //位差
    				result[i][j] = result[i - 1][j - 1] + 1;
    				max = Math.max(max, result[i][j]);
    			} else {
    				result[i][j] = 0;
    			}
    		}
    	}
    	return max;
    }
}
