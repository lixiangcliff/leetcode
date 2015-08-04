package Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2, 3, 5, 7};
		int target = 7;
		Question q = new Question();
		
		List<List<Integer>> result = q.combinationSum(candidates, target);
		for (int i = 0; i < result.size(); i++) {
			List<Integer> item = result.get(i);
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
	
	//【注】类似subsets为了避免相同元素导致的结果集重复，需要pos这个参数来标记，每次递归的时的，起始处理元素的位置。
	//http://blog.csdn.net/linhuanmars/article/details/20828631
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (candidates == null || candidates.length == 0) {
    		return result;
    	}
    	Arrays.sort(candidates); // 这类题基本都需要先sort。对于此题sort之后，递归时如果当前元素已经比target大了，则之后的元素就不用再看了，直接返回即可。
    	List<Integer> item = new ArrayList<Integer>();
    	int pos = 0;
    	helper(result, item, candidates, pos, target);
    	return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> item, int[] candidates, int pos, int target){
    	if (target < 0) { // 因为所有元素都为正，如果target为负，则不可能找到数字组合来达到target，故返回
    		return;		
    	}
    	if (target == 0) { // 找到了和为target的一个组合
    		result.add(new ArrayList<Integer>(item)); 
    		return;
    	}
    	for (int i = pos; i < candidates.length; i++) { //i从pos开始处理，因为pos之前的我们已经处理完了
    		//这样做避免了因为重复元素而导致的重复结果（如果遇到相同元素则跳过，直到遇到不同的元素，再进行下一层递归。此处类似subsets II）
    		if (i > pos && candidates[i] == candidates[i - 1]) {
    			continue;
    		}
    		item.add(candidates[i]);//把当前值加入item中
    		helper(result, item, candidates, i, target - candidates[i]); //【注】target减去当前值。进一步递归。递归时pos仍取i，这是因为元素可以多次使用，（如果不可以重复使用，此处就要用i + 1）
        	item.remove(item.size() - 1); //回溯
    	}
    }
}
