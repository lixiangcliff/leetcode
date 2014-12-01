package Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		anagrams(strs);
		char[] charArray = {'h','e','l','l','o'};
		//System.out.println(new String(charArray));
		System.out.println(charArray.toString());
	}
	
	/**
	 * https://oj.leetcode.com/problems/anagrams/
	 * Given an array of strings, return all groups of strings that are
	 * anagrams.
	 * 
	 * Note: All inputs will be in lower-case.
	 */
	//Question is asking to return all (group of) strings that has anagrams from the String[] 
	//要把题意理清
	//就是说返回结果里，可能有若干组，每组都是anagrams。但是这些组都放在一个ArrayList<String>返回
	//举个例子：Input:	["tea","and","ate","eat","dan","abc","edf"]
	//	      Output:	["and","dan","tea","ate","eat"]
	//http://blog.csdn.net/linhuanmars/article/details/21664747
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0){
			return result;
		}
		//技巧：建立一个hashmap，然后对每一个字符串排序，key是排序后的串，而value是所有属于这个key类的字符串
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(int i=0; i<strs.length;i++){
			char[] charArray =  strs[i].toCharArray();
			Arrays.sort(charArray);
			//String strKey = charArray.toString(); // 为什么要new一个string出来 ？
			/*
			 * 回答上面问题：
			 * https://docs.oracle.com/javase/6/docs/api/java/lang/Object.html#toString()
			 * "Usually toString() only returns
					getClass().getName() + '@' + Integer.toHexString(hashCode())"
			 * https://community.oracle.com/message/8737123
			 */
			String strKey = new String(charArray); //要用这种构造函数来用char[]来构造string 
			if(map.containsKey(strKey)){//map里已经有按这个以sorted string值为key的pair了
				map.get(strKey).add(strs[i]);//把当前string加到这个value的list里
			}else{//还没有这个key，要新造pair
				ArrayList<String> sortedItem = new ArrayList<String>();
				sortedItem.add(strs[i]);
				map.put(strKey, sortedItem);
			}
		}
		//通过map的value来create这个iterator，或者说要遍历这个list的value
		Iterator<ArrayList<String>> it = map.values().iterator();
		while(it.hasNext()){
			ArrayList<String> item = (ArrayList<String>)it.next();
			if(item.size() > 1){ // 只要anagram个数大于1，就加入结果的ArrayList中
				result.addAll(item);
			}
		}
		return result;
	}

}
