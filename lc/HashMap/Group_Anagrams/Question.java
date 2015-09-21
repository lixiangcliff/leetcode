package Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
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
		String s1 = "abcd";
		String s2 = "acbd";
		String s3 = "bcad";
		String s4 = "acb";
		String s5 = "abc";
		String s6 = "abd";
		String s7 = "abdc";
		String s8 = "ac";
		//ArrayList<String> result = new ArrayList<String>();
		String[] strs = {s1,s2,s3,s4,s5,s6,s7,s8};

		q.groupAnagrams(strs);
		char[] charArray = {'h','e','l','l','o'};
		//System.out.println(new String(charArray));
		System.out.println(charArray.toString());
	}
	
	/**
	 * https://leetcode.com/problems/anagrams/
	 * Given an array of strings, group anagrams together.
		For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
		Return:
		[
		  ["ate", "eat","tea"],
		  ["nat","tan"],
		  ["bat"]
		]
		Note:
		For the return value, each inner list's elements must follow the lexicographic order.
		All inputs will be in lower-case.
	 */
	
	//要把题意理清：就是说返回结果里，可能有若干组，每组都是anagrams。但是这些组都放在一个ArrayList<String>返回
	//举个例子：Input:	["tea","and","ate","eat","dan","abc","edf"]
	//	      Output:	["and","dan","tea","ate","eat"] （即前两个和后三个分别是anagrams）
	// http://www.cnblogs.com/yuzhangcmu/p/4067507.html
	// http://blog.csdn.net/linhuanmars/article/details/21664747
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0) {
			return result;
		}
		//技巧：建立一个hashmap，然后对每一个字符串内部字符排序，key是排序后的串，而value是所有属于这个key类的字符串
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			//【注】String strKey = charArray.toString(); // 这样写错误。因为通常toString()返回getClass().getName() + '@' + Integer.toHexString(hashCode())，
			//只有StringBuilder的toString()返回的是string
			String strKey = new String(charArray); 
			if (map.containsKey(strKey)) {// map里已经有按这个以sorted string值为key的键值对了
				map.get(strKey).add(strs[i]);// 把当前string加到这个value的list里
			} else {// 还没有这个key，要新造键值对
				ArrayList<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(strKey, list);
			}
		}
		// 【注】要记住遍历map的方法
		for (Map.Entry<String, ArrayList<String>> entry: map.entrySet()) {
			ArrayList<String> list = entry.getValue();
            Collections.sort(list);
            result.add(list);
        }
		return result;
	}
}
