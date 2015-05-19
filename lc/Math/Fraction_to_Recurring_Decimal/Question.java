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
		System.out.println((-0) / 5);
		//System.out.println(q.fractionToDecimal(1, 132456));

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
	
    public String fractionToDecimal(int numerator, int denominator) {
    	if (denominator == 0) {
    		return null;
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
		if (a == b * intVal) {
			String res = intPart.toString();
			if (intVal == 0) {
				return "0";
			} else {
				return res;
			}
		}
		intPart.append(".");
		StringBuilder deciPart = new StringBuilder();
		HashMap<Long, Integer> map = new HashMap<Long, Integer>(); // <rem val, rem pos>
		long rem = a % b;
		int i = 0;
		boolean perodic = true;
		while(!map.containsKey(rem)) {
			deciPart.append(rem * 10 / b);
			map.put(rem, i);
			rem = rem * 10 % b;
			if (rem == 0) {
				perodic = false;
				break;
			}
			i++;
		}
		if (perodic) {
			deciPart.insert(map.get(rem), "(");
			deciPart.append(")");
		}
		intPart.append(deciPart);
		return intPart.toString();
    }

}
