package _3Sum_Smaller;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int nums[] = {-2, 0, 1, 3};
		int target = 2;
		System.out.println(q.threeSumSmaller(nums, target));
	}

	/**
	 * Given an array of n integers nums and a target, 
	 * find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target. 
	 * For example, given nums = [-2, 0, 1, 3], and target = 2. 
	 * Return 2. Because there are two triplets which sums are less than 2: 

		[-2, 0, 1] 
		[-2, 0, 3] 
		Follow up: 
		Could you solve it in O(n2) runtime? 
	 */
	
	//http://likesky3.iteye.com/blog/2236385
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}
		Arrays.sort(nums);
		int count =0;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (k > j) {
				if (nums[i] + nums[j] + nums[k] < target) {
					count += k - j;
					break;
				} 
				k--;
			}
		}
		return count;
	}
}
