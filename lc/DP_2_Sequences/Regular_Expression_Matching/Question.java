package Regular_Expression_Matching;

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
		System.out.println(q.isMatch("aa", "a*"));
		System.out.println(q.isMatch("aa", ".*"));
		System.out.println(q.isMatch("aab", "c*a*b"));
		System.out.println(q.isMatch("a",".*"));
		System.out.println(q.isMatch("abc", "*"));
		System.out.println(q.isMatch("", "*."));
/*		System.out.println(q.isMatch2("aa","a"));
		System.out.println(q.isMatch2("aa","aa"));
		System.out.println(q.isMatch2("aaa","aa"));
		System.out.println(q.isMatch2("aa", "a*"));
		System.out.println(q.isMatch2("aa", ".*"));
		System.out.println(q.isMatch2("aab", "c*a*b"));
		System.out.println(q.isMatch2("a",".*"));*/
		//System.out.println(q.isMatch("abc", "*"));
		//System.out.println(q.isMatchDP2("abcdede", "ab.*de"));
		//System.out.println(q.isMatch("abcdefghijklmn", ".*")); // ".*"可以match任意字符串
	}
	
	/**
	 * https://oj.leetcode.com/problems/regular-expression-matching/
	 * Implement regular expression matching with support for '.' and '*'.
	 * '.' Matches any single character. 
	 * '*' Matches zero or more of the preceding element.
	 * The matching should cover the entire input string (not partial).
	 * The function prototype should be: bool isMatch(const char *s, const char *p)
	 * 
	 * Some examples: 
	 * isMatch("aa","a") → false 
	 * isMatch("aa","aa") → true
	 * isMatch("aaa","aa") → false 
	 * isMatch("aa", "a*") → true 
	 * isMatch("aa", ".*") → true 
	 * isMatch("ab", ".*") → true 
	 * isMatch("aab", "c*a*b") → true
	 */
	
	//Zhe's method:
	public boolean isMatch(String s, String p) {
		if (s == null || p == null){
        	return false;
        }
		int len1 = s.length();
		int len2 = p.length();
		boolean[][] result = new boolean[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 && j == 0) { // s和p都为空时，true
	        		result[i][j] = true;
	        	} else if (i == 0) { // s为空 ，并且p不为空。需要p长度大于1,并且p[j]是'*',并且result[i][j - 2]==true已经“扫清之前的障碍”了，才可能是true
	        		result[i][j] = j > 1 && p.charAt(j - 1) == '*' && result[i][j - 2]; // 位差
	        	} else if (j == 0) { // p为空，并且s不为空
	        		result[i][j] = false;
	        	} else {
	        		if (p.charAt(j - 1) == '*') { 
	        			// j > 1: 避免数组越界 	result[i][j - 2]:表示*前一个数取0次 ;	
	        			// ||后面的：表示*前一个数取n次 【注】result[i - 1][j]：反例e.g. s = "abcd", t = "d*",
	        			// 如果要取p[j-1]，必须同时满足s[i]==p[j-1]和result[i - 1][j]==true。
						result[i][j] = j > 1 && result[i][j - 2] || 
								j > 1 && result[i - 1][j] && (p.charAt(j - 2)  == s.charAt(i - 1) || p .charAt(j - 2) == '.');
	        		} else { 
	        			result[i][j] = result[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'); //位差
		        	}
	        	}
			}
		}
		return result[len1][len2];
	}
	
	//Match可以理解为前面的string可否合理用后面的string表示出来
	//DP 2_Seq
	//http://blog.csdn.net/linhuanmars/article/details/21145563
	//http://www.cnblogs.com/yuzhangcmu/p/4105529.html
	//1.state: result[i][j]代表s的前i个字符，是否能match上p的前j个字符。
	//2.function: 
	//	(1)当p[j] != '*': 
	//			如果result[i - 1][j - 1]为true，并且isEqual(s[i], p[j]), 则result[i][j]为true
	//	(2)当p[j] == '*', 但p[j - 1] != '.': 
	//			以下三种情况任何一个为true，则result[i][j]为true
	//				(a) result[i][j - 1]为true （即，p[j]的这个'*'，表示p[j - 1]这位的字符只取1次）
	//				(b) result[i][j - 2]为true （即，p[j]的这个'*'，表示p[j - 1]这位的字符1次都不取，即完全忽略[j],[j - 1]这两位）
	//				(c) result[i - 1][j] && s[i - 1] == s[i] && s[i - 1] == p[j - 1]为true 
	//					（也就是前面相等（res[i - 1][j]）， 然后字符重复（s[i]==s[i - 1] ），并且重复的字符就是*号前面的字符（s[i - 1]==p[j - 1]））
	//	(3)当p[j] == '*', 且p[j - 1] == '.': 
	//			因为".*"可以表示任何字符，所以以下几种情况可以使result[i][j]为true
	//				(a)只要有任何一个result[k][j-2]（k范围[0,i]）为true。（因为k后面的剩余都可以被".*"来match上）
	//	b和c貌似不必要//(b)result[i][j - 2]为true。这时".*"表示空
	//				//(c)result[i][j - 1]为true。这时".*"的"*"表示1,即整体表示1个"."
	//3.initialize: result[0][0] = true; // s和p都为空
	//				result[i][0] = false; // p为空，并且s不为空
	//				result[0][j] = 情况复杂，只有满足下面条件才为true。具体的看下面代码; // s为空 ，并且p不为空。
	//4.answer: result[A.length][B.length];
	//
	//【注】".*"可以match任意字符串，
	//【注】 isEqual(s[i], p[j])定义为s[i] == p[j] or p[j] = '.'
	//【注】result[][]和s，p有位差
	public boolean isMatch2(String s, String p) {
		if (s == null || p == null){
        	return false;
        }
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
	        for (int j = 0; j <= p.length(); j++) {
	        	if (i == 0 && j == 0) { // s和p都为空时，true
	        		result[i][j] = true;
	        	} else if (i == 0) { // s为空 ，并且p不为空。需要p长度大于1,并且p[j]是'*',并且result[i][j - 2]==true已经“扫清之前的障碍”了，才可能是true
	        		result[i][j] = j > 1 && p.charAt(j - 1) == '*' && result[i][j - 2]; // 位差
	        	} else if (j == 0) { // p为空，并且s不为空
	        		result[i][j] = false;
	        	} else {
	        		if (p.charAt(j - 1) != '*') { //【注】情况(1)
	    				result[i][j] = result[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'); //位差
	        		} else  if (j > 1 && p.charAt(j - 2) != '.') { //位差  【注】情况(2) 
		        			result[i][j] = result[i][j - 1] || result[i][j - 2] || (i > 1 && j > 1 && result[i - 1][j] && s.charAt(i - 2) == s.charAt(i - 1) && s.charAt(i - 2) == p.charAt(j - 2)); // 位差
		        	} else { // 【注】情况(3)
		        		boolean foundPrevMatch = false;
		        		if (j > 1) {
			        		for (int k = 0; k <= i; k++) {
			        			if (result[k][j - 2]) {
			        				foundPrevMatch = true;
			        				break;
			        			}
			        		}
		        		}
		        		result[i][j] = foundPrevMatch; 
		        	} 
	        	}
	        }
        }
        return result[s.length()][p.length()];
    }
	
	//http://blog.csdn.net/linhuanmars/article/details/21145563
	//【注】外层循环应该是p,然后待匹配串s内层循环扫过来
	public boolean isMatchDP2(String s, String p) {
		if (p.length() == 0){
        	return s.length() == 0;
        }
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        result[0][0] = true;
        //j = 0，而i != 0时，肯定为false，所以可以直接跳过
        for (int j = 1; j <= p.length(); j++) {
        	if (p.charAt(j - 1) == '*') { //位差
        		//i = 0时，因为p[j]为'*'，所以p[j - 1]的情况不影响结果（大不了j和j - 1位直接忽略）
        		//所以只要result[0][j - 2]为true，则result[0][j]也为true
        		if (j > 1 && result[0][j - 2]){
        			result[0][j] = true;
        		}
        		if (p.charAt(j - 2) != '.') { //位差  【注】情况(2) 
        			for (int i = 1; i <= s.length(); i++) {
        				if (result[i][j - 1] || result[i][j - 2] || (i > 1 && j > 1 && result[i - 1][j] && s.charAt(i - 2) == s.charAt(i - 1) && s.charAt(i - 2) == p.charAt(j - 2))) { //位差
        					result[i][j] = true;
        				}
        			}
        		} else { // 【注】情况(3)
        			boolean foundMatch = false;
        			for (int i = 1; i <= s.length(); i++) {
        				if (foundMatch) {
        					result[i][j] = true;
        				} else if ((j > 1 && result[i][j - 2]) || result[i][j - 1]) { 
        					result[i][j] = true;
        					foundMatch = true;
        				}
        			}
        		}
        	} else { // 【注】情况(1)
        		for (int i = 1; i <= s.length(); i++) {
    				if (result[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) { //位差
    					result[i][j] = true;
    				}
    			}
        	}
        }
        return result[s.length()][p.length()];
    }
	
		
	//brutal force
	//all explanation below:
	//http://blog.csdn.net/fightforyourdream/article/details/17717873
	//http://blog.csdn.net/linhuanmars/article/details/21145563
    public boolean isMatchBrutal(String s, String p) {
        return helper(s, p, 0, 0);
    }
    
	private boolean helper(String s, String p, int i, int j) {
		if (j == p.length()) { //如果已经遍历完p中所有字符
			return i == s.length(); // 返回 是否也已经遍历了s中的所有字符
		}
		if (j == p.length() - 1) { // 如果当前处理的是p的最后一个字符
			return (i == s.length() - 1) && isEqual(s, p, i, j); //返回是否当前也正在处理s的最后一个字符，并且算上s和p的最后一个字符仍match
		}
		// 如果当前处理的是p最后一个字符之前的字符，并且p的下一个字符不为*
		if (j < p.length() - 1 && p.charAt(j + 1) != '*') {
			if (i == s.length()) { //如果此时已经处理完s中所有字符，则false
				return false;
			}
			if (isEqual(s, p, i, j)) { //如果算上s和p分别当前字符仍match，则s和p分别继续递归处理右边1个字符
				return helper(s, p, i + 1, j + 1);
			} else { //如果已经不match，则false
				return false;
			}
		}

		// 当前p的下一位是'*'， 并且s和p都还有字符，并且s和p当前位仍match
		while (i < s.length() && j < p.length() && isEqual(s, p, i, j)) { 
			if (helper(s, p, i, j + 2)) { //跳过p的第j+1位，直接递归j+2位
				return true;
			}
			i++;
		}
    	///p.charAt(j+1) == '*' && !isEqual(s, p, i, j)
		// 如果当前p的下一位是'*' 并且s和p的当前位不match
		return helper(s, p, i, j + 2);
	}
    
	//判断s的第i位，和p的第j位，是否可以match
	private boolean isEqual(String s, String p, int i, int j) {
		return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
	}
    
}
