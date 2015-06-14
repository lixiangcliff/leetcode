package Shortest_Palindrome;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "abcd";
		System.out.println(q.shortestPalindrome(s));
	}
	
	/**
	 * 
	 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
	 * Find and return the shortest palindrome you can find by performing this transformation.
	 * 
	 * For example:
	 * Given "aacecaaa", return "aaacecaaa".
	 * Given "abcd", return "dcbabcd".
	 */
	
	
	//O(n^2) time complex. and will not pass large test case
    public String shortestPalindrome(String s) {
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
    	int left = 0;
    	int right = s.length() - 1;
    	while (left < right) {
    		if (isPal(s.substring(0,  right + 1), 0, right)) {
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
    
    private boolean isPal(String str, int l, int r) {
    	while (l < r) {
    		if (str.charAt(l++) != str.charAt(r--)) {
    			return false;
    		}
    	}
    	return true;
    }

}
