package Candy;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] ratings = {1,2,3,2,4,2};
		System.out.println(q.candy(ratings));
	}
	
	/**
	 * There are N children standing in a line. Each child is assigned a rating
	 * value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors. What is the minimum candies you
	 * must give?
	 */
	
	//DP。之所以用DP思想，是因为每个小孩得到的糖数和他左边以及右边的有关，即状态和它前面的值有关，并且可以递推。
	//以从左往右扫时为例：
	//1.state: nums[i]表示小孩i应得多少candy
	//2.function: nums[i] = ratings[i] > ratings[i - 1] ? nums[i - 1] + 1 : 1;
	//3.initialize: nums[0] = 1
	//4.answer: sum(nums[i])（i = 0 ~ ratings[i].length - 1）
	//从右往左扫时类似，具体细节见下面代码
	//http://blog.csdn.net/linhuanmars/article/details/21424783
    public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] nums = new int[ratings.length];
		nums[0] = 1; // 从左往右的初始化
		//从左往右扫，如果遇到上升区间，就给当前小孩比左边多一个糖，否则就给1个糖果。
		for (int i = 1; i < ratings.length; i++) {
			nums[i] = ratings[i] > ratings[i - 1] ? nums[i - 1] + 1 : 1;
		}
		int result = nums[ratings.length - 1]; // 从右往左的初始化
		//从右往左扫，如果遇到上升区间，就给当前小孩比右边多一个糖，否则就给1个糖果。同时，应该与上一步算出的值取一个大值
		for (int i = ratings.length - 2; i >= 0; i--) {
			int current = ratings[i] > ratings[i + 1] ? nums[i + 1] + 1 : 1; //表示满足从右往左扫条件时，当前值是多少
			nums[i] = Math.max(nums[i], current); // nums[i]的最终值是从左往右扫和从右往左扫合法值中较大的一个
			result += nums[i]; // 累加result
		}
		return result;
    }

}
