package Shortest_Palindrome;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "aacecaaa";
		System.out.println(q.shortestPalindrome(s));
	}
	
	/**
	 * https://leetcode.com/problems/shortest-palindrome/
	 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
	 * Find and return the shortest palindrome you can find by performing this transformation.
	 * 
	 * For example:
	 * Given "aacecaaa", return "aaacecaaa".
	 * Given "abcd", return "dcbabcd".
	 */
	
	//仍未理解 may ask Zhe
	// https://leetcode.com/discuss/51223/my-7-lines-recursive-java-solution
	public String shortestPalindrome(String s) {
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == s.charAt(j)) {
				j++;
			}
		}
		if (j == s.length()) {
			return s;
		}
		String suffix = s.substring(j);
		return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
	}
	
	//try not to use kmp to pass the oj...
	
	//O(n^2) time complex. and will not pass large test case
    public String shortestPalindrome2(String s) {
    	if (s == null || s.length() <= 1) {
    		return s;
    	}
    	//超级无聊的test case
    	char c = s.charAt(0);
    	boolean allSame = true;
    	for (int i = 1; i < s.length(); i++) {
    		if (s.charAt(i) != c) {
    			allSame = false;
    			break;
    		}
    	}
    	if (allSame) {
    		return s;
    	}
    	//end boring test case
    	//int left = 0;
    	int right = s.length() - 1;
    	boolean isPal[][] = getIsPalindrome(s);
    	while (right > 0) {
    		if (isPal[0][right]) {
    			break;
    		}
    		right--;
    	}
    	StringBuilder sb = new StringBuilder();
    	int idx = s.length() - 1;
    	while (idx > right) {
    		sb.append(s.charAt(idx--));
    	}
    	sb.append(s);
    	return sb.toString();
    }
    
    //MLE
	private boolean[][]	getIsPalindrome(String s) {
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];
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
    
    /*private boolean isPal(String str, int l, int r) {
    	while (l < r) {
    		if (str.charAt(l++) != str.charAt(r--)) {
    			return false;
    		}
    	}
    	return true;
    }*/

}
