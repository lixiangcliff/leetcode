package _4Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/4sum/
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: 
	 * Elements in a quadruplet (a,b,c,d) must be in non-descending order.
	 * (ie, a ≤ b ≤ c ≤ d) 
	 * The solution set must not contain duplicate quadruplets. 
	 * 
	 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
	 * 
	 * A solution set is: 
	 * (-1, 0, 0, 1) 
	 * (-2, -1, 1, 2) 
	 * (-2, 0, 0, 2)
	 */
	//类似3sum
	//枚举i复杂度为n，枚举j复杂度为n，剩下的l和r的操作时间复杂度为n；故最终的时间复杂度为O(n^3)。
	//通过类似方法可得:对k_sum，用类似方法时间复杂度为O(n^(k-1))。
	//http://answer.ninechapter.com/solutions/4sum/
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 4) {
			return result;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 3; i++) { // i最远取到倒数第4个
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < num.length - 2; j++) { // j从i + 1取到倒数第3个
				if (j != i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				int l = j + 1;
				int r = num.length - 1;
				while (l < r) {
					int sum = num[i] + num[j] + num[l] + num[r]; 
					if (sum == target) {
						ArrayList<Integer> item = new ArrayList<Integer>();
						item.add(num[i]);
						item.add(num[j]);
						item.add(num[l]);
						item.add(num[r]);
						result.add(item);
						l++;
						r--;
						while (l < r && num[l] == num[l - 1]) {
							l++;
						}
						while (l < r && num[r] == num[r + 1]) {
							r--;
						}
					} else if (sum < target) {
						l++;
					} else {
						r--;
					}
				}
			}
		}
		return result;
	}
}
