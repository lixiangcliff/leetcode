package Pascals_Triangle;

import java.util.ArrayList;

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

	//每一行的每一个元素有这个规律：
	//1. 左右2边的是1.
	//i, j 表示行，列坐标。
	//2. 中间的是f[i][j] = f[i - 1][j] + f[i - 1][j - 1]
	//不断复用上一行的值即可。
	//http://www.cnblogs.com/yuzhangcmu/p/4194821.html
	//http://www.cnblogs.com/huntfor/p/3859522.html
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> item = new ArrayList<Integer>(); // 每一行产生一个新的item
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
