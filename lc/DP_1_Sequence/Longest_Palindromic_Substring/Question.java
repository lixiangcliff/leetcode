package Longest_Palindromic_Substring;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "abcdefgfedcba";
		String s = "abba";
		System.out.println(longestPalindrome(s));
	}
	
	/**
	 * https://oj.leetcode.com/problems/longest-palindromic-substring/
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 */
	//my way
/*   public static String longestPalindrome(String s) {
        if(s == null){
        	return null;
        }
        if (s.length() <= 1){
        	return s;
        }
        int len = s.length();
        String result = s.substring(0,1);
        for(int i=0;i<len-1;i++){
        	StringBuilder sb = new StringBuilder();
        	int left = i;
        	int right = i;
        	sb.append(s.charAt(i));
        	int j = i+1;
        	while(j<len && s.charAt(i)==s.charAt(j)){
        		sb.append(s.charAt(i));
        		j++;
        	}
        	left--;
        	right=j;
        	if (sb.length() > result.length()){
				result = sb.toString();
			}
        	while(left>=0 && right<=len-1){
        		if (s.charAt(left) == s.charAt(right)){
        			sb.insert(0, s.charAt(left));
        			sb.append(s.charAt(right));
        			if (sb.length() > result.length()){
        				result = sb.toString();
        			}
        		}else{
        			break;
        		}
        		left--;
        		right++;
        	}
        }
        return result;
    }*/

	//http://blog.csdn.net/linhuanmars/article/details/20888595
	//method 2 using DP
	 public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String result = "";
		int maxLen = 0;
		int len = s.length();
		boolean[][] isPalindromeEnd2End = new boolean[len][len];
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i <= 2 || isPalindromeEnd2End[i + 1][j - 1])) {
					isPalindromeEnd2End[i][j] = true;
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						result = s.substring(i, j + 1);
					}
				}
			}
		}
		return result;
	 }
}
