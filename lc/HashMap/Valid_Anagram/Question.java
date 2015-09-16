package Valid_Anagram;

import java.util.Arrays;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Given two strings s and t, write a function to determine if t is an anagram of s.

		For example,
		s = "anagram", t = "nagaram", return true.
		s = "rat", t = "car", return false.
		
		Note:
		You may assume the string contains only lowercase alphabets.
	 */
	//use hashmap
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
        	return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
        	return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int count = map.containsKey(c) ? map.get(c) + 1 : 1;
        	map.put(c, count);
        }
        for (int i = 0; i < t.length(); i++) {
        	char c = t.charAt(i);
        	if (map.containsKey(c) && map.get(c) > 0) {
        		map.put(c, map.get(c) - 1);
        		if (map.get(c) == 0) {
        			map.remove(c);
        		}
        	} else {
        		return false;
        	}
        }
        return true;
    }
    
    //use sort
    public boolean isAnagram2(String s, String t) {
        if (s == null && t == null) {
        	return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
        	return false;
        }
        char[] schar = s.toCharArray();
        Arrays.sort(schar);
        String sAngm = new String(schar);
        
        char[] tchar = t.toCharArray();
        Arrays.sort(tchar);
        String tAngm = new String(tchar);
        
        return sAngm.equals(tAngm);
    }
}
