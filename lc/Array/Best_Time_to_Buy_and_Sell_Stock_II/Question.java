package Best_Time_to_Buy_and_Sell_Stock_II;

public class Question {

	/**
	 * @param args
	 */
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {15, 1, 3,2, 10, 20,7,8,11};
		Question q = new Question();
		System.out.println(q.maxProfit(prices));

	}
	
	/**
	 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */
	
	//要先买后卖(最多可以有n - 1次transaction); 
	//只要第i天比第i - 1天的价格高，就在第i - 1天买入，第i天卖出。（即使本来在第i - 1天打算卖出也没关系，因为同一天可以既买入，又卖出）
	//http://blog.csdn.net/linhuanmars/article/details/23164149
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				max += prices[i] - prices[i - 1];
			}
		}
		return max;
	}
}
