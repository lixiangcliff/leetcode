package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4};
		Question q = new Question();
/*		for (int m=0;m<num.length;m++){
			System.out.print(num[m]);
		}		
		q.swap(num, 0, 3);
		for (int m=0;m<num.length;m++){
			System.out.print(num[m]);
		}*/
		q.permute(num);
		/*for (int m=0;m<num.length;m++){
			System.out.print(num[m]);
		}*/

	}
	
	/**
	 * https://oj.leetcode.com/problems/permutations/
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, 
	 * [1,2,3] have the following permutations: 
	 * [1,2,3], [1,3,2],[2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */

	
	//recursive
	//递归函数必须保证在进入和离开函数的时候，变量的状态是一样的, 这样才能保证正确性.
	//http://www.ninechapter.com/solutions/permutations/
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0){
			return result;
		}
		ArrayList<Integer> item = new ArrayList<Integer>();
		helper(result, item, num);
		return result;
		
	}
	
	private void helper( ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] num) {
		if (item.size() == num.length) {// got a permutation
			result.add(new ArrayList<Integer>(item)); // must "new" a new item, because item is shared among recursion, 
			return;//everything will add on this item if not "new" a item every single time
		}
		for( int i=0;i<num.length;i++) {
			if (!item.contains(num[i])) {//important! to determine whether to process it for permuting
				item.add(num[i]);
				helper(result, item, num);
				item.remove(item.size() - 1); // recover to its original status
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

}
