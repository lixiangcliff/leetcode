package Rotate_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/rotate-array/
	 * Rotate an array of n elements to the right by k steps.
		For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
		
		Note:
		Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
		
		Hint:
		Could you do it in-place with O(1) extra space?
		Related problem: Reverse Words in a String II
	 * 
	 */

	//in place 
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        	return;
        }
        int len = nums.length;
        k %= len;
        revesre(nums, 0, len - k - 1);
        revesre(nums, len - k, len - 1);
        revesre(nums, 0, len - 1);
        return;
    }
    
    private void revesre(int[] nums, int l, int r) {
    	while (l < r) {
    		int tmp = nums[l];
    		nums[l] = nums[r];
    		nums[r] = tmp;
    		l++;
    		r--;
    	}
    }
}
