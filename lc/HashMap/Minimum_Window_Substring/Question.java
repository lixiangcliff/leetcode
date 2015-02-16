package Minimum_Window_Substring;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.minWindow("AOBECDEBANC", "ABC"));
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
	
	//【注】 此题中T中的char顺序无所谓，所以这道题就排除了用DP的可能。此题是Two pointer和Hashmap的结合。
	//http://blog.csdn.net/linhuanmars/article/details/20343903
	//http://huntfor.iteye.com/blog/2083485
	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0) {
			return "";
		}
		HashMap<Character, Integer> srcMap = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) { // T中的char装入map
			char c = T.charAt(i);
			if (srcMap.containsKey(c)) {
				srcMap.put(c, srcMap.get(c) + 1);
			} else {
				srcMap.put(c, 1);
			}
		}
		int l = 0;
		int minStart = 0; // 所求string的起始位置
		int minLen = S.length() + 1; // 所求string的长度
		int cntInCurWin = 0;// T中的char在当前窗口中已经出现的次数
		HashMap<Character, Integer> curMap = new HashMap<Character, Integer>();
		for (int r = 0; r < S.length(); r++) {
			char charR = S.charAt(r);
			if (srcMap.containsKey(charR)) { // 右边找到一个char是在srcMap中的
				if (!curMap.containsKey(charR)) { // 【注】无论charR在curMap中的个数是不是已经超过了它在srcMap中的个数，都要在curMap中累计
					curMap.put(charR, 1);
				} else {
					curMap.put(charR, curMap.get(charR) + 1);
				}
				if (curMap.get(charR) <= srcMap.get(charR)) { // 【注】只有curMap中charR的个数仍然小于等于srcMap中charR
					cntInCurWin++;
				}
				while (cntInCurWin == T.length()) { // curMap已经和srcMap的内容一样了，说明当前窗口已经cover了T中所有内容，接下来要右移l，使窗口尽量小
					if (r - l + 1 < minLen) { // 如果当前窗口是更小的合法窗口
						minLen = r - l + 1;
						minStart = l;
					}
					char charL = S.charAt(l);
					if (srcMap.containsKey(charL)) { // 如果当前charL存在于srcMap中
						curMap.put(charL, curMap.get(charL) - 1);
						if (curMap.get(charL) < srcMap.get(charL)) { // 如果减小当前charL个数的结果，真的导致	curMap里对应的个数小于srcMap中的个数
							cntInCurWin--;
						}
					}
					l++; // 右移l
				}
			}
		}
		return minLen == S.length() + 1 ? "" : S.substring(minStart, minStart + minLen); //若 minLen到最后还是S.length()+1，说明S中不含有满足题意的窗口
	}
}
