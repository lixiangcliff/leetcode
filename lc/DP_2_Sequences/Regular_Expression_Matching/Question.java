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
		System.out.println(q.isMatch("abcdefghijklmn", ".*")); // ".*"可以match任意字符串
		System.out.println(q.isMatch("aab", "c*a*b"));
		System.out.println(q.isMatch("a",".*"));
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
	//Match可以理解为前面的string可否合理用后面的string表示出来
	//DP 2_Seq
	//http://blog.csdn.net/linhuanmars/article/details/21145563
	//http://www.ninechapter.com/solutions/regular-expression-matching/
	//1.state: result[i][j]代表s的前i个字符，是否能match上p的前j个字符。
	//2.function: 
	//	(1)当p[j] != '*': 
	//			如果result[i - 1][j - 1]为true，并且isEqual(s[i], p[j]), 则result[i][j]为true
	//	(2)当p[j] == '*', 但p[j - 1] != '.': 
	//			以下三种情况任何一个为true，则result[i][j]为true
	//				(a) result[i][j - 1]为true （即，p[j]的这个'*'，表示p[j - 1]这位的字符只取1次）
	//				(b) result[i][j - 2]为true （即，p[j]的这个'*'，表示p[j - 1]这位的字符1次都不取，即完全忽略[j],[j - 1]这两位）
	//				(c) result[i - 1][j] && s[i - 1] == s[i] && s[i - 1] == p[j - 1]为true 
	//					（也就是前面相等（res[i - 1][j]）， 然后字符重复（s[i]==s[i - 1] ），并且重复的字符就是*号前面的字符（s[i - 1]==p[j - 1]）， 
	//					这几个条件满足时就可以满足match， 如果一直重复，那么就可以一直match）
	//	(3)当p[j] == '*', 且p[j - 1] == '.': 
	//			如果result[i][j - 2]或者result[i][j - 1]为true，因为".*"可以match任意字符串，所以 result[i, i + 1, ... s.length][j]都为true
	//3.initialize: result[0][0] = true;
	//				如果result[0][j - 2]
	//4.answer: result[A.length][B.length];
	//
	//【注】".*"可以match任意字符串，
	//【注】 isEqual(s[i], p[j])定义为s[i] == p[j] or p[j] = '.'
	//【注】result[][]和s，p有位差
	//【注】外层循环应该是p,然后待匹配串s内层循环扫过来
	public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
        	return true;
        }
        if (p.length() == 0) {
        	return false;
        }
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        result[0][0] = true;
        //j = 0时，肯定为false，所以可以直接跳过
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
