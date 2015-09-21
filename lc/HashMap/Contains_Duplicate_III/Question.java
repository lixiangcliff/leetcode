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
	//用long类型，避免corner case(比如输入[0,2147483647], 1, 2147483647)
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0 || nums == null || nums.length < 2) {
			return false;
		}
		SortedSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			SortedSet<Long> subSet = set.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
			if (!subSet.isEmpty())
				return true;
			if (i >= k) {
				set.remove((long) nums[i - k]);
			}
			set.add((long) nums[i]);
		}
		return false;
	}
}
