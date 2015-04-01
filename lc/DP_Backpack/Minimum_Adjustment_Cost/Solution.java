package Minimum_Adjustment_Cost;

import java.util.ArrayList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(4);
		A.add(2);
		A.add(3);
		Solution s = new Solution();
		System.out.println(s.MinAdjustmentCost(A, 1));

	}
	/**
	 * http://lintcode.com/en/problem/minimum-adjustment-cost/
	 * Given an integer array, adjust each integers so that the difference of
	 * every adjcent integers are not greater than a given number target.
	 * If the array before adjustment is A, the array after adjustment is B, you
	 * should minimize the sum of |A[i]-B[i]|
	 * 
	 * Note You can assume each number in the array is a positive integer and
	 * not greater than 100
	 * 
	 * Example 
	 * Given [1,4,2,3] and target=1, one of the solutions is [2,3,2,3],
	 * the adjustment cost is 2 and it's minimal. Return 2.
	 */
	
	//http://www.cnblogs.com/yuzhangcmu/p/4153927.html
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
    	int[][] res = new int[A.size()][101]; //res[i][v]把index = i的值修改为v，所需要的最小花费
    	for (int i = 0; i < A.size(); i++) {
    		for (int j = 1; j <= 100; j++) { // j表示v
    			if (i == 0) {
    				res[i][j] = Math.abs(j - A.get(i));
    			} else {
	    			res[i][j] = Integer.MAX_VALUE;
	    			for (int k = 1; k < 101; k++) { //k表示v'
	    				if (Math.abs(j - k) > target) {
	    					continue;
	    				}
	    				res[i][j] = Math.min(res[i][j], res[i - 1][k] + Math.abs(A.get(i) - j));
	    			}
    			}
    		}
    	}
    	int min = Integer.MAX_VALUE;
    	for (int j = 1; j < 101; j++) {
    		min = Math.min(min, res[A.size() - 1][j]);
    	}
    	return min;
    }

}
