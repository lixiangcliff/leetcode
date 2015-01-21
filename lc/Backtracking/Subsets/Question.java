package Subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {3,2,1};
		Question q = new Question();
		
		ArrayList<ArrayList<Integer>> result = q.subsets(S);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}
	}

	/**
	 * https://oj.leetcode.com/problems/subsets/
	 * Given a set of distinct integers, S, return all possible subsets.
	 * 
	 * Note: 
	 * Elements in a subset must be in non-descending order. 
	 * The solution set must not contain duplicate subsets. 
	 * 
	 * For example, 
	 * If S = [1,2,3], a solution is:
	 * [ 
	 * 	[3], 
	 * 	[1], 
	 * 	[2], 
	 * 	[1,2,3], 
	 * 	[1,3], 
	 * 	[2,3], 
	 * 	[1,2], 
	 * 	[] 
	 * ]
	 */
	//【注】重点看递归方法 recursive way
	//http://www.ninechapter.com/solutions/subsets/
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			return result;
		}
		ArrayList<Integer> item = new ArrayList<Integer>();
		Arrays.sort(S); //排序保证题中要求：“Elements in a subset must be in non-descending order”
		helper(result, item, S, 0);
		return result;
	}
	
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] S, int pos) {
		result.add(new ArrayList<Integer>(item)); //这行放在最开始或者最后都可以，因为任何一层递归所得，都是一个所求子集
		for (int i = pos; i < S.length; i++) { // i从pos开始往右扫，这样保证pos左边的都不会再重复计算。对应到DFS搜索树中：取完当前元素之后，只会取比其更大的，而不会取比其更小的。
			item.add(S[i]); // 当前元素加入item中
			helper(result, item, S, i + 1); // 递归下一层，pos右移一个
			item.remove(item.size() - 1); // 回溯
		}
	}
	
	//iterative way
	//http://blog.csdn.net/linhuanmars/article/details/24286377
    public static ArrayList<ArrayList<Integer>> subsetsIterative(int[] S) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0) {
            return result;
        }
    	result.add(new ArrayList<Integer>()); //adding empty set
    	Arrays.sort(S);
    	for(int i = 0; i < S.length; i++){
			int size = result.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> item = new ArrayList<Integer>(result.get(j));
				item.add(S[i]); //因为S被sort之后是有序的，之后的i肯定比原来item里的元素都大，这就保证了所有子集的non-descending order.
				result.add(item); //加入S[i]后组成了新的元素 并存入result
    		}	
    	}
    	return result;
    }

}
