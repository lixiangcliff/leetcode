package Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		List<Integer> result = q.getRow(4);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + ",");
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/pascals-triangle-ii/
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3, Return [1,3,3,1].
	 * 
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 */
	
	
	//手写简化版
	
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> item = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return item;
		}
		for (int i = 0; i <= rowIndex; i++) {
			item.add(1);
			int size = item.size();
			for (int j = size - 2; j >= 1; j--) {
				item.set(j, item.get(j) + item.get(j - 1));
			}
		}
		return item;
    }
    
    
	
	//to use O(k) space only: 重复利用同一个“数组”
	//http://blog.csdn.net/linhuanmars/article/details/23311629
	//http://blog.csdn.net/abcbc/article/details/8982651
	//http://fisherlei.blogspot.com/2012/12/leetcode-pascals-triangle-ii.html
	//一维DP，从后往前扫。
	//ArrayList的元素一定要先添加数据，之后才能改值，即要先add 然后才能set
	//【注】此题和Pascals_Triangle_I 对kth row的定义有区别
	public ArrayList<Integer> getRow2(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return result;
		}
		for (int i = 0; i <= rowIndex; i++) {// 从第row 0到第row n
			for (int j = i; j >= 0; j--) {// 【注】从后往前扫，第i行有i + 1列（举例第0行，有1列）
				if (j == i) { // 添上本行最右边的1
					result.add(1); 
				} else if (j == 0) { // 最左边的数永远是1，无需处理即可
					continue;
				} else {
					result.set(j, result.get(j - 1) + result.get(j)); // 举例画图清晰可得
				}
			}
		}
		return result;
	}
}
