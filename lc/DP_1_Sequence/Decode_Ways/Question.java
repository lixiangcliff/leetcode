package Decode_Ways;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String s = "123412";
		System.out.println(q.numDecodings(s));
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
	
	// http://www.cnblogs.com/yuzhangcmu/p/4115490.html
	// 1.state: res[i]是表示前i个数字有多少种解析的方式，递归式有两种方式:
	// 2.function: 1.)新加进来的数字自己表示一个字符，那解析的方式有res[i-1]种；
	// 			   2.)新加进来的数字和前一个数字凑成一个字符，解析的方式有res[i-2]种（因为上一个字符和自己凑成了一个）。
	// 			   3.)把上面两种情况加和起来就得到了res[i]
	// 3.initialize: res[0] = 1
	// 4. result: res[s.length()]
	// 【注】 res和s有位差
	// 因为res[i]只需要res[i-1]和res[i-2]的值，所以可以将数组变为三个interger，使空间复杂度从O(n)变为O(1)
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') { //s.charAt(0) == '0'，排出了第一位就是'0'的情况
			return 0;
		}
		int[] result = new int[s.length() + 1];
		result[0] = 1; // 【注】当s为空，decode way有一种，即"空"
		result[1] = 1;
		for (int i = 2; i <= s.length(); i++) {
			if (isValid(s.substring(i - 1, i))) { // 位差，举例。检查当前位是合法
				result[i] += result[i - 1];
			}
			if (isValid(s.substring(i - 2, i))) { // 位差，举例。检查前一位加上当前位是否合法
				result[i] += result[i - 2];
			}
			if (result[i] == 0) {
				return 0;
			}
		}
		return result[s.length()];
	}
	
	private boolean isValid(String s) {
		if (s == null || s.length() < 1 || s.length() > 2) {
			return false;
		}
		if (s.length() == 1) {
			return !s.equals("0");
		} else {
			int value = Integer.parseInt(s);
			return (value >= 10 && value <= 26);
		}
	}
}
