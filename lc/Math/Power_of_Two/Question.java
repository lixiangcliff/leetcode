package Power_of_Two;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/power-of-two/
	 * Given an integer, write a function to determine if it is a power of two.
	 */
	
    public boolean isPowerOfTwo(int n) {
        if (n <=0) {
        	return false;
        }
        return (n & (n - 1)) == 0;
    }

}
