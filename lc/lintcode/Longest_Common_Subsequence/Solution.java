package Longest_Common_Subsequence;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * http://lintcode.com/en/problem/longest-common-subsequence/#
	 * Given two strings, find the longest comment subsequence (LCS).
	 * Your code should return the length of LCS.
	 * 
	 * Example 
	 * For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1
	 * For "ABCD" and "EACB", the LCS is "AC", return 2
	 */
	
	//http://www.ninechapter.com/solutions/longest-common-subsequence/
	//【注】subsequence，字符可以不连续取
	//1.state: result[i][j]代表A的前i个字符，配上B的前j个字符的LCS的长度。
	//2.function: 当A[i] == B[j]， result[i] = result[i - 1][j - 1] + 1 （+1因为A[i]和B[j]也能配上）
	//			      当A[i] != B[j]， result[i] = max(result[i - 1][j], result[i][j - 1]) （A[i]和B[j]配不上，就让A的前i和B的前j-1配一下，再让A的前i-1和B的前j配一下，看哪个大就选哪个）
	//3.initialize: result[0][j] = 0;
	//				result[i][0] = 0;
	//4.answer: result[A.length][B.length];
	//【注】result[][]和A，B有位差
    public int longestCommonSubsequence(String A, String B) {
    	if (A == null || B == null || A.length() == 0 || B.length() == 0) {
    		return 0;
    	}
    	int lenA = A.length();
    	int lenB = B.length();
    	int[][] result = new int[lenA + 1][lenB + 1];
    	for (int i = 0; i <= lenA; i++) {
    		for (int j = 0; j <= lenB; j++) {
    			if (i == 0 || j == 0) {//第一行和第一列赋初值
    				result[i][j] = 0;
    			} else if (A.charAt(i - 1) == B.charAt(j - 1)) { //体现出result[][]和A，B的位差
    				result[i][j] = result[i - 1][j - 1] + 1;
    			} else {
    				result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
    			}
    		}
    	}
    	return result[lenA][lenB];
    }

}
