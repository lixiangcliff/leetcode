package Recover_Rotated_Sorted_Array;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(5);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		for (int i = 0; i < nums.size(); i++){
			System.out.print(nums.get(i) + ",");
		}
		System.out.print("===========");
		Solution s = new Solution();
		s.recoverRotatedSortedArray(nums);
		for (int i = 0; i < nums.size(); i++){
			System.out.print(nums.get(i) + ",");
		}
	}
	
    /**
     * http://lintcode.com/en/problem/recover-rotated-sorted-array/
	 * Given a rotated sorted array, recover it to sorted array in-place.
	 * Example [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
	 * Challenge In-place, O(1) extra space and O(n) time.
	 * Clarification What is rotated array:
	 * 
	 * - For example, the orginal array is [1,2,3,4], The rotated array of it
	 * can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
	 */
	
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if (nums ==  null || nums.size() <= 1){
    		return;
    	}
    	int start = 0;
    	int end = nums.size() - 1; //【注】 end是最后一个有效位
    	//找array的min，用了binary search模板
    	while (start + 1 < end) { 
    		int mid = start + (end - start) / 2;
    		if (nums.get(mid) < nums.get(end)) {
    			end = mid;
    		} else {
    			start = mid;
    		}
    	}
    	int min = Math.min(start, end);
    	//三步翻转
    	reverse(nums, 0, min - 1);
    	reverse(nums, min, nums.size() - 1);
    	reverse(nums, 0, nums.size() - 1);
    	return;
    }
    
    private void reverse (ArrayList<Integer> nums, int start, int end) {
    	if (start < 0 || end > nums.size() - 1){
    		return;
    	}
    	while (start < end) {
    		int temp = nums.get(start);
    		nums.set(start, nums.get(end));
    		nums.set(end, temp);
    		start++;
    		end--;
    	}
    	return;
    }

}
