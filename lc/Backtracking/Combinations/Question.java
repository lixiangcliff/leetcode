package Combinations;

import java.util.ArrayList;
import java.util.HashSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ArrayList<ArrayList<Integer>> result = q.combine(4,2);
		for (ArrayList<Integer> item : result) {
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
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		int start = 1; // 元素的可选起始值【注】start初值并不是0
		getCombine(result, item, n, k, start);
		return result;
	}
	
	private void getCombine(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int n, int k, int start){
		if (item.size() == k) {
			result.add(new ArrayList<Integer>(item));
		} else {
			for (int i = start; i <= n; i++) {
				item.add(i); // 加入一个符合条件的数
				getCombine(result, item, n, k, i + 1); // i的可选数的起始值往右挪一个，然后递归.【注】下一层传入的start是i + 1, 因为当前处理的值是i（不是start + 1）
				item.remove(item.size() - 1); // 回溯
			}
		}
	}

}
