package Triangle;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3);
		a2.add(4);
		
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(6);
		a3.add(5);
		a3.add(7);
		
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(4);
		a4.add(1);
		a4.add(8);
		a4.add(3);
		
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(a1);
		triangle.add(a2);
		triangle.add(a3);
		triangle.add(a4);
		
		System.out.println(minimumTotal(triangle));

	}
	
	/**
	 * https://oj.leetcode.com/problems/triangle/
	 * Given a triangle, find the minimum path sum from top to bottom. 
	 * Each step you may move to adjacent numbers on the row below.

		For example, given the following triangle
		[
	        [2],
	       [3,4],
	      [6,5,7],
	     [4,1,8,3]
		]
		The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
		
		Note:
		Bonus point if you are able to do this using only O(n) extra space, 
		where n is the total number of rows in the triangle.
		
	 */
	//DP, 2D, up to bottom
	//1.state: result[i][j]表示从[0][0]到[i][j]的路径中的最小值。
	//2.function: result[i][j] = Math.min(result[i-1][j-1], result[i-1][j])
	//3.initialize: result[0][0] = triangle[0][0]
	//				result[i][0] = result[i-1][0] + triangle[i][0];
	//4.answer: min(result[size - 1][j])
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0) {
    		return 0;
    	}
    	int size = triangle.size();
    	int result[][] = new int[size][size];
    	result [0][0] = triangle.get(0).get(0);
    	//处理每一行的第一列
    	for (int i = 1; i < size; i++) {
    		result[i][0] = result[i-1][0] + triangle.get(i).get(0);
    	}
    	for (int i = 1; i < size; i++) {
    		for (int j = 1; j <= i; j++) {//j的范围是<=i,而不是<size; 这样才能保证它是一个三角形
    			if (j == i) { //处理每一行的最后一个
    				result[i][j] = result[i-1][j-1] + triangle.get(i).get(j);
    			} else {
    				result[i][j] = Math.min(result[i-1][j-1], result[i-1][j]) + triangle.get(i).get(j); //状态方程
    			}
    		}
    	}
    	//找到最后一行中的最小值
    	int min = result[size - 1][0];
    	for (int i = 1; i < size; i++) {
    		min = Math.min(min, result[size - 1][i]);
    	}
    	return min;
    }

}
