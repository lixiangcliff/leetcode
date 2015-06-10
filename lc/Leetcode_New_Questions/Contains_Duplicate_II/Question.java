package Contains_Duplicate_II;

import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>(); // <value, list<indexes>>
        for (int i = 0; i < nums.length; i++) {
        	int value = nums[i];
        	if (map.containsKey(value)) {
        		ArrayList<Integer> indexes = map.get(value);
        		if (i - indexes.get(indexes.size() - 1) <= k) {
    				return true;
    			} 
        		map.get(value).add(i);
        	} else {
        		ArrayList<Integer> indexes = new ArrayList<Integer>();
        		indexes.add(i);
        		map.put(value, indexes);
        	}
        }
        return false;
    }
}
