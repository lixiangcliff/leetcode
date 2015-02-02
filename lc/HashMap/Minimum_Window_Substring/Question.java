package Minimum_Window_Substring;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.minWindow("ADOBECODEBANC", "ABC"));
	}
	
	/**
	 * https://oj.leetcode.com/problems/minimum-window-substring/
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, 
	 * S = "ADOBECODEBANC" 
	 * T = "ABC" 
	 * Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the emtpy string "".
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 */
	
	//类似：Longest_Substring_Without_Repeating_Characters 
	//【注】 此题中T中的char顺序无所谓，所以这道题就排除了用DP的可能
	//http://blog.csdn.net/linhuanmars/article/details/20343903
	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0) {
			return "";
		}
		// T中的char装入map
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int l = 0;
		// 分别用minStart和minLen来记录所求string的起始位置和长度
		int minStart = 0;
		int minLen = S.length() + 1;
		int count = 0;// T中的char在当前窗口中已经出现的次数
		// 此题相比于“Substring with Concatenation of All Words”，之所以不需要维护curMap：
		// 是因为，当前窗口里可以有多余的（不是T中的）char，即不需要和map中的char种类和数量上严格对应
		// 在下面code中，根据窗口中含有T中的char的情况来更新map。
		// 具体来说就是：【注】map里放置的是窗口里不包含的char及其个数
		// 所以每次右窗口右移并且纳入了T中含有的char时，就从map中减小该char的个数
		// 而每次左窗口右移并且剔除了T中含有的char时，就从map中增加该char的个数
		for (int r = 0; r < S.length(); r++) {
			char rc = S.charAt(r);
			if (map.containsKey(rc)) {
				map.put(rc, map.get(rc) - 1);
				if (map.get(rc) >= 0) { //若map.get(rc)<0,则值为rc的char在T中早已经被拿空了，所以在S中即使遇到了rc，count的数目也不该增加！
					count++;
				}
				while (count == T.length()) { // 只要当前窗口(from l to r) 还能包涵所有T中的char（就右移left来试图尽量减小窗口长度）
					if (r - l + 1 < minLen) {
						minLen = r - 1 + 1; // 更新minLen
						minStart = l;
					}
					char lc = S.charAt(l); // 左窗口右移，来剔除当前字符lc
					if (map.containsKey(lc)) { // 如果lc存在于原来的map里，说明把它剔除之后，窗口里就不能包涵所有T中的char了，此层循环也就可以跳出了
						// 把剔除的char重新加回map（或者说+1）
						map.put(lc, map.get(lc) + 1);
						// 确认map中已经有sLeftChar
						if (map.get(lc) > 0) {
							count--;
						}
					}
					l++;// left右移
				}
			}
		}
		return minLen == S.length() + 1 ? "" : S.substring(minStart, minStart + minLen); //若 minLen到最后还是S.length()+1，说明S中不含有满足题意的窗口
	}
    

}
