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
    	int val = 0;
    	for (int i = 0; i < 10; i++) {
    		val = addValEnd(s, charMap, val, i);
    	}
    	HashMap<Integer, Integer> dnamMap = new HashMap<Integer, Integer>();
    	dnamMap.put(val, 1);
    	for (int i = 10; i < s.length(); i++) {
    		val &= ((int)Math.pow(2, 18) - 1);
    		val = addValEnd(s, charMap, val, i);
    		if (dnamMap.containsKey(val)) {
    			if (dnamMap.get(val) == 1) {
    				//根本不需要
    				/*String str = Integer.toBinaryString(val);
    				StringBuilder binSb = new StringBuilder(str);
    				while (binSb.length() < 20) {
    					binSb.insert(0, "0");
    				}
    				String binStr = binSb.toString();
    				StringBuilder sb = new StringBuilder();
    				for (int j = 0; j <= binStr.length() - 2; j += 2) {
    					String letter = binStr.substring(j, j + 2);
    					if (letter.equals("00")) {
    						sb.append("A");
    					} else if (letter.equals("01")) {
    						sb.append("C");
    					} else if (letter.equals("10")) {
    						sb.append("G");
    					} else if (letter.equals("11")) {
    						sb.append("T");
    					}
    				}
    				String curStr = sb.toString();*/
    				String curStr = s.substring(i - 9, i + 1);
    				res.add(curStr);
    				dnamMap.put(val, 2);
    			} else {
    				dnamMap.put(val, dnamMap.get(val) + 1);
    			}
    		} else {
    			dnamMap.put(val, 1);
    		}
    	}
    	return res;
    }

	private int addValEnd(String s, HashMap<Character, Integer> charMap, int val, int i) {
		int num = charMap.get(s.charAt(i));
		val <<= 1;
		val += (num / 2);
		val <<= 1;
		val += (num % 2);
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
