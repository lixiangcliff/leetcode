package Contains_Duplicate_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/contains-duplicate-ii/
	 * Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array 
	 * such that nums[i] = nums[j] and the difference between i and j is at most k.
	 */

	
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
        	return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // <value, index>
        for (int i = 0; i < nums.length; i++) {
        	int value = nums[i];
        	if (map.containsKey(value)) {
        		if (i - map.get(value) <= k) {
    				return true;
    			} 
        	} 
        	map.put(value, i);
        }
        return false;
    }
    
    //using hashset
 	//https://leetcode.com/discuss/38445/simple-java-solution
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}
}
