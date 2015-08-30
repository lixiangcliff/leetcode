package Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		ArrayList<String> res = (ArrayList<String>) q.findRepeatedDnaSequences(s);
		for (String str : res) {
			System.out.println(str);
		}

	}
	
	/**
	 * https://leetcode.com/problems/repeated-dna-sequences/
	 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, 
	 * it is sometimes useful to identify repeated sequences within the DNA.
		Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
		
		For example,
		Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
		Return:["AAAAACCCCC", "CCCCCAAAAA"].
	 */
	
	//Zhe's method
	//【注】中心思想：每一个字母都用一个2位的二进制表示，则每一种单独的排列（10个字母），都可以表示成数值都不同20位的二进制数
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<String>();
    	if (s == null || s.length() <= 10) {
    		return res;
    	}
    	HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
    	charMap.put('A', 0);
    	charMap.put('C', 1);
    	charMap.put('G', 2);
    	charMap.put('T', 3);
    	int val = 0; //
    	for (int i = 0; i < 10; i++) {
    		val = addValEnd(s, charMap, val, i);
    	}
    	HashMap<Integer, Integer> dnaMap = new HashMap<Integer, Integer>(); // <10位dna的二进制表示值，该值出现过得次数>
    	dnaMap.put(val, 1);
    	for (int i = 10; i < s.length(); i++) {
    		val &= ((int)Math.pow(2, 18) - 1); //mask掉左边第一个字母表示的bin数值(留下右边九个)
    		val = addValEnd(s, charMap, val, i); //加上当前i位置的bin值
    		if (dnaMap.containsKey(val)) {
    			if (dnaMap.get(val) == 1) { //只在第二次遇到相同的时候才增加，保证在res中添加一次
    				String curStr = s.substring(i - 9, i + 1);
    				res.add(curStr);
    				dnaMap.put(val, 2);
    			} else { // 这步其实可有可无
    				dnaMap.put(val, dnaMap.get(val) + 1);
    			}
    		} else {
    			dnaMap.put(val, 1);
    		}
    	}
    	return res;
    }

    //add bin value from the end
	private int addValEnd(String s, HashMap<Character, Integer> charMap, int val, int i) { 
		int num = charMap.get(s.charAt(i));
		val <<= 2;
		val += num;
		return val;
	}
    
	//Memory Limit Exceeded
    public List<String> findRepeatedDnaSequences2(String s) {
    	List<String> res = new ArrayList<String>();
    	if (s == null || s.length() <= 10) {
    		return res;
    	}
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	for (int i = 0; i < s.length() - 9; i++) {
    		String cur = s.substring(i, i + 10);
    		if (map.containsKey(cur)) {
    			if (map.get(cur) == 1) {
    				res.add(cur);
    			} else {
    				map.put(cur, map.get(cur) + 1);
    			}
    		} else {
    			map.put(cur, 1);
    		}
    	}
    	return res;
    }
}
