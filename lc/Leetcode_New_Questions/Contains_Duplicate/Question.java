package Contains_Duplicate;

import java.util.HashSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * https://leetcode.com/problems/contains-duplicate/
	 * Given an array of integers, find if the array contains any duplicates. 
	 * Your function should return true if any value appears at least twice in the array, 
	 * and it should return false if every element is distinct.
	 */
	
    public boolean containsDuplicate(int[] nums) {
    	if (nums == null || nums.length < 2) {
    		return false;
    	}
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
        	if (set.contains(i)) {
        		return true;
        	} else {
        		set.add(i);
        	}
        }
        return false;
    }
}
