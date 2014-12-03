package Distinct_Subsequences;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "rabbbit";
		String T = "rabbit";
		System.out.print(numDistinct(S,T));
	}
	
	/**
	 * https://oj.leetcode.com/problems/distinct-subsequences/
	 * Given a string S and a string T, count the number of distinct
	 * subsequences of T in S.
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ACE"
	 * is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Here is an example: 
	 * S = "rabbbit", T = "rabbit"
	 * Return 3.
	 */
	//【注】简单翻译一下，给定两个字符串S和T，求S有多少个不同的子串与T相同。S的子串定义为在S中任意去掉0个或者多个字符形成的串。
	//http://www.ninechapter.com/solutions/distinct-subsequences/
	//1.state: result[i][j]代表： 在S的前i个字符中，有几个不同的子串，与T的前j个字符相同。
	//2.function: 当S[i] != T[j]， result[i][j] = result[i - 1][j] （因为S中新增加的i并没有产生新的可能的字符串可以使新的S和T满足要求）
	//			      当S[i] == T[j]， result[i][j] = result[i - 1][j - 1] + result[i - 1][j]) （S[i]==T[i],则result[i - 1][j - 1]满足的都可以被result[i][j]所用）
	//3.initialize: result[0][j] = 0; 第一行（S为空，则没有任何办法可以从S中找到子串和T相同）
	//				result[i][0] = 1; 第一列（T为空，则只有一种办法从S中找到子串和T相同，即S也取空）
	//4.answer: result[A.length][B.length];
	//【注】result[][]和A，B有位差
	public static int numDistinct(String S, String T) {
		if (S == null || T == null) {
			return 0;
		}
		int[][] result = new int[S.length() + 1][T.length() + 1];
		for (int i = 0; i <= S.length(); i++) {
			for (int j = 0; j <= T.length(); j++) {
				if (j == 0) { //第一列【注】小技巧，要先处理第一列，因为result[0][0]应该为1，如果后处理则会被result[0][j] = 0覆盖
					result[i][0] = 1;
				} else if (i == 0) { //第一行
					result[0][j] = 0;
				} else if (S.charAt(i - 1) != T.charAt(j - 1)) { //位差
					result[i][j] = result[i - 1][j]; 
				} else {
					result[i][j] = result[i - 1][j] + result[i - 1][j - 1]; 
				}
			}
		}
		return result[S.length()][T.length()];
	}
	
	
	
	//two dimension DP: http://blog.csdn.net/abcbc/article/details/8978146 
	//one dimension DP: http://blog.csdn.net/linhuanmars/article/details/23589057
	/*
	 * example:
					S(j) index
				    0 1 2 3 4 5 6 7
				      r a b b b i t
		T(i)	0   1 1 1 1 1 1 1 1
		index	1 r 0 1 1 1 1 1 1 1
				2 a 0 0 1 1 1 1 1 1
				3 b 0 0 0 1 2 3 3 3
				4 b 0 0 0 0 1 3 3 3
				5 i 0 0 0 0 0 0 3 3
				6 t 0 0 0 0 0 0 0 3 
				
				result[][]
	 */
    public static int numDistinct2(String S, String T) {
    	int sLen = S.length();
    	int tLen = T.length();
        if (sLen == 0){
        	return 0;
        }
        if (tLen == 0){
        	return 1;
        }
        int[][] result = new int[tLen+1][sLen+1];
        Arrays.fill(result[0], 1);
        for(int i=1;i<tLen+1;i++){
        	result[i][0] = 0;
        }
        for(int i=1; i<tLen+1;i++){
        	for(int j=1;j<sLen+1;j++){
        		//if: T.charAt(i-1) != S.charAt(j-1)
        		//then: result[i][j] == result[i][j-1]; 
        		//because adding S.charAt(j-1) will not make more subsequence
        		//
        		//if: T.charAt(i-1) == S.charAt(j-1)
        		//then: result[i][j] == result[i][j-1] + result[i-1][j-1];
        		//because all valid subsequence in result[i][j-1] still count;
        		//meanwhile all valid subsequence in result[i-1][j-1] will be still valid(after adding same char at the end) 
        		result[i][j] = result[i][j-1] + (T.charAt(i-1) == S.charAt(j-1) ? result[i-1][j-1] : 0);
        	}
        }
        return result[tLen][sLen];
    }

}
