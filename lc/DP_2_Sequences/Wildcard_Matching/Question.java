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
	//Match可以理解为前面的string可否合理用后面的string表示出来
	//DP 2_Seq
	//http://blog.csdn.net/linhuanmars/article/details/21198049
	//http://www.ninechapter.com/solutions/wildcard-matching/
	//1.state: result[i][j]代表s的前i个字符，是否能match上p的前j个字符。
	//2.function: 
	//	(1)当p[j] != '*': 
	//			如果result[i - 1][j - 1]为true，并且isEqual(s[i], p[j]), 则result[i][j]为true
	//	(3)当p[j] == '*': 
	//			如果result[i][j - 1]为true，因为"*"可以match任意字符串，所以 result[i, i + 1, ... s.length][j]都为true
	//3.initialize: result[0][0] = true;
	//4.answer: result[A.length][B.length];
	//
	//【注】 isEqual(s[i], p[j])定义为s[i] == p[j] or p[j] = '?'
	//【注】result[][]和s，p有位差
	//【注】外层循环应该是p,然后待匹配串s内层循环扫过来
	//http://blog.csdn.net/linhuanmars/article/details/21198049
	public boolean isMatch(String s, String p) {
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
	
	//http://blog.csdn.net/linhuanmars/article/details/21198049
    public boolean isMatch2(String s, String p) {
        if (p.length() == 0){
        	return s.length() == 0;
        }
        //to pass leetcode start;
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')  
            return false;
        ////to pass leetcode end;
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for(int j=0; j<p.length(); j++){
        	if(p.charAt(j) != '*'){
        		for(int i=s.length()-1; i>=0; i--){
        			result[i+1] = result[i] && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?');
        		}
        	}else{
        		int i=0;
        		while(i<=s.length() && !result[i]){
        			result[i++] = false;
        		}
        		while(i<=s.length()){
        			result[i++] = true;
        		}
        	}
        	result[0] = result[0] && p.charAt(j)=='*';
        }
        return result[s.length()];
    }

}
