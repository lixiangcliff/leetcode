package Single_Number_III;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] A = {1,2,2,3,4,4,5,3};
		ArrayList<Integer> result = s.singleNumberIII(A);
		for (int item : result) {
			System.out.println(item);
		}
	}
	
	/**
	 * Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
	 * Example Given [1,2,2,3,4,4,5,3] return 1 and 5
	 * Challenge O(n) time, O(1) extra space.
	 */
	
	//cleaner code: https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
    public ArrayList<Integer> singleNumberIII(int[] A) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (A == null || A.length == 0) {
    		return result;
    	}
    	int bitPos = 0; // result[0]和result[1]所有不同位上异或值的累加和
    	for (int item : A) {
    		bitPos ^= item;
    	}
    	if (bitPos == 0) { // 说明input的都是两两成对的,则根本找不到合法解
    		return result;
    	}
    	int diffPos = 0; // 从右往左找到第一个不同位（其实任意一个不同位都可以）
    	for (int i = 0; i < 32; i++) {
    		if (((bitPos >> i) & 1 ) == 1) {
    			diffPos = i;
    			break;
    		}
    	}
    	int result0 = 0;
    	int result1 = 0;
    	for (int item : A) {
    		if (((item >> diffPos) & 1) == 0) { // 根据每个元素在diffPos位置的不同值，把所有元素分为两组，每组异或累积就分别得到了结果之一
    			result0 ^= item;
    		} else {
    			result1 ^= item;
    		}
    	}
    	result.add(result0);
    	result.add(result1);
    	return result;
    }
}
