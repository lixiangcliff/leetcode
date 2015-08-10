package Isomorphic_Strings;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * https://leetcode.com/problems/isomorphic-strings/
	 * Given two strings s and t, determine if they are isomorphic.
	 * Two strings are isomorphic if the characters in s can be replaced to get t.
	 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
	 * No two characters may map to the same character but a character may map to itself.
	 * For example,
		Given "egg", "add", return true.
		
		Given "foo", "bar", return false.
		
		Given "paper", "title", return true.
		
		Note:
		You may assume both s and t have the same length.
	 */
	
	//手写，更好理解
    public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null || s.length() == 0 && t.length() == 0) {
			return true;
		}
		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char achar = s.charAt(i);
			char bchar = t.charAt(i);
			if (map1.containsKey(achar)) {
			    if (map1.get(achar) != bchar) {
			        return false;
			    }
			} else {
			    map1.put(achar, bchar);
			}
			if (map2.containsKey(bchar)) {
			    if (map2.get(bchar) != achar) {
			        return false;
			    }
			} else {
			    map2.put(bchar, achar);
			}
			
		}
		return true;
    }
	
	//same as fgdsb
	public boolean isIsomorphic2(String s, String t) {
		if (s == null && t == null || s.length() == 0 && t.length() == 0) {
			return true;
		}
		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char achar = s.charAt(i);
			char bchar = t.charAt(i);
			if (!map1.containsKey(achar) && !map2.containsKey(bchar)) {
				map1.put(achar, bchar);
				map2.put(bchar, achar);
			} else if (map1.containsKey(achar) && !map2.containsKey(bchar)
					|| !map1.containsKey(achar) && map2.containsKey(bchar)) {
				return false;
			} else {
				if (achar != map2.get(bchar) || bchar != map1.get(achar)) {
					return false;
				}
			}
		}
		return true;
	}
}
