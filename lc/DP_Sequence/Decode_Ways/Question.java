package Decode_Ways;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12";
		System.out.println(numDecodings(s));
	}

	/**
	 * https://oj.leetcode.com/problems/decode-ways/
	 * A message containing letters from A-Z is being encoded to numbers using
	 * the following mapping:
	 * 
	 * 'A' -> 1 
	 * 'B' -> 2 
	 * ... 
	 * 'Z' -> 26 
	 * 
	 * Given an encoded message containing digits, 
	 * determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", 
	 * it could be decoded as "AB" (1 2) or "L" (12).
	 * The number of ways decoding "12" is 2.
	 */
	//http://blog.csdn.net/linhuanmars/article/details/24570759
	/*
	 * res[i]是表示前i个数字有多少种解析的方式，递归式有两种方式:
	 * 1.新加进来的数字自己比较表示一个字符，那解析的方式有res[i-1]种；
	 * 2.新加进来的数字和前一个数字凑成一个字符，解析的方式有res[i-2]种（因为上一个字符和自己凑成了一个）。
	 * 第i-1位+第i位结果有以下四种情况：
	 *  （1）00：res[i]=0（无法解析，没有可行解析方式）；
		（2）10, 20：res[i]=res[i-2]（只有第二种情况成立）；
		（3）11-19, 21-26：res[i]=res[i-1]+res[i-2]（两种情况都可行）；
		（4）01-09, 27-99：res[i]=res[i-1]（只有第一种情况可行）；
	 *	因为res[i]只需要res[i-1]和res[i-2]的值，所以可以将数组变为三个interger，使空间复杂度从O(n)变为O(1)
	 */
	public static int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		int pre2 = 1;
		int pre1 = 1;
		int cur = 1;
		// use pre2 and pre to update cur
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') { //10,20
					cur = pre2;
				} else {	//00,30,40...90
					return 0;
				}
			} else {
				if (s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3') { //01,02...09; 30,31,32...97,98,99;
					cur = pre1;
				} else {
					if (s.charAt(i - 1) == '2' && s.charAt(i) >= '7' && s.charAt(i) <= '9'  ) { //27~29
						cur = pre1;
					} else {
						cur = pre1 + pre2; //11-19; 21-26
					}
				}
			}
			pre2 = pre1; //pre值覆盖pre2值
			pre1 = cur; //cur值覆盖pre
		}
		return cur;
	}
}
