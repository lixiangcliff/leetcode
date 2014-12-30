package Longest_Palindromic_Substring;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "abcdefgfedcba";
		//String s = "abba";
		//String s = "aa";
		//String s = "a";
		System.out.println(q.longestPalindrome(s));
	}
	
	/**
	 * https://oj.leetcode.com/problems/longest-palindromic-substring/
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 */

	//DP
	//基本采用Palindrome_Partitioning_II的子函数getIsPalindrome(String s)
	//1.state: isPalindrome[i][j]代表s中从第i个char到第j个char是否为palindrome
	//2.function: isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
	//(之所以有result[j]+1，是因为当我们已经得到result[j]的值，如果isPalindrome[j+1][i]也为真，即有再在j和j+1之间cut一次，就可以得到result[i])
	//3.initialize: isPalindrome[i][i] = true; （i = 0 ~ s.length() - 2）(对角线)
	//				isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1) （i = 0 ~ s.length() - 2）(对角线右边一个)
	//4.answer: 所有isPalindrome[i][j]为true中的j-i值最大的那一个，返回s.substring(i, j + 1)
	//O(n^2)时间复杂度, O(n^2)空间复杂度
	//http://blog.csdn.net/linhuanmars/article/details/20888595
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String result = s.substring(0, 1);
		int maxLen = 1;
		int len = s.length();
		//此矩阵只有右上三角为有效数据。
		boolean[][] isPalindrome = new boolean[len][len];
		//【注】需要从最底层往最顶层计算，因为等号右边的isPalindrome[i + 1][j - 1]在所求的isPalindrome[i][j]的下方。
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (j == i) { //初始化对角线
					isPalindrome[i][j] = true;
				} else if (j == i + 1) { //初始化对角线右边一个
					isPalindrome[i][j] = s.charAt(i) == s.charAt(i + 1);
				} else {
					isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
				}
				if (isPalindrome[i][j] && j - i + 1 > maxLen) { // 从i到j是palindrome，并且i到j的长度比maxLen更长
					maxLen = j - i + 1;
					result = s.substring(i, j + 1);
				}
			}
		}
		return result;
	 }
}
