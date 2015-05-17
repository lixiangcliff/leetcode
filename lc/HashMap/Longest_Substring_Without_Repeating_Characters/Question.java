package Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.HashSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "aab";
		System.out.println(q.lengthOfLongestSubstring(s));
	}
	
	/**
	 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3. For
	 * "bbbbb" the longest substring is "b", with the length of 1.
	 */
	
	//手写
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashSet<Character> set = new HashSet<Character>();
		int maxLen = 1;
		int l = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) { 
				while (l < i && set.contains(c)) {
					set.remove(s.charAt(l));
					l++;
				}
			} 
			set.add(c);
			maxLen = Math.max(maxLen, i - l + 1);
		}
		return maxLen;
	}
	
	// http://www.cnblogs.com/yuzhangcmu/p/4188973.html
	// 思想：hashmap和two pointer的结合。维护一个HashMap, <元素值， 元素index>。
	// 只要还没有出现重复则持续移动右窗口，并把;
	// 如果发现重复字符（设为c），则通过HashMap找到第一次出现c的位置(设为idx)，更新l为idx + 1；同时新HashMap：<c, r>。
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int l = 0;
		for (int r = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			if (map.containsKey(c) && map.get(c) >= l) { //【注】如果map.get(c)<l，说明该c的index已经在左窗口的左边了，是无效的
				l = map.get(c) + 1;
			} 
			map.put(c, r); // 更新c最新出现的位置
			max = Math.max(max, r - l + 1);
		}
		return max;
	}

}
