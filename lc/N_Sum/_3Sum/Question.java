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
	// two pointers; O(1) Space, O(nlogn) Time;
	// http://blog.csdn.net/linhuanmars/article/details/19711651
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length <= 2){
			return result;
		}
		//先排序！
		Arrays.sort(num);
		//【注】也可以从后往前扫，这样后面在tempResult里add(num[i])时候效率更高(因为题目要求返回结果中的每个ArrayList都要升序排列)，但是写起来边界有trick；
		for(int i = 0; i < num.length; i++){
			//略过和num[i - 1]值相同的所有元素
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			//得到一个不含num[i]，但是其余两值之和为-num[i]的一系列ArrayList<Integer>
			ArrayList<ArrayList<Integer>> tempResult = twoSum(num, -num[i], i + 1);
			for(int j = 0; j < tempResult.size(); j++){
				tempResult.get(j).add(0, num[i]); // 因为num[i]肯定比tempResult.get(j)里面的元素index更靠前，所以要插入首位。
			}
			result.addAll(tempResult);
		}
		return result;
	}
	
	//subroutine
	//http://blog.csdn.net/linhuanmars/article/details/19711387
	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int target, int start){
		ArrayList<ArrayList<Integer>> tempResult = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length <= 1){
			return tempResult;
		}
		int l = start;
		int r = num.length - 1;
		while (l < r) {
			if (num[l] + num[r] == target) {// 得到了一对儿
				ArrayList<Integer> item = new ArrayList<Integer>();
				item.add(num[l]);// 顺序matters! 因为原题要求结果集中的元素从小到大排列。
				item.add(num[r]);
				tempResult.add(item);
				// 【注】做l++及r--是因为，以后的结果一定不会再用l或r了（题目要求结果集不重复）
				l++;
				r--;
				// 剔除重复的
				// 【注】此处应该为while而不是if,因为要一直删去素有重复的！
				while (l < r && num[l] == num[l - 1]) {// 【注】之所以不是num[l] == num[l+1]，是因为l刚++过，所以l是当前位子，而l-1才是上一个
					l++;
				}
				while (l < r && num[r] == num[r + 1]) {
					r--;
				}
			} else if (num[l] + num[r] < target) {
				l++;
			} else {
				r--;
			}
		}
		return tempResult;
	}

}
