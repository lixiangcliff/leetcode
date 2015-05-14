package Bitwise_AND_of_Numbers_Range;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int m = 5; 
		int n = 9;
		System.out.println(q.rangeBitwiseAnd(m, n));
	}
	
	
	/**
	 * Given a range [m, n] where 0 <= m <= n <= 2147483647, 
	 * return the bitwise AND of all numbers in this range, inclusive.
	 * 
	 * For example, given the range [5, 7], you should return 4.
	 */
	
    public int rangeBitwiseAnd(int m, int n) {
    	if (m == n) {
    		return m;
    	}
    	if ( n == 1) {
    		return 0;
    	}
    	int base = 1;
    	while (base <= n / 2) {
    		base *= 2;
    	}
        return base;
    }

}
