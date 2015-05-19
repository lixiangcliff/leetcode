package Bitwise_AND_of_Numbers_Range;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int m = 63; 
		int n = 97;
		System.out.println(q.rangeBitwiseAnd(m, n));
	}
	
	
	/**
	 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
	 * Given a range [m, n] where 0 <= m <= n <= 2147483647, 
	 * return the bitwise AND of all numbers in this range, inclusive.
	 * 
	 * For example, given the range [5, 7], you should return 4.
	 */
	
	//http://www.meetqun.com/thread-8769-1-1.html
	//https://leetcode.com/discuss/32278/8line-c-simple-clear-solution
	public int rangeBitwiseAnd(int m, int n) {
		int i = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			i++;
		}
		return m << i;
	}
	
    public int rangeBitwiseAnd2(int m, int n) {
    	while (n > m) {
    		n &= n - 1;
    	}
        return n;
    }

}
