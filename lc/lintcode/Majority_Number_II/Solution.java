package Majority_Number_II;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] numArray = {1, 2, 1, 2, 1, 3, 3};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int num : numArray) {
			nums.add(num);
		}
		System.out.println(s.majorityNumber(nums));
	}
	
	/**
	 * http://lintcode.com/en/problem/majority-number-ii/
	 * Given an array of integers, the majority number is the number that occurs
	 * more than 1/3 of the size of the array. Find it.
	 * Note There is only one majority number in the array
	 * 
	 * Example 
	 * For [1, 2, 1, 2, 1, 3, 3] return 1
	 * Challenge O(n) time and O(1) space
	 */
	
	//思想：找到三个不一样的，同时消去。
    public int majorityNumber(ArrayList<Integer> nums) {
    	if (nums == null || nums.size() <=2) {
    		return Integer.MAX_VALUE;
    	}
    	int item1 = Integer.MIN_VALUE;
    	int item2 = Integer.MIN_VALUE;
    	int count1 = 0;
    	int count2 = 0;
    	for (int i = 0; i < nums.size(); i++) {
    		if (item1 == nums.get(i)) {
    			count1++;
    		} else if (item2 == nums.get(i)) {
    			count2++;
    		} else if (count1 == 0) {
    			item1 = nums.get(i);
    			count1++;
    		} else if (count2 == 0) {
    			item2 = nums.get(i);
    			count2++;
    		} else { // 找到三个不同的元素，同时消去
    			count1--;
    			count2--;
    		}
    	}
    	count1 = 0;
    	count2 = 0;
    	for (int num : nums) {
    		if (num == item1) {
    			count1++;
    		} else if (num == item2) {
    			count2++;
    		}
    	}
    	return count1 > count2 ? item1 : item2;
    }

}
