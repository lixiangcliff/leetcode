package Permutation_Sequence;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.getPermutation(4,10));
	}

	/**
	 * https://oj.leetcode.com/problems/permutation-sequence/
	 * The set [1,2,3,…,n] contains a total of n! unique permutations.
	 * By listing and labeling all of the permutations in order, We get the
	 * following sequence (ie, for n = 3):
	 * 
	 * 1. "123" 
	 * 2. "132" 
	 * 3. "213" 
	 * 4. "231" 
	 * 5. "312" 
	 * 6. "321" 
	 * 
	 * Given n and k, return the kth permutation sequence.
	 * Note: Given n will be between 1 and 9 inclusive.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/22028697
	public String getPermutation(int n, int k) {
		if (n <= 0) {
			return "";
		}
		k--; // to adjust index
		StringBuilder sb = new StringBuilder();
		int fac = 1;
		for (int i = 2; i < n; i++) { // 得到factorial为(n - 1)! 为后面从k中"模"去factorial(n - 1)做准备
			fac *= i;
		}
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) { // nums按顺序装有所有可用数字{1,2,3...n}
			nums.add(i);
		}
		for (int i = n - 1; i >= 0; i--) { // i表示当前位的右边还有几位待处理（i从n-1递减至0，共计n轮）
			int idx = k / fac; //得到当前位置应该append的内容
			sb.append(nums.get(idx)); // 将nums[index]加入result
			nums.remove(idx); // 因为元素不能重复使用，所以剔除用过的index
			k %= fac; // k已经处理完当前位，对(n - 1)!取余，更新k为下一轮做准备
			if (i > 0) { // 如果没有这个"if", 当i == 0, 运算非法。
				fac /= i; // factorial相应除以(n - 1)变为(n - 2)! 更新fac为下一轮做准备
			}
		}
		return sb.toString();
	}
}
