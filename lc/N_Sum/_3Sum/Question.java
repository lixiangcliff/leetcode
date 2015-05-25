package _3Sum;

import java.util.ArrayList;
import java.util.Arrays;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] num = {-1, 0, 1, 2, -1, -4};
		ArrayList<ArrayList<Integer>> result = q.threeSum(num);
		for (ArrayList<Integer> item : result) {
			for (int val : item) {
				System.out.print(val + ",");
			}
			System.out.println("");
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/3sum/
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: 
	 * Elements in a triplet (a,b,c) must be in non-descending order. (ie,
	 * a ≤ b ≤ c) 
	 * The solution set must not contain duplicate triplets. For
	 * example, given array S = {-1 0 1 2 -1 -4},
	 * 
	 * A solution set is: 
	 * (-1, 0, 1) 
	 * (-1, -1, 2)
	 */
	
	// two pointers; O(n) Space, O(n^2) Time;
	// http://www.ninechapter.com/solutions/3sum/
	// http://blog.csdn.net/linhuanmars/article/details/19711651
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length <= 2) {
			return result;
		}
		Arrays.sort(num); // 先排序！
		for (int i = 0; i < num.length - 2; i++) { // i最远可以取到倒数第三个
			if (i > 0 && num[i] == num[i - 1]) { // 略过和num[i - 1]值相同的所有元素
				continue;
			}
			int l = i + 1;
			int r = num.length - 1;
			while (l < r) {
				int sum = num[i] + num[l] + num[r];
				if (sum == 0) {// 得到了一组符合条件的三个数
					ArrayList<Integer> item = new ArrayList<Integer>();
					item.add(num[i]); // 顺序matters! 因为原题要求结果集中的元素从小到大排列。
					item.add(num[l]);
					item.add(num[r]);
					result.add(item);
					l++; // 【注】做l++及r--是因为，以后的结果一定不会再用l或r了（题目要求结果集不重复）
					r--;
					// 剔除重复的【注】此处应该为while而不是if,因为要一直删去素有重复的！
					while (l < r && num[l] == num[l - 1]) {// 【注】之所以不是num[l] == num[l+1]，是因为l刚++过，所以l是当前位子，而l-1才是上一个
						l++;
					}
					while (l < r && num[r] == num[r + 1]) {
						r--;
					}
				} else if (sum < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
		return result;
	}
}
