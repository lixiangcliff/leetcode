package Single_Number;

public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,3,4,12,-5, -1657, 13,12,6,2, -1657, -5673,3,1,4,6,13, -5, 0 , 0, -5673, -32768};
		SingleNumber s = new SingleNumber();
		System.out.println(s.singleNumber(A));
	}
	
	/**
	 * https://oj.leetcode.com/problems/single-number/ 
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	
	//O(1) 空间复杂度
	//应用性质:
	//1. a ^ 0 == a
	//1. a ^ a == 0
	//1. (a ^ b) ^ c == a ^ (b ^ c)
	public int singleNumber(int[] A) {
        if(A == null || A.length == 0) {
            return -1;
        }
		int result = 0;
		for (int i : A) {
			result ^= i;
		}
		return result;
	}
	    


}

   