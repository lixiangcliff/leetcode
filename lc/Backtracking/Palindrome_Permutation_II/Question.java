package Palindrome_Permutation_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		
		
		long startTime = System.currentTimeMillis();
		
		
		String s = "aabbccddeeffgghhiijj";
		List<String> res = q.generatePalindromes(s);
/*		for (int j = 0; j < res.size(); j++) {
			System.out.println(res.get(j));
		}*/
		
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
	}
	
	/**
	 * Given a string s, return all the palindromic permutations (without duplicates) of it. 
	 * Return an empty list if no palindromic permutation could be form.
		For example:
		
		Given s = "aabb", return ["abba", "baab"].
		Given s = "abc", return [].
		
		Hint:
		If a palindromic permutation exists, we just need to generate the first half of the string.
		To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
	 */
	
	//https://leetcode.com/discuss/53613/my-accepted-java-solution
	//http://likesky3.iteye.com/blog/2238818
	public List<String> generatePalindromes(String s) { 
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() < 1) {
			return res;
		}
		int[] map = new int[256];
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
		}
		int oddCnt = 0;
		int oddIdx = -1;
		for (int i = 0; i < map.length; i++) {
			if (map[i] % 2  == 1 && oddCnt == 0) {
				oddCnt++;
				oddIdx = i;
			} else if (map[i] % 2 == 1){ // more than one char appear odd times, so s is not palindrome
				return new ArrayList<String>();
			}
		}
		StringBuilder item = new StringBuilder();
		if (oddIdx != -1) {
			item.append((char)oddIdx);
			map[oddIdx]--;
		}
		int len = s.length();
		helper(res, item, map, len);
		return res;
	}
	
	private void helper(List<String> res, StringBuilder item, int[] map, int len) {
		if (item.length() == len) {
			res.add(new String(item));
		}
		for (int i = 0; i < map.length; i++) {
			if (map[i] !=  0) {
				item.insert(0, (char)i);
				item.append((char)i);
				map[i] -= 2;
				helper(res, item, map, len);
				map[i] += 2;
				item.deleteCharAt(0);
				item.deleteCharAt(item.length() - 1);
			}
		}
	}
}
