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
	// http://www.cnblogs.com/yuzhangcmu/p/4175779.html
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
    		} else if (count1 == 0) { // item1个数已经为“空”，则用当前值更新item1
    			item1 = nums.get(i);
    			count1 = 1;
    		} else if (count2 == 0) {
    			item2 = nums.get(i);
    			count2 = 1;
    		} else { // 当前值既不相同于item1又不同于item2，而且item1和item2个数都不为“空”，说明找到三个不同的元素，同时消去。
    			count1--;
    			count2--;
    		}
    	}
    	count1 = 0;
    	count2 = 0;
    	//【注】"为什么最后要再检查2个数字呢？因为数字的编排可以让majority 数被过度消耗，使其计数反而小于n2，或者等于n2。
    	//例子：1 1 1 1 2 3 2 3 4 4 4 这个 1就会被消耗过多，最后余下的反而比4少。"
    	for (int num : nums) { // 从头走一遍，item1和item2最终个数多的那个为Majority Number
    		if (num == item1) {
    			count1++;
    		} else if (num == item2) {
    			count2++;
    		}
    	}
    	return count1 > count2 ? item1 : item2;
    }

}
