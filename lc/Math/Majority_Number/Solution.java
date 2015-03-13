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

    //注释参考 Majority_Element https://oj.leetcode.com/problems/majority-element/
	public int majorityNumber(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return Integer.MAX_VALUE;
		}
		int candidate = nums.get(0);
		int count = 1;
		for (int i = 1; i < nums.size(); i++) {
			if (count == 0) {
				candidate = nums.get(i);
				count = 1;
			} else {
				if (candidate == nums.get(i)) {
					count++;
				} else {
					count--;
				}
			}
		}
		return candidate;
	}

}
