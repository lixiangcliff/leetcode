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
	
    public ArrayList<Integer> singleNumberIII(int[] A) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (A == null || A.length == 0) {
    		return result;
    	}
    	int bitPos = 0; // result1和result2所有不同位上的加和
    	for (int item : A) {
    		bitPos ^= item;
    	}
    	if (bitPos == 0) { // 说明input的都是两两成对的
    		return result;
    	}
    	int diffPos = 0; // 从右往左找到第一个不同位（其实任意一个不同位都可以）
    	for (int i = 0; i < 32; i++) {
    		if (((bitPos >> i) & 1 ) == 1) {
    			diffPos = i;
    			break;
    		}
    	}
    	int result1 = 0;
    	int result2 = 0;
    	for (int item : A) {
    		if (((item >> diffPos) & 1) == 0) { // 以不同位把元素分为两组，每组亦或累积就可以分别得到一个结果
    			result1 ^= item;
    		} else {
    			result2 ^= item;
    		}
    	}
    	result.add(result1);
    	result.add(result2);
    	return result;
    }
}
