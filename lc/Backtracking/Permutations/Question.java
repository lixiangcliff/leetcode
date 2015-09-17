package Permutations;

import java.util.ArrayList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int [] num = {1,2,3};
		Question q = new Question();
		List<List<Integer>> result = q.permute(num);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = (ArrayList<Integer>) result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/permutations/
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, 
	 * [1,2,3] have the following permutations: 
	 * [1,2,3], [1,3,2],[2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */

	//手写
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0){
			return result;
		}
		List<Integer> item = new ArrayList<Integer>();
		boolean[] used = new boolean [num.length];
		helper(result, item, num, used);
		return result;
	}
	
	private void helper(List<List<Integer>> result, List<Integer> item, int[] num, boolean[] used) {
		if (item.size() == num.length) {
			result.add(new ArrayList<Integer>(item)); 
			return;
		}
		for (int i = 0; i < num.length; i++) { //【注】这个是重点，此题不需要start，因为对于item的每一位，都要在num的从头到尾来适配。（只要used[i]为false就适配）
			if (!used[i]) {// 当前元素还没用过，所以可以加入item
			    used[i] = true;
				item.add(num[i]); 
				helper(result, item, num, used); 
				item.remove(item.size() - 1); 
				used[i] = false;
			}
		}
	}
	
	//【注】重点看递归的方法
	//recursive
	//递归函数必须保证在进入和离开函数的时候，变量的状态是一样的, 这样才能保证正确性.
	//http://www.ninechapter.com/solutions/permutations/
	public ArrayList<ArrayList<Integer>> permute2(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0){
			return result;
		}
		ArrayList<Integer> item = new ArrayList<Integer>();
		helper(result, item, num);
		return result;
	}
	
	//DFS 【注】下面代码看图比照DFS搜索树
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] num) {
		if (item.size() == num.length) {// got a permutation
			result.add(new ArrayList<Integer>(item)); // 【注】因为item在各层recursion中是共享的，所以此处必须用new，否则以后每次add和remove元素都会加在这个item上，效果是：result里面装的全是同一个item对象，且最终该item内容为空
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!item.contains(num[i])) {// 当前元素还没用过，所以可以加入item
				item.add(num[i]); // 当前元素加入item
				helper(result, item, num); // 递归处理下一层
				item.remove(item.size() - 1); // 回溯backtracking。“弹出”当前元素，以准备尝试下一个元素
			}
		}
	}
	
	//iterative
	//http://blog.csdn.net/linhuanmars/article/details/21569031
	//思路：设有了当前前i个元素的所有permutation，当第i+1个元素加进来时，我们要做的就是将这个元素带入每一个之前的结果，并且放到每一个结果的各个位置中。
	public ArrayList<ArrayList<Integer>> permuteIterative(int[] num) {
		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
		if (num== null || num.length == 0){
			return result;
		}
		ArrayList<Integer> firstItem = new ArrayList<Integer>();
		firstItem.add(num[0]);//先把第一个元素加进item
		result.add(firstItem);//把这个item加进result
		for (int i = 1; i < num.length; i++) { //从第二个元素开始，依次把当前元素加入result里的所有item，产生新的item，并存入另一个result，再交换result
			ArrayList<ArrayList<Integer>> newResult = new ArrayList<ArrayList<Integer>>();//制造一个之后用来交换的result
			for (int j = 0; j < result.size(); j++) {//从result中取出每个item并处理【注】此处result.size()一直在增长，所以整个算法时间复杂度不是O(n^2)而是指数级的
				ArrayList<Integer> curItem = result.get(j);
				for (int k = 0; k < curItem.size() + 1; k++) {//对于当前item依次把当前元素num[i]塞入该item中各个可以插入的位置（包括头尾一共curItem.size() + 1个位子）
					ArrayList<Integer> item = new ArrayList<Integer>(curItem);
					item.add(k, num[i]);
					newResult.add(item);//把新产生的item放入另一个result。
										//之所以不放回原来的result是因为我们要用result.size()来标记哪些处理过了而哪些没有。如果再放回同一个result，size就不会减小，便陷入死循环。
				}
			}
			result = newResult;
		}
		return result;
	}
	
	//iterate如果不用两个result就这样写
	public ArrayList<ArrayList<Integer>> permuteIterative2(int[] num) {
		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
		if (num== null || num.length == 0){
			return result;
		}
		ArrayList<Integer> firstItem = new ArrayList<Integer>();
		firstItem.add(num[0]);
		result.add(firstItem);
		for (int i = 1; i < num.length; i++) { 
			int size = result.size();//先保留当前size
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> curItem = result.get(j);
				for (int k = 0; k < curItem.size() + 1; k++) {
					ArrayList<Integer> item = new ArrayList<Integer>(curItem);
					item.add(k, num[i]);
					result.add(item);
				}						
			}
			while (size > 0){//删去前size个元素
				result.remove(0);
			}
		}
		return result;
	}

}
