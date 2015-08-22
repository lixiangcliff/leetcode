package Multiply_Strings;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String num1 = "9";
		String num2 = "9";
		System.out.println(q.multiply(num1, num2));

	}
	
	/**
	 * https://oj.leetcode.com/problems/multiply-strings/
	 * Given two numbers represented as strings, return multiplication of the
	 * numbers as a string.
	 * 
	 * Note: The numbers can be arbitrarily large and are non-negative.
	 */

	//http://www.cnblogs.com/yuzhangcmu/p/4116211.html
    public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
			return "";
		}
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
			return "0";
		}
		int len1 = num1.length();
		int len2 = num2.length();
		int[] product = new int[len1 + len2]; // 【注】 技巧是用一个数组存每一位的product的和，这样即使在该位的累计超过9，之后仍可以用进位的方式处理
		for (int i = 0; i < len1; i++) { // 计算相应位置的product.
			for (int j = 0; j < len2; j++) { // 边界画图举例。
				product[i + j + 1] += (int) (num1.charAt(i) - '0') * (int) (num2.charAt(j) - '0'); // 积累每一位乘积的和
			}
		}
		StringBuilder result = new StringBuilder();
		int carry = 0;
		for (int i = product.length - 1; i >= 1 ; i--) { //【注】 i的边界位置
			int sum = product[i] + carry;
			int digit = sum % 10;
			result.append(digit);
			carry = sum / 10;
		}
		if (carry != 0) { // 【注】如果仍有进位，再把carry给append了
		   result.append(carry); 
		}
		return result.reverse().toString();
	}
}
