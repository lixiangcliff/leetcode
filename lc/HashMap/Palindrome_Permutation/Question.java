package Palindrome_Permutation;

import java.util.HashMap;
import java.util.Map;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "carerac";
		System.out.println(q.canPermutePalindrome(s));
	}

	/**
	 * Given a string, determine if a permutation of the string could form a palindrome.
		For example,
		"code" -> False, "aab" -> True, "carerac" -> True.
		
		Hint:
		
		1.Consider the palindromes of odd vs even length. What difference do you notice?
		2.Count the frequency of each character.
		3.If each character occurs even number of times, then it must be a palindrome. 
		How about character which occurs odd number of times?
	 */
	
	//http://www.cnblogs.com/jcliBlogger/p/4748554.html
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = map.containsKey(c) ? map.get(c) + 1 : 1;
			map.put(c, count);
		}
		int oddCount = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			int val = entry.getValue();
			oddCount += val % 2 == 1 ? 1 : 0;
			if (oddCount > 1) {
				return false;
			}
		}
		return true;
	}
}
