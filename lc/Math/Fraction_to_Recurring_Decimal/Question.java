package Fraction_to_Recurring_Decimal;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//System.out.println(q.fractionToDecimal(-1, -Integer.MIN_VALUE));
		//System.out.println((2) / 5);
		System.out.println(q.fractionToDecimal(2, 50));

	}
	
	/**
	 * https://leetcode.com/problems/fraction-to-recurring-decimal/
	 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
		If the fractional part is repeating, enclose the repeating part in parentheses.
		For example,
		
		Given numerator = 1, denominator = 2, return "0.5".
		Given numerator = 2, denominator = 1, return "2".
		Given numerator = 2, denominator = 3, return "0.(6)".	
	 */
	
	//http://blog.csdn.net/u012162613/article/details/41998617
    public String fractionToDecimal(int numerator, int denominator) {
    	if (denominator == 0) {
    		return null;
    	}
    	if (numerator == 0) {
    		return "0";
    	}
    	long a = Math.abs((long) numerator);
    	long b = Math.abs((long) denominator);
		boolean negative = (((numerator ^ denominator) >> 31 ) & 1) == 1;
		StringBuilder intPart = new StringBuilder();
		long intVal = a / b;
		if (negative) {
			intPart.append("-");
		}
		intPart.append(intVal);
		if (a == b * intVal) { // 可以整除
			String res = intPart.toString();
			return res;
		}
		intPart.append(".");
		StringBuilder deciPart = new StringBuilder();
		long rem = a % b; // 余数
		HashMap<Long, Integer> map = new HashMap<Long, Integer>(); // <rem's val, rem's pos>
		int i = 0;
		boolean isPerodic = true; //是否为循环小数
		while (!map.containsKey(rem)) { //一旦碰到余数重复，则找到一个完整的循环节
			if (rem == 0) {
				isPerodic = false;
				break;
			}
			deciPart.append(rem * 10 / b);
			map.put(rem, i);
			rem = rem * 10 % b;
			i++;
		}
		if (isPerodic) {
			deciPart.insert(map.get(rem), "("); //找到“循环节”第一位的位置
			deciPart.append(")");
		}
		intPart.append(deciPart);
		return intPart.toString();
    }
}
