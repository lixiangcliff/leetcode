package Longest_Palindromic_Substring;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//String s = "abcdefgfedcba";
		//String s = "abba";
		String s = "aaa";
		//String s = "a";
		System.out.println(q.longestPalindrome(s));
	}
	
	/**
	 * https://oj.leetcode.com/problems/longest-palindromic-substring/
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 */

	//DP 1 seq
	//【注】leetcode需要额外的补丁pass "aaa...aaa" test case
	//基本采用Palindrome_Partitioning_II的子函数getIsPalindrome(String s)
	//1.state: isPalindrome[i][j]代表s中从第i个char到第j个char是否为palindrome
	//2.function: isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
	//3.initialize: isPalindrome[i][i] = true; （i = 0 ~ s.length() - 1）(对角线)
	//				isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1) （i = 0 ~ s.length() - 2）(对角线右边一个)
	//4.answer: 所有isPalindrome[i][j]为true中的j-i值最大的那一个，返回s.substring(i, j + 1)
	//O(n^2)时间复杂度, O(n^2)空间复杂度
	//http://blog.csdn.net/linhuanmars/article/details/20888595
	public String longestPalindromeDP(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		// 下面的补丁可以pass "aaa...aaa"
		int m = 0;
		int n = s.length() - 1;
		while (m < n) {
		    if (s.charAt(m) != s.charAt(n)) {
		        break;
		    }
		    m++;
		    n--;
		}
		if (m >= n) { // 说明s全部由相同的字符组成。
		    return s;
		}
		// 上面的补丁可以pass "aaa...aaa"
		String result = s.substring(0, 1);
		int maxLen = 1;
		int len = s.length();
		//此矩阵只有右上三角为有效数据。
		boolean[][] isPalindrome = new boolean[len][len];
		//【注】需要从最底层往最顶层计算，因为等号右边的isPalindrome[i + 1][j - 1]在所求的isPalindrome[i][j]的下方。
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j <= len - 1; j++) {
				if (j == i) { //初始化对角线
					isPalindrome[i][j] = true;
				} else if (j == i + 1) { //初始化对角线右边一个
					isPalindrome[i][j] = s.charAt(i) == s.charAt(i + 1);
				} else {
					isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
				}
				if (isPalindrome[i][j] && j - i + 1 > maxLen) { // 从i到j是palindrome，并且i到j的长度比maxLen更长
					maxLen = j - i + 1;
					result = s.substring(i, j + 1); // 记录下最长palindrome的内容，因为这个是最后要返回的值
				}
			}
		}
		return result;
	 }
	
	//中心展开法O(n^2)时间复杂度, O(1)空间复杂度
	//http://www.cnblogs.com/yuzhangcmu/p/4189068.html
	//从左到右遍历s，对每一位i找到它往左往右延伸的最常回文（可以以i为中心，或者以i以及i+1为中心）
	public String longestPalindrome(String s){
		if (s == null || s.length() == 0) {
			return "";
		}
		int len = s.length();
		String result = s.substring(0, 1);
		int max = 1;
		for (int i = 0; i < len - 1; i++) {
			String s1 = getLongest(s, i, i); // 以i为中心的延伸
			String s2 = getLongest(s, i, i + 1); // 以i和i+1为中心的延伸
			if (s1.length() > max) {
				max = s1.length(); // 勿忘更新max
				result = s1;
			}
			if (s2.length() > max) {
				max = s2.length();
				result = s2;
			}
		}
		return result;
	}
	
	private String getLongest(String s, int left, int right) {
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			} else {
				break;
			}
		}
		return s.substring(left + 1, right); //【注】因为left和right都往外多走了，最后要往回走1步
	}
}
