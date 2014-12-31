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
		StringBuilder result = new StringBuilder();
		int factorial = 1;
		for (int i = 2; i < n; i++) { // 得到factorial为(n - 1)!
			factorial *= i;
		}
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) { // num里装有所有可用数字{1,2,3...n}
			nums.add(i);
		}
		int round = n - 1; // round表示当前位的右边还有几位
		while (round >= 0) { // 最多n轮
			int index = k / factorial;
			result.append(nums.get(index)); // 将nums[index]加入result
			nums.remove(index); // 因为元素不能重复使用，所以剔除用过的index
			k %= factorial; // k已经处理完当前位，对(n - 1)!取余，进入下一位处理
			if (round > 0) { // without this, when round == 0, it will fail;
				factorial /= round; // factorial相应除以(n - 1)变为(n - 2)!
			}
			round--; // round递减
		}
		return result.toString();
	}
}
