package Ugly_Number;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * https://leetcode.com/problems/ugly-number/
	 * Write a program to check whether a given number is an ugly number.
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
	 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	 * Note that 1 is typically treated as an ugly number.
	 */
	
	//http://www.cnblogs.com/grandyang/p/4741934.html
	//最直接的办法就是不停的除以这些质数，如果剩余的数字是1的话就是丑陋数了
    public boolean isUgly(int num) {
    	if (num <= 0) {
    		return false;
    	}
    	while (num >= 2) {
    		if (num % 2 == 0) { //当前的num能被2整除
    			num /= 2;
    		} else if (num % 3 == 0) {
    			num /= 3;
    		} else if (num % 5 == 0) {
    			num /= 5;
    		} else {
    			return false; // 此时num > 2并且不能被2，3，5整除，即有其他质因子，所以不为ugly number
    		}
    	}
        return true; // when num == 1 
    }
}
