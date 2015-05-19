package Minimum_Size_Subarray_Sum;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/minimum-size-subarray-sum/
	 * Given an nums of n positive integers and a positive integer s, 
	 * find the minimal length of a subnums of which the sum ≥ s. If there isn't one, return 0 instead.
	 * For example, given the nums [2,3,1,2,4,3] and s = 7,
	 * the subnums [4,3] has the minimal length under the problem constraint.
	 */
	
	
	//similar as fgdsb: Find_Subarray_with_Given_Sum
    public int minSubnumsLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
      	   return 0;
         }
         int sum = 0;
         int l = 0;
         int r = 0;
         int min = nums.length + 1;
         while (r < nums.length) {
      	   while (sum < s && r < nums.length) {
      		   sum += nums[r];
      		   r++;
      	   }
      	   while (sum >= s && l < r) {
      		   min = Math.min(min, r - l);
      		   sum -= nums[l];
      		   l++;
      	   }
         }
         return min == nums.length + 1 ? 0 : min;
    }

}
