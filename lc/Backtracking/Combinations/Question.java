package Combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		List<List<Integer>> result = q.combine(4,2);
		for (List<Integer> item : result) {
			for (int i : item) {
				System.out.print(i + ",");
			}
			System.out.println("");
		}
	}
	

	/**
	 * https://oj.leetcode.com/problems/combinations/
	 * Given two integers n and k, return all possible combinations of k numbers
	 * out of 1 ... n.
	 * 
	 * For example, If n = 4 and k = 2, a solution is:
	 * 
	 * [ 
	 * 	[2,4], 
	 * 	[3,4], 
	 * 	[2,3], 
	 * 	[1,2], 
	 * 	[1,3], 
	 * 	[1,4], 
	 * ]
	 */
	
	//DFS; recursive
	//http://answer.ninechapter.com/solutions/combinations/
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> item = new ArrayList<Integer>();
		int start = 1; // 元素的可选起始值【注】start初值并不是0
		helper(result, item, n, k, start);
		return result;
	}
	
	private void helper(List<List<Integer>> result, List<Integer> item, int n, int k, int start){
		if (item.size() == k) {
			result.add(new ArrayList<Integer>(item));
		} 
		for (int i = start; i <= n; i++) {
			item.add(i); // 加入一个符合条件的数
			helper(result, item, n, k, i + 1); // i的可选数的起始值往右挪一个，然后递归.【注】下一层传入的start是i + 1, 因为当前处理的值是i（不是start + 1）
			item.remove(item.size() - 1); // 回溯
		}
	}

}
