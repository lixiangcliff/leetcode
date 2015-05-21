package Happy_Number;

import java.util.HashSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/happy-number/
	 * Write an algorithm to determine if a number is "happy".
	 * A happy number is a number defined by the following process: 
	 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
	 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
	 * Those numbers for which this process ends in 1 are happy numbers.
	 * Example: 19 is a happy number

		1^2 + 9^2 = 82
		8^2 + 2^2 = 68
		6^2 + 8^2 = 100
		1^2 + 0^2 + 0^2 = 1.
	 */
	
    public boolean isHappy(int n) {
    	if (n <= 0) {
    		return false;
    	}
    	if (n == 1) {
    		return true;
    	}
    	HashSet<Integer> set = new HashSet<Integer>();
    	while (!set.contains(n)) {
    		set.add(n);
    		int sum = 0;
    		while (n != 0) {
    			sum += Math.pow((n % 10), 2); // 每次取最右一位
    			n /= 10; // 截去最右一位
    		}
    		if (sum == 1) {
    			return true;
    		}
    		n = sum;
    	}
    	return false;
    }

}
