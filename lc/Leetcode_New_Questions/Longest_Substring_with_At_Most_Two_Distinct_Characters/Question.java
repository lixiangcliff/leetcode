package Longest_Substring_with_At_Most_Two_Distinct_Characters;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "eceba";
		System.out.println(q.lengthOfLongestSubstringTwoDistinct(s));
	}
	
	/**
	 * Given a string S, find the length of the longest substring T that contains at most two
		distinct characters.
		For example,
		Given S = “eceba”,
		T is "ece" which its length is 3.
	 */
	
	//leetcode cleancodehandbook
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		int l = 0;
		int r = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		while (r < s.length()) {
			char c = s.charAt(r);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			while (map.size() > 2) {
				char left = s.charAt(l);
				if (map.get(left) > 1) {
					map.put(left, map.get(left) - 1);
				} else if (map.get(left) == 1) {
					map.remove(left);
				}
				l++;
			}
			max = Math.max(max, r - l + 1);
			r++;
		}
		return max;
	}

}
