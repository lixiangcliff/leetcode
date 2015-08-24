package Largest_Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int num[] = {128, 12};
		System.out.println(q.largestNumber(num));

	}
	
	/**
	 * https://leetcode.com/problems/largest-number/
	 * Given a list of non negative integers, arrange them such that they form the largest number.
		For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
		Note: The result may be very large, so you need to return a string instead of an integer.
	 */
	
	//radix sorting
	public String largestNumber(int[] num) {
        Comparator<String> comp = new Comparator<String>(){
        	@Override
        	public int compare(String s1, String s2) {
        		if (s1 == null || s2 == null) {
        			return 0;
        		}
        		int len1 = s1.length();
        		int len2 = s2.length();
        		if (len1 == 0 && len2 == 0) {
        			return 0;
        		} else if (len1 == 0) {
        			return -1;
        		} else if (len2 == 0) {
        			return 1;
        		}
        		int i = 0;
        		String str1 = s1 + s2;
        		String str2 = s2 + s1;
        		while (i < str1.length()) {
        			if (str1.charAt(i) > str2.charAt(i)) {
        				return 1;
        			} else if (str1.charAt(i) < str2.charAt(i)) {
        				return -1;
        			}
        			i++;
        		}
        		return 0;
        		
        	}
        };
        ArrayList<String> strs = new ArrayList<String>(); //把原来的数组变成ArrayList，方便根据comp来sort
        boolean allZero = true;
        for (int d : num) {
        	if (d != 0) {
        		allZero = false;
        	}
        	strs.add(Integer.toString(d));
        }
        if (allZero) { // corner case 如果没有这个验证，如果输入全是0，返回结果就是"000...000"
        	return "0";
        }
        Collections.sort(strs, comp);
        StringBuilder sb = new StringBuilder();
        for(int i = strs.size() - 1; i >= 0; i--) {
        	sb.append(strs.get(i));
        }
        return sb.toString();
    }
}
