package Rotate_String;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * http://lintcode.com/en/problem/rotate-string/
	 * Given a string and an offset, rotate string by offset. (rotate from left to right)
		Example
		Given "abcdefg"
		for offset=0, return "abcdefg"
		for offset=1, return "gabcdef"
		for offset=2, return "fgabcde"
		for offset=3, return "efgabcd"
	 */
	
	//【注】index vs offset: index是从前往后的第几位；offset表示往右挪的位数
	public char[] rotateString(char[] A, int offset) {
		if (A == null || A.length == 0 || offset % A.length == 0) {
			return A;
		}
		int len = A.length;
		offset %= len; // 【注】此处要取模，因为要防止给的offset比len还大。
		reverse(A, 0, len - 1 - offset); 
		reverse(A, len - offset, len - 1);
		reverse(A, 0, len - 1);
		return A;
	}

	private void reverse(char[] A, int l, int r) {
		while (l < r) {
			char temp = A[l];
			A[l] = A[r];
			A[r] = temp;
			l++;
			r--;
		}
	}
}
