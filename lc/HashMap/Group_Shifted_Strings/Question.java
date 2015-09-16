 package Group_Shifted_Strings;

import java.util.ArrayList;
import java.util.Collections;
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
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> result = q.groupStrings(strings);
		for (List<String> item : result) {
			for (String i : item) {
				System.out.print(i + ",");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Given a string, we can “shift” each of its letter to its successive letter, for example: “abc” -> “bcd”. We can keep “shifting” which forms the sequence:
		"abc" -> "bcd" -> ... -> "xyz"
		Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
		For example,
		given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:
		
		[
		  ["abc","bcd","xyz"],
		  ["az","ba"],
		  ["acef"],
		  ["a","z"]
		]
		Note: For the return value, each inner list’s elements must follow the lexicographic order.
	 */
	
	//https://leetcode.com/discuss/50358/my-concise-java-solution
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strings) {
			String str1 = getShiftedStr(str);
			if (map.containsKey(str1)) {
				map.get(str1).add(str);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(str);
				map.put(str1, list);
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) { //遍历map，背诵！！！
			String key = entry.getKey();
			ArrayList<String> list = map.get(key);
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
	
	private String getShiftedStr(String str) {
		if (str == null || str == "") {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append('a');
		int diff = str.charAt(0) - 'a';
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);
			char c1 = (char)(c - diff) < 'a' ? (char)('a' + 26 - diff) : (char)(c - diff);
			sb.append(c1);
		}
		return sb.toString();
	}

}
