package Wildcard_Matching;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.isMatch("aa","a"));
		System.out.println(q.isMatch("aa","aa"));
		System.out.println(q.isMatch("aaa","aa"));
		System.out.println(q.isMatch("aa", "*"));
		System.out.println(q.isMatch("aa", "a*"));
		System.out.println(q.isMatch("ab", "?*"));
		System.out.println(q.isMatch("aab", "c*a*b"));
		System.out.println(q.isMatch("", "*"));
		System.out.println(q.isMatch("acb", "a*"));
	}
	
	/**
	 * https://oj.leetcode.com/problems/wildcard-matching/
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * '?' Matches any single character. 
	 * '*' Matches any sequence of characters(including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * The function prototype should be: 
	 * bool isMatch(const char *s, const char *p)
	 * 
	 * Some examples: 
	 * isMatch("aa","a") → false 
	 * isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false 
	 * isMatch("aa", "*") → true 
	 * isMatch("aa", "a*") → true 
	 * isMatch("ab", "?*") → true 
	 * isMatch("aab", "c*a*b") → false
	 */
	
	//Zhe's method
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
        //to pass leetcode start;
        // without this optimization, it will fail for large data set
		int pNoneStarLen = 0; //p中的非'*'的字符数量
		for (char c : p.toCharArray()) {
			if (c != '*') {
				pNoneStarLen++;
			}
		}
		if (pNoneStarLen > s.length()){ //如果p中非'*'字符数量比s还多，则说明p中肯定有冗余，所以false
			return false;
		}
        //to pass leetcode end;
		boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= p.length(); j++) {
				if (i == 0 && j == 0) {
					result[i][j] = true;
				} else if (i == 0) { //p[j]为'*',并且result[0][j - 1]为true，则result[0][j]才为true
					result[i][j] = result[0][j - 1] && p.charAt(j - 1) == '*'; // 位差
				} else if (j == 0) {
					result[i][j] = false;
				} else {
					if (p.charAt(j - 1) == '*') { // 位差
						//result[i][j - 1]: '*'表示什么都不取
						//result[i - 1][j]： 表示如果s的前i - 1个和p的前j个配起来如果都没有问题的话，s最后再加一个s[i]肯定也没问题('*'只需要多表示一位就可以了)
		    			result[i][j] = result[i][j - 1] || result[i - 1][j]; 
					} else {
						result[i][j] = result[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
					}
				}
			}
		}
		return result[s.length()][p.length()];
	}
	
	//Match可以理解为前面的string可否合理用后面的string表示出来
	//DP 2_Seq
	//http://blog.csdn.net/linhuanmars/article/details/21198049
	//http://www.ninechapter.com/solutions/wildcard-matching/
	//1.state: result[i][j]代表s的前i个字符，是否能match上p的前j个字符。
	//2.function: 
	//	(1)当p[j] != '*': 
	//			如果result[i - 1][j - 1]为true，并且isEqual(s[i], p[j]), 则result[i][j]为true
	//	(2)当p[j] == '*': 
	//			因为"*"可以表示任何字符，只要有任何一个result[k][j-1]（k范围[0,i]）为true,则result[i][j]为true（因为k后面的剩余都可以被"*"来match上）
	//3.initialize: result[0][0] = true; // s和p都为空
	//				result[i][0] = false; // p为空，并且s不为空
	//				result[0][j] = p[j]为'*',并且result[0][j - 1]为true，则result[0][j]才为true // s为空 ，并且p不为空。
	//4.answer: result[A.length][B.length];
	//
	//【注】 isEqual(s[i], p[j])定义为s[i] == p[j] or p[j] = '?'
	//【注】result[][]和s，p有位差
	public boolean isMatch2(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
        //to pass leetcode start;
        // without this optimization, it will fail for large data set
		int pNoneStarLen = 0; //p中的非'*'的字符数量
		for (char c : p.toCharArray()) {
			if (c != '*') {
				pNoneStarLen++;
			}
		}
		if (pNoneStarLen > s.length()){ //如果p中非'*'字符数量比s还多，则说明p中肯定有冗余，所以false
			return false;
		}
        //to pass leetcode end;
		boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= p.length(); j++) {
				if (i == 0 && j == 0) {
					result[i][j] = true;
				} else if (i == 0) { //p[j]为'*',并且result[0][j - 1]为true，则result[0][j]才为true
					result[i][j] = result[0][j - 1] && p.charAt(j - 1) == '*'; // 位差
				} else if (j == 0) {
					result[i][j] = false;
				} else {
					if (p.charAt(j - 1) != '*') { // 位差
		    			result[i][j] = result[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
					} else {
						boolean foundPrevMatch = false;
						for (int k = 0; k <= i; k++) {
							if (result[k][j - 1]) {
								foundPrevMatch = true;
								break;
							}
						}
						result[i][j] = foundPrevMatch;
					}
				}
			}
		}
		return result[s.length()][p.length()];
	}
	
	//【注】外层循环应该是p,然后待匹配串s内层循环扫过来
	//http://blog.csdn.net/linhuanmars/article/details/21198049
	public boolean isMatchDP2(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
        //to pass leetcode start;
        // without this optimization, it will fail for large data set
		int plenNoStar = 0; //p中的非'*'的字符数量
		for (char c : p.toCharArray()) {
			if (c != '*') {
				plenNoStar++;
			}
		}
		if (plenNoStar > s.length()){ //如果p中非'*'字符数量比s还多，则说明p中肯定有冗余，所以false
			return false;
		}
        //to pass leetcode end;
		boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
		result[0][0] = true;
		//j = 0，而i != 0时，肯定为false，所以可以直接跳过
		for (int j = 1; j <= p.length(); j++) {
			if (p.charAt(j - 1) != '*') { // 位差
				for (int i = 1; i <= s.length(); i++) {
					if (result[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) { //位差
    					result[i][j] = true;
    				}
				}
			} else {
				//i = 0时，因为p[j]为'*'，所以p[j - 1]的情况不影响结果
        		//所以只要result[0][j - 1]为true，则result[0][j]也为true
        		if (result[0][j - 1]){
        			result[0][j] = true;
        		}
				boolean foundMatch = false;
    			for (int i = 1; i <= s.length(); i++) {
    				if (j == 1) { // 当p的首位是'*'
    					result[i][j] = true;
    				} else if (foundMatch) {
    					result[i][j] = true;
    				} else if (result[i][j - 1]) { 
    					result[i][j] = true;
    					foundMatch = true;
    				}
    			}
			}
		}
		return result[s.length()][p.length()];
	}
}
