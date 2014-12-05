package Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1,2,2};
		Question q = new Question();
		
		ArrayList<ArrayList<Integer>> result = q.subsetsWithDup(S);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/subsets-ii/
	 * Given a collection of integers that might contain duplicates, S, return
	 * all possible subsets.
	 * 
	 * Note: 
	 * Elements in a subset must be in non-descending order. 
	 * The solution set must not contain duplicate subsets. 
	 * For example, 
	 * If S = [1,2,2], a solution is: 
	 * [ 
	 * 	[2], 
	 * 	[1], 
	 * 	[1,2,2], 
	 * 	[2,2], 
	 * 	[1,2], 
	 *	[] 
	 * ]
	 */
	//recursive
	//http://www.ninechapter.com/solutions/subsets-ii/
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			return result;
		}
		ArrayList<Integer> item = new ArrayList<Integer>();
		Arrays.sort(S);
		int pos = 0;
		helper(result, item, S, pos);
		return result;
	}
	
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] S, int pos) {
		result.add(new ArrayList<Integer>(item)); 
		for (int i = pos; i < S.length; i++) {
			// 下面是与subsets的唯一区别。简单说就是如果当前值是之前出现过的，则跳过此次递归。
			if ( i != pos && S[i] == S[i - 1]) { // i != pos：表示 当i不是第一个；S[i] == S[i - 1]：表示 当前值和前一个值相同
                continue;
            }
			item.add(S[i]);
			helper(result, item, S, i + 1);
			item.remove(item.size() - 1);
		}
	}
	
	//iterative way
	//http://blog.csdn.net/linhuanmars/article/details/24286377
	//quite similar to Subsets https://oj.leetcode.com/problems/subsets/
	public static ArrayList<ArrayList<Integer>> subsetsWithDupIterative(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		result.add(new ArrayList<Integer>()); // adding empty set
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int size = result.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> item = new ArrayList<Integer>(result.get(j));
				item.add(num[i]);
				if (!result.contains(item)) { // only add to result if item has not been added before
					result.add(item);
				}
			}
		}
    	return result;
    }

}
