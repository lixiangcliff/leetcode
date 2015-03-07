package _3Sum_Closest;

import java.util.Arrays;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] num = {-1, 2, 1, -4};
		int target = 2;
		int result = q.threeSumClosest(num, target);
		System.out.println(result);
	}
	
	/**
	 * https://oj.leetcode.com/problems/3sum-closest/
	 * Given an array S of n integers, find three integers in S such that the
	 * sum is closest to a given number, target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * For example, 
	 * given array S = {-1 2 1 -4}, 
	 * and target = 1.
	 * 
	 * The sum that is closest to the target is 2. 
	 * (-1 + 2 + 1 = 2).
	 */
	//类似：3Sum
	//http://www.ninechapter.com/solutions/3sum-closest/
	//http://blog.csdn.net/linhuanmars/article/details/19712011
    public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length <= 2){
			return Integer.MAX_VALUE;
		}
		Arrays.sort(num); //先排序！
		int result = num[0] + num[1] + num[2];
		for(int i = 0; i < num.length - 2; i++) { // i最远可以取到倒数第三个 【注】此题不是求不重复的结果集，所以不需要跳过所谓与num[i - 1]相同的i
			int l = i + 1;
			int r = num.length - 1;
			while (l < r) {
				int sum = num[i] + num[l] + num[r];
				if (sum == target) {// 得到了一组符合条件的三个数
					return target;
				} else if (sum < target) {
					l++;
				} else {
					r--;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) { //如果当前sum更加接近target，则更新result
					result = sum;
				}
			}
		}
		return result;
    }
}
