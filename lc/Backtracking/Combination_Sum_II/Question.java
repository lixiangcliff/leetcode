package Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		Question q = new Question();
		
		ArrayList<ArrayList<Integer>> result = q.combinationSum2(num, target);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/combination-sum-ii/
	 * Given a collection of candidate numbers (C) and a target number (T), find
	 * all unique combinations in C where the candidate numbers sums to T.
	 * Each number in C may only be used once in the combination.
	 * 
	 * Note: 
	 * All numbers (including target) will be positive integers. 
	 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
	 * (ie, a1 ≤ a2 ≤ … ≤ ak). 
	 * The solution set must not contain duplicate combinations. 
	 * 
	 * For example, 
	 * given candidate set 10,1,2,7,6,1,5 and target 8, 
	 * A solution set is: 
	 * [1, 7] 
	 * [1, 2, 5] 
	 * [2, 6] 
	 * [1, 1, 6]
	 */
	//看【注】
	//类似：https://oj.leetcode.com/problems/combination-sum/ 更多解释参考该题
	//http://blog.csdn.net/linhuanmars/article/details/20829099
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0) {
    		return result;
    	}
    	Arrays.sort(num);
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	int pos = 0;
    	helper(result, item, num, pos, target);
    	return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] num, int pos, int target){
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result.add(new ArrayList<Integer>(item));
			return;
		}
    	for (int i = pos; i < num.length; i++) { 
    		if (i > pos && num[i] == num[i - 1]) { //【注】如果遇到相同元素则跳过，直到遇到不同的元素，再进行下一层递归。类似 Combination_Sum
    			continue;
    		}
    		item.add(num[i]);
    		helper(result, item, num, i + 1, target - num[i]); //【注】元素不可以重复使用，所以此处就要用i + 1（如果元素可以重复使用，则为i）
        	item.remove(item.size() - 1);
    	}
    }
}
