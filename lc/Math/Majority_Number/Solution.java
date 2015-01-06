package Majority_Number;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * http://lintcode.com/en/problem/majority-number/
	 * Given an array of integers, the majority number is the number that occurs
	 * more than half of the size of the array. Find it.
	 * 
	 * Example 
	 * For [1, 1, 1, 1, 2, 2, 2], return 1
	 * 
	 * Challenge 
	 * Expand O(n) time and O(1) space
	 */

    //中心思想是只要找到两个不一样的元素，就把他们抵消掉，最后剩下的就是超过 n / 2个数量的那个
	public int majorityNumber(ArrayList<Integer> nums){
    	if (nums == null || nums.size() == 0) {
    		return Integer.MAX_VALUE;
    	}
        int candidate = nums.get(0);
        int count = 1;
        for (int i = 1; i < nums.size(); i++) {
        	if (count == 0) { // 前面的全都抵消掉了
        		candidate = nums.get(i);
        		count = 1; //【注】勿忘count此时置1
        	} else {
        		if (candidate == nums.get(i)) { // 有出现了一个和candidate相同的数
        			count++;
        		} else { // 与candidate不同，则抵消掉一次。
        			count--; 
        		}
        	}
        }
        return candidate;
    }

}
