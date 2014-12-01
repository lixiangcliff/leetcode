package _3Sum;

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
	//http://blog.csdn.net/linhuanmars/article/details/19711651
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length <= 2){
			return result;
		}
		//先排序！
		Arrays.sort(num);
		//从后往前扫，是因为后面在tempResult里add(num[i])时候方便(因为题目要求返回结果中的每个ArrayList都要升序排列)；
		//否则要是从前往后扫，就要"insert"在每个tempResult的结果的最前面才行
		for(int i = num.length-1; i >= 2 ;i--){
			/*
			 * if(i<=num.length-1 && num[i-1]==num[i])  这样做不行！
			 * 这个testcase没过：
			 *  Input:	[0,0,0]
				Output:	[]
				Expected:	[[0,0,0]]
			 */
			//略过和num[i+1]值相同的所有元素
			if(i<num.length-1 && num[i] == num[i+1]){
				continue;
			}
			//得到一个不含num[i]，但是其余两值之和为-num[i]的一系列ArrayList<Integer>
			ArrayList<ArrayList<Integer>> tempResult = twoSum(num, i-1, -num[i]);
			for(int j = 0; j < tempResult.size(); j++){
				tempResult.get(j).add(num[i]);
			}
			result.addAll(tempResult);
		}
		return result;
	}
	
	//subroutine
	//http://blog.csdn.net/linhuanmars/article/details/19711387
	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target){
		ArrayList<ArrayList<Integer>> tempResult = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length <=1){
			return tempResult;
		}
		int l = 0;
		int r = end;
		while(l<r){
			if(num[l] + num[r] == target){//得到了一对儿
				ArrayList<Integer> item = new ArrayList<Integer>();
				item.add(num[l]);//顺序matters!
				item.add(num[r]);
				tempResult.add(item);
				//做l++及r--是因为，以后的结果一定不会再用l或r了（题目要求结果集不重复）
				l++;
				r--;
				//剔除重复的
				//【注】此处应该为while而不是if,因为要一直删去素有重复的！
				while(l < r && num[l] ==  num[l-1]){//之所以不是num[l] == num[l+1]，是因为l刚++过，所以l是当前位子，而l-1才是上一个
					l++;
				}
				while(l < r && num[r] ==  num[r+1]){
					r--;
				}
			}else if (num[l] + num[r] < target){
				l++;
			}else{
				r--;
			}
		}
		return tempResult;
	}

}
