package Ugly_Number_II;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.nthUglyNumber(10));
	}
	
	/**
	 * https://leetcode.com/problems/ugly-number-ii/
	 * Write a program to find the n-th ugly number.

		Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
		For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
		Note that 1 is typically treated as an ugly number.
		
		Hint:
		1.The naive approach is to call isUgly for every number until you reach the nth one. 
			Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
		2.An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
		3.The key is how to maintain the order of the ugly numbers. 
			Try a similar approach of merging from three sorted lists: L1, L2, and L3.
		4.Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
	 */
	/*
	 *  2： 1×2  2×2  3×2  4×2  5×2  6×2  8×2 ...
		3： 1×3  2×3  3×3  4×3  5×3  6×3  8×3 ...
		5： 1×5  2×5  3×5  4×5  5×5  6×5  8×5 ...
	 */
	//还得多理解几次。。。
	//http://www.cnblogs.com/grandyang/p/4743837.html
	//http://www.hihuyue.com/hihuyue/codepractise/leetcode/leetcode186-ugly-number-ii
	//http://www.neozone.me/leetcode264.html
    public int nthUglyNumber(int n) {
    	int[] res = new int[n];
    	res[0] = 1;
        int i2 = 0;//i2, i3, i5是在res中的index
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < n; i++) {
            int m2 = res[i2] * 2;
            int m3 = res[i3] * 3;
            int m5 = res[i5] * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            if (min == m2) ++i2;
            if (min == m3) ++i3;
            if (min == m5) ++i5;
            res[i] = min;
        }
        return res[n - 1];
    }
}
