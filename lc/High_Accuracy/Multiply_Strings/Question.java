package Multiply_Strings;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String num1 = "1234";
		String num2 = "7891";
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
		int[] product = new int[len1 + len2]; // 【注】 技巧是用一个数组存每一位的product的和，这样即使在改为的累计超过9，之后仍可以用进位的方式处理
		for (int i = 0; i < len1; i++) { // 计算相应位置的product.
			for (int j = 0; j < len2; j++) { // 边界画图举例。num1和num2是从后往前相乘的，但存入product的时候是从前往后的。
				product[i + j] += (int) (num1.charAt(len1 - 1 - i) - '0') * (int) (num2.charAt(len2 - 1 - j) - '0'); // 积累每一位乘积的和
			}
		}
		StringBuilder result = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < product.length; i++) {
			int sum = product[i] + carry;
			int digit = sum % 10;
			result.append(digit);
			carry = sum / 10;
		}
		//【注】下面“去0”的操作，必须在把product的每一位进位都处理好存入result之后才能做，下面是如果处理进位之前就做会产生的问题：
		// Input:	"9", "9"
		// Output:	"1"
		// Expected:	"81"
		if (result.length() > 1 && result.charAt(result.length() - 1) == '0') { // 去掉前面可能的'0'
			result.deleteCharAt(result.length() - 1);
		}
		return result.reverse().toString();
	}
}
