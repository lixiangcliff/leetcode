package Rotate_String;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 怀疑testcase有问题：
	 * Input
		"abccba", 3
		Output
		"baabcc"
		Expected
		"cbaabc"
	 */
    String rotateString(String A, int offset) {
        // wirte your code here
    	String left = reverse(A, 0, offset);
    	String right = reverse(A, offset + 1, A.length() - 1);
    	String str = left + right;
    	return reverse(str, 0, A.length() - 1);
    }
    
    private String reverse (String str, int start, int end) {
    	if (start < 0 || end > str.length() - 1){
    		return "";
    	}
    	StringBuilder sb = new StringBuilder();
    	for (int i = str.length() - 1; i>= 0; i--){
    		sb.append(str.charAt(i));
    	}
    	return sb.toString();
    }
}
