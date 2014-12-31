package Valid_Palindrome;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
//		String s = "A man, a plan, a canal: Panama";
//		String s = "race a car";
		String s = ".,";
		System.out.println(q.isPalindrome(s));
	}
	
	/**
	 * https://oj.leetcode.com/problems/valid-palindrome/
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */
	
	//左右两个指针往中间移动
	//http://www.cnblogs.com/yuzhangcmu/p/4194369.html
    public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
        s = s.trim();
        if (s.length() <= 1) {
        	return true;
        }
        int l = 0;
        int r = s.length()-1;
        s = s.toLowerCase(); // 都转为小写
        while (l < r) { // 每次只做下面四种操作中的一种，然后就再次重新判断l和r的关系，有效避免了越界
			if (!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {
				r--;
			} else if (s.charAt(l) != s.charAt(r)) {
				return false;
			} else {
				l++;
				r--;
			}
        }
        return true;
    }
}
