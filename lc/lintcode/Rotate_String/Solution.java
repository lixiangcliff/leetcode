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
	 * 【注】index vs offset
	 * index是从前往后数
	 * offset是从后往前数
	 */
    String rotateString(String A, int offset) {
        // wirte your code here
    	if (A == null || A.length() == 0){
    		return "";
    	}
    	String left = reverse(A, 0, A.length() - offset % A.length() - 1); //【注】此处要取模，因为要防止给的offset比length还大。
    	String right = reverse(A, A.length() - offset % A.length(), A.length() - 1);
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
