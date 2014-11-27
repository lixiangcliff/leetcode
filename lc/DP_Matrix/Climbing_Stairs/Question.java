package Climbing_Stairs;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(climbStairs(33));

	}
	
	/**
	 * https://oj.leetcode.com/problems/climbing-stairs/
	 * You are climbing a stair case. It takes n steps to reach to the top.
		Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	 */
	// http://answer.ninechapter.com/solutions/unique-paths/
	//1.state: result[i]表示从[0]到[i],一共有多少种不同走法
	//2.function: result[i] = result[i - 1] + result[i - 2];
	//3.initialize: result[0] = 1
	//				result[1] = 2
	//4.answer: result[n - 1]
	//DP 1D
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int[] result = new int[n];
		result[0] = 1;
		result[1] = 2;
		for (int i = 2; i < n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n - 1];
	}
	
	//naive recursive way
	//will NOT pass leetcodde because of "Time Limit Exceeded"
	/*
	 * for last climb you have and only have 2 way: 1 step or 2 step to finish;
	 * so to finish n stairs, we can group all methods into two groups
	 * group1 is to finish last climb by 1 step
	 * group2 is to finish last climb by 2 steps
	 * add them up we will get all methods;
	 * then we split the big problem into two small problems.
	 * i.e. 1. how we can leave 1 step before finish all n stairs
	 * 		2. how we can leave 2 step before finish all n stairs
	 * there comes the recursion
	 */
	public int climbStairsRecursive(int n) {
		if (n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		
		if(n==2){
			return 2;
		}
		return climbStairs(n-1)+climbStairs(n-2);         
    }

	//O(1)space的DP	
	//http://blog.csdn.net/linhuanmars/article/details/23976963
	//等同于Fibonacci
	public int climbStairsDP(int n){
		if (n <= 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int pre2 = 1; //cur前第2个值
		int pre1 = 2; //cur前第1个值
		int cur = 3; //当前值
		for (int i = 3; i <= n; i++) {
			cur = pre1 + pre2; //更新cur；
			pre2 = pre1; //要先更新pre2
			pre1 = cur;//然后更新 pre，因为上一步要用到pre1的值来更新pre2，如果先更新pre1，则之后给pre2的值就是错的。
		}
		return pre1;
	}

}
