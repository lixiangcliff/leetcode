package Best_Time_to_Buy_and_Sell_Stock;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 6, 3,20, 4, 10};
		Question q = new Question();
		System.out.println(q.maxProfit(prices));

	}
	
	/**
	 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i. If you were only permitted to complete at most one
	 * transaction (ie, buy one and sell one share of the stock), design an
	 * algorithm to find the maximum profit.
	 */
	
	//DP 1Seq O(n) space
	//1.state: result[i]代表直到前i天，在第i天卖出股票，所获得的最大profit值。
	//		   minPrice直到i最小的price值	
	//2.function: result[i] = prices[i] - minPrice
	//3.initialize: result[1] = 0;（即第1天就卖，相当于当天买卖，profit为0）
	//4.answer: max(result[0], result[1]...result[nums.length];
	//【注】result和prices有位差
	//http://blog.csdn.net/linhuanmars/article/details/23162793
	public int maxProfit(int[] prices) {  
	    if (prices == null || prices.length==0) {  
	        return 0;
	    }
	    int[] result = new int[prices.length + 1];
	    result[1] = 0;
	    int max = 0;
	    int minPrice = prices[0];
	    for (int i = 2; i <= prices.length; i++) {
	    	minPrice = Math.min(minPrice, prices[i - 1]); //位差
	    	result[i] = prices[i - 1] - minPrice;
	    	max = Math.max(max, result[i]);
	    }
	    return max;
	}
	
	//O(1) space
	public int maxProfitBigO_1_space(int[] prices) {  
	    if (prices == null || prices.length==0) {  
	        return 0;
	    }
	    int result = 0;
	    int min = prices[0];
	    for (int i = 1; i < prices.length; i++) {
	    	min = Math.min(min, prices[i]);
	    	int curProfit = prices[i] - min;
	    	result = Math.max(result, curProfit);
	    }
	    return result;
	}
}
