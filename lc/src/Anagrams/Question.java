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

		
	}
	
	//Question is asking to return all strings that has anagrams from the String[] 
	//http://blog.csdn.net/linhuanmars/article/details/21664747
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0){
			return result;
		}
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(int i=0; i<strs.length;i++){
			char[] charArray =  strs[i].toCharArray();
			Arrays.sort(charArray);
			//String strKey = charArray.toString(); // wrong! need to new a String 
			String strKey = new String(charArray);  
			if(map.containsKey(strKey)){
				map.get(strKey).add(strs[i]);
			}else{
				ArrayList<String> oneAnagram = new ArrayList<String>();
				oneAnagram.add(strs[i]);
				map.put(strKey, oneAnagram);
			}
		}
		Iterator<ArrayList<String>> it = map.values().iterator();
		while(it.hasNext()){
			ArrayList<String> item = (ArrayList<String>)it.next();
			if(item.size() > 1){ // has at least one anagram
				result.addAll(item);
			}
		}
		return result;
	}

}
