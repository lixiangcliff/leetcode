package Reverse_Bits;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.reverseBits(43261596));
	}
	
	/**
	 * https://leetcode.com/problems/reverse-bits/
	 * Reverse bits of a given 32 bits unsigned integer.
		For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
		return 964176192 (represented in binary as 00111001011110000010100101000000).
		
		Follow up:
		If this function is called many times, how would you optimize it?
		Related problem: Reverse Integer
	 */
	
    public int reverseBits(int n) {
    	long a = (long)n;
    	int res = 0;
    	for (int i = 0; i < 32; i++) {
    		long bit = (a >> i) & 1;
    		res <<= 1;
    		res += bit;
    	}
    	return res;
    }

}
