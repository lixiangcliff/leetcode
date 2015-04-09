package Factorial_Trailing_Zeroes;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.trailingZeroes(50));
	}
	
	/**
	 * https://leetcode.com/problems/factorial-trailing-zeroes/
	 * Given an integer n, return the number of trailing zeroes in n!.
		Note: Your solution should be in logarithmic time complexity.
	 */
	
	//偶数有的是，看有多少个5就行了
    public int trailingZeroes(int n) {
        if (n < 5) {
        	return 0;
        }
        int base = 5;
        int sum = 0;
        while (base <= n) {
        	sum += n / base;
        	if (base <= Integer.MAX_VALUE / 5) {
        		base *= 5;
        	} else {
        		break;
        	}
        }
        return sum;
    }

}
