package Word_Break;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		String s = "abcd";
		String s1 = "a";
		String s2 = "abc";
		String s3 = "b";
		String s4 = "cd";*/
		String s = "leetcode";
		String s1 = "leet";
		String s2 = "code";
		String s3 = "ab";
		String s4 = "cd";
		
	/*	Set<String> dict = null;
		dict.add(s1);
		dict.add(s2);
		dict.add(s3);
		dict.add(s4);*/
		
		String elements[] = { s1,s2,s3,s4};
		Set<String> dict = new HashSet(Arrays.asList(elements));
/*		System.out.println(dict.contains("e"));
		StringBuilder str = new StringBuilder(s.substring(0,1+1));
		System.out.println("before:" + str.toString());
		str.deleteCharAt(0);
		System.out.println("after:" + str.toString());*/
		//System.out.println(wordBreak(s, dict));
		
	}
	
	/**
	 * https://oj.leetcode.com/problems/word-break/
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given 
	 * s = "leetcode", 
	 * dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */
	
	//http://www.ninechapter.com/solutions/word-break/
	//很类似https://oj.leetcode.com/problems/palindrome-partitioning-ii/
	//1.state: result[i]代表直到前i个字符，能否被完美切分
	//2.function: 则result[i] = OR(result[j]; 前提是j<i && 从j+1到i是字典中的一个单词)
	//(即只要存在任何小于i的j， result[j]为真，并且从j+1到i也为字典中的一个单词，则返回true)
	//3.initialize: result[0] = true
	//4.answer: result[s.length]
	//【注】result[]和s有一位的位差。
	//这是由于s的首个index为0.而result中 有实际意义的“首个”，表示直到前1个字符，能否被完美切分
	//即，result[1]要去s.charAt(0)上对应“查看”；result[i]要去s.charAt(i-1)上对应“查看”。
	
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int maxLength = getWordMaxLength(dict);
		boolean result[] = new boolean[s.length() + 1];
		result[0] = true;
		//整个两重循环的i，j边界取值，都以result[]为准，当涉及到s的时候，再考虑减一的位差
		for (int i = 1; i <= s.length(); i++) {
			result[i] = false;
			//【注】技巧，j从i的左边一个往左走，节省时间。
			for (int j = i - 1; i - j <= maxLength && j >= 0; j--) { //i-j为当前word的长度
				if (!result[j]) { //前j个不能完美分切，则整个j不行，换下一个j
					continue;
				}
				//走到这一步 说明s中的前j个字符可以完美分切
				//result从j+1位到i位的substring对应到s中，即为j位到i-1位（因为s和res[]有一个的位差）。看图可知
				String word = s.substring(j, i); 
				if (dict.contains(word)) {
					result[i] = true;
					break;
				}
			}
		}
		return result[s.length()];
	}
	
	//【注】技巧，切分位置枚举，只需probe最长单词的长度就可以停止了。
	private int getWordMaxLength(Set<String> dict) {
		int max = -1;
		for (String word : dict) {
			max = Math.max(max, word.length());
		}
		return max;
	}

}
