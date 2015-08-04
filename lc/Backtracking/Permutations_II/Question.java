package Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {1,2,2};
		Question q = new Question();
		List<List<Integer>> result = q.permuteUnique(num);
		for (int i = 0; i < result.size(); i++) {
			List<Integer> item = result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/permutations-ii/
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 * 
	 * For example, 
	 * [1,1,2] have the following unique permutations: 
	 * [1,1,2], [1,2,1], and [2,1,1].
	 */
	
	//【注】因为元素可以重复，此题必须用boolean used[]来标记那些被使用过，哪些没有。
	//而不能像Permutations那样简单用item.contains(num[i])来判断item是否已经存在num[i]
	//这是因为，像例子中的即使是都是1和1，但是两个1是有顺序的，使用了一个做递归，就不能再用递归处理另一个，
	//否则就会出现重复，而used[]就可以来标记不同的1分别是哪一个位子的。item.contains(num[i])却做不到
	//http://blog.csdn.net/linhuanmars/article/details/21570835
	//http://fisherlei.blogspot.com/2012/12/leetcode-permutations-ii.html
    public List<List<Integer>> permuteUnique(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (num == null || num.length == 0){
    		return result;
    	}
    	List<Integer> item = new ArrayList<Integer>();
    	boolean used[] = new boolean[num.length];
    	Arrays.sort(num);//important!
    	helper(result, item, num, used);
    	return result;
    }
    
	private void helper(List<List<Integer>> result, List<Integer> item, int[] num, boolean used[]) {
		if (item.size() == num.length) {
			result.add(new ArrayList<Integer>(item));
			return;
		}
    	for (int i = 0; i < num.length; i++) {
    		//1.若当前元素用过，则跳过此i
    		//2.【注】如果遇到相同元素，若未做到连续地选，则跳过此i。要想保证不产生重复的排列，对相同元素，必须从左开始连续选取。例：3 4 4 4 5 6 ； 4 4 4这个的选法只能是:4, 44, 444连续这三种选法。
    		if (used[i] || i > 0 && num[i - 1] == num[i] && !used[i - 1]) {
    			continue;
    		}
			used[i] = true; // 标记第i个元素已被使用过
    		item.add(num[i]); // 第i个元素加入可行解item
			helper(result, item, num, used); // 进入下一层递归
			item.remove(item.size() - 1); // 回溯，从可行解item中移除第i个元素
			used[i] = false; // 回溯，将第i个元素标为未使用
    	}
    }
}
