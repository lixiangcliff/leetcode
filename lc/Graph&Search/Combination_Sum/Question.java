package Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2, 3, 5, 7};
		int target = 7;
		Question q = new Question();
		
		ArrayList<ArrayList<Integer>> result = q.combinationSum(candidates, target);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/combination-sum/
	 * Given a set of candidate numbers (C) and a target number (T), find all
	 * unique combinations in C where the candidate numbers sums to T.
	 * 
	 * The same repeated number may be chosen from C unlimited number of times.
	 * 
	 * Note: 
	 * All numbers (including target) will be positive integers. 
	 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
	 * (ie,  a1 ≤ a2 ≤ … ≤ ak). 
	 * The solution set must not contain duplicate combinations. 
	 * 
	 * For example, 
	 * given candidate set 2,3,6,7 and target 7, 
	 * A solution set is: 
	 * [7] 
	 * [2, 2, 3]
	 */
	//http://blog.csdn.net/linhuanmars/article/details/20828631
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (candidates == null || candidates.length == 0){
    		return result;
    	}
    	Arrays.sort(candidates);
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	int pos = 0;
    	helper(result, item, candidates, pos, target);
    	return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] candidates, int pos, int target){
    	if(target < 0){ // 因为所有元素都为正，如果target为负，则不可能找到数字组合来达到target，故返回
    		return;		
    	}
    	if(target == 0){
    		result.add(new ArrayList<Integer>(item)); 
    		return;
    	}
    	for (int i = pos; i < candidates.length; i++) { //i从pos开始处理，因为pos之前的我们已经处理完了
    		if( i > 0 && candidates[i] == candidates[i - 1]) {//这样做避免了因为重复元素而导致的重复结果
    			continue;
    		}
    		item.add(candidates[i]);
    		helper(result, item, candidates, i, target - candidates[i]); //递归时仍为i，是因为元素可以重复使用，（如果不可以重复使用，此处就要用i + 1）
        	item.remove(item.size() - 1);
    	}
    }
}
