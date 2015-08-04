package Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * https://oj.leetcode.com/problems/pascals-triangle/
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * 
	 * For example, given numRows = 5, Return
	 * 
	 * [ 
	 * 	   [1], 
	 * 	  [1,1], 
	 * 	 [1,2,1], 
	 * 	[1,3,3,1], 
	 * [1,4,6,4,1] 
	 * ]
	 * 
	 */

	
	//手写,反复利用同一个item 省时省空间
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return result;
		}
		List<Integer> item = new ArrayList<Integer>(); 
		for (int i = 1; i <= numRows; i++) {
			item.add(1);
			int size = item.size();
			for (int j = size - 2; j >= 1; j--) {
				item.set(j, (item.get(j) + item.get(j - 1)));
			}
			result.add(new ArrayList<Integer>(item));
		}
		return result;
	}
	
	//每一行的每一个元素有这个规律：
	//1. 左右2边的是1.
	//i, j 表示行，列坐标。
	//2. 中间的是f[i][j] = f[i - 1][j] + f[i - 1][j - 1]
	//不断复用上一行的值即可。
	//http://www.cnblogs.com/yuzhangcmu/p/4194821.html
	//http://www.cnblogs.com/huntfor/p/3859522.html
	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows <= 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> item = new ArrayList<Integer>(); // 每一行产生一个新的item
			for (int j = 0; j <= i; j++) { // j <= i，边界用举例的方法
				if (j == 0 || j == i) { // 添加最左边和最右边的1
					item.add(1);
				} else {
					item.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
				}
			}
			result.add(item); // 当前行加入结果集
		}
		return result;
	}
	

}
