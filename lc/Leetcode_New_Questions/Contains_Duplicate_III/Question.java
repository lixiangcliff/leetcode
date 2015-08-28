package Contains_Duplicate_III;

import java.util.SortedSet;
import java.util.TreeSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/contains-duplicate-iii/
	 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
	 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
	 */
	
	//时间复杂度为 O(n logk)
	//http://blog.csdn.net/xudli/article/details/46323247
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0 || nums == null || nums.length < 2) {
			return false;
		}
		SortedSet<Long> set = new TreeSet<Long>();

		for (int j = 0; j < nums.length; j++) {
			SortedSet<Long> subSet = set.subSet((long) nums[j] - t, (long) nums[j] + t + 1);
			if (!subSet.isEmpty())
				return true;

			if (j >= k) {
				set.remove((long) nums[j - k]);
			}
			set.add((long) nums[j]);
		}
		return false;
	}

}
