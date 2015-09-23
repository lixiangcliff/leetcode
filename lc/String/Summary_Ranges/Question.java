package Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] nums = {0,1,2,4,5,7};
		List<String> res = q.summaryRanges(nums);
		for (String str : res) {
			System.out.println(str);
		}
	}
	
	/**
	 * https://leetcode.com/problems/summary-ranges/
	 * Given a sorted integer array without duplicates, return the summary of its ranges.
	 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
	 */
	
    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList<String>();
    	if (nums == null || nums.length == 0) {
    		return res;
    	}
    	if (nums.length == 1) {
    		res.add("" + nums[0]);
    		return res;
    	}
    	int pre = 0;
    	int cur = 1;
    	for (; cur <= nums.length; cur++) {
    		if (cur == nums.length || nums[cur] != nums[cur - 1] + 1) { // 说明已经断开了
    			if (pre == cur - 1) {
    				res.add("" + nums[pre]);
    			} else {
    				res.add(nums[pre] + "->" + nums[cur - 1]);
    			}
    			pre = cur;
    		} 
    	}
    	return res;
    }
    
/*    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList<String>();
    	if (nums == null || nums.length == 0) {
    		return res;
    	}
    	if (nums.length == 1) {
    		res.add(String.valueOf(nums[0]));
    		return res;
    	}
    	int start = 0;
    	int end = start;
    	for (int i = 1; i <= nums.length; i++) {
    		if (i == nums.length || nums[i] - 1 != nums[i - 1]) { // 说明已经断开了
    			if (start == end) {
    				res.add(String.valueOf(nums[start]));
    			} else {
    				res.add(nums[start] + "->" + nums[end]);
    			}
    			start = i;
    			end = start;
    		} else {
    			end++;
    		}
    	}
    	return res;
    }*/

}
