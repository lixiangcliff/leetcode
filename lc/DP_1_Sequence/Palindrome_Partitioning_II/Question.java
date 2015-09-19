package Palindrome_Partitioning_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "a";
		System.out.println(q.minCut(s));
	}
	/**
	 * https://oj.leetcode.com/problems/palindrome-partitioning-ii/
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * Return the minimum cuts needed for a palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return 1 
	 * since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
	 */
	
	//http://www.ninechapter.com/solutions/palindrome-partitioning-ii/
	//1.state: result[i]代表直到前i个字符，最少需要几次cut
	//2.function: 则result[i] = min(result[j]+1);(j范围[0,i) && 从j+1到i是palindrome)
	//(之所以有result[j]+1，是因为当我们已经得到result[j]的值，如果isPalindrome[j+1][i]也为真，即有再在j和j+1之间cut一次，就可以得到result[i])
	//3.initialize: result[i] = i - 1（比如，result[1] = 0，即如果只有一个字符，根本不需要cut就是palindrome了）
	//4.answer: result[A.length]
	//O(n^2)时间复杂度
	//有位差：源数据(isPalindrome)要比结果result少1
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
            return 0;
        }
		int len = s.length();
		boolean[][] isPalindrome = getIsPalindrome(s);
		int[] result = new int[len + 1];
		result[0] = -1; // 初始化必须从result[0]开始，因为后面计算result[1]要用到result[0]
		for (int i = 2; i <= len; i++) {
			result[i] = i - 1;
			for (int j = i - 1; j >= 0; j--) {
				if (isPalindrome[j][i - 1]) { //看图。位差导致：是isPalindrome[j][i - 1]，而不是isPalindrome[j + 1][i]
					result[i] = Math.min(result[i], result[j] + 1);
				}
			}
		}
		return result[len];
	}
	 
	//isPalindrome[i][j]表示从在字符串s中，从i到j是不是palindrome
	//此矩阵只有右上三角为有效数据，具体看图。
	private boolean[][]	getIsPalindrome(String s) {
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];
		//【注】需要从最底层往最顶层计算，因为等号右边的isPalindrome[i + 1][j - 1]在所求的isPalindrome[i][j]的下方。
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j <= len - 1; j++) {
				if (j == i) { //初始化对角线
					isPalindrome[i][j] = true;
				} else if (j == i + 1) { //初始化对角线右边一个
					isPalindrome[i][j] = s.charAt(i) == s.charAt(i + 1);
				} else { //推导右上三角剩余数据
					isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
				}
			}
		}
		return isPalindrome;
	}
}
