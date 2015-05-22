package Number_of_1_Bits;

public class Question {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/number-of-1-bits/
	 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
		For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
	 */
	
    // you need to treat n as an unsigned value
	
	//http://stackoverflow.com/questions/15370250/how-does-this-line-works-n-nn-1
	public int hammingWeight(int n) {
	    int c;
	    for (c = 0; n != 0; ++c) 
	        n = n & (n - 1); // 【注】n & (n - 1)可以消去n的二进制形式的最右边一个1
	    return c;
    }
	
	//【注】>>>与>>的区别 https://leetcode.com/discuss/28216/accepted-java-solution-but-i-have-a-question-to-ask
	// >> 符号位不会被移动 ；>>> 符号位也可以被移动
    public int hammingWeight2(int n) {
    	int count = 0;
        while(n != 0) {
        	if ((n & 1) == 1) {
        		count++;
        	}
        	n >>>= 1; // must use >>> instead of >>
        }
        return count;
    }
    
    public int hammingWeight3(int n) {
    	int count = 0;
    	long a = (long)n;
    	for (int i = 0; i < 32; i++) {
    		long bit = (a >> i) & 1;
    		count += bit == 1 ? 1 : 0;
    	}
        return count;
    }

}
