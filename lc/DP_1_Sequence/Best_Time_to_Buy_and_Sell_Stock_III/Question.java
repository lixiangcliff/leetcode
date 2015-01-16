package Best_Time_to_Buy_and_Sell_Stock_III;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] prices = {2,1,2,0,1};
		System.out.println(q.maxProfit(prices));
	}
	
	/**
	 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 */
	
	//类似Best Time to Buy and Sell Stock I。
	//思想：想象有一个挡板从左移动到右。左边卖一次，右边卖一次。于是创建两个DP数组，left[]和right[]
	//left表示正序着看，从第一天到第i天，卖1次最大收益（不一定要在第i天卖）；不断记录更新的是min值。
	//right表示倒序着看，从最后一天到第i天，卖1次最大收益（不一定要在第i天买）；不断记录更新的是max值。
	//最后遍历原数组，找到max(left[i] + right[i])
	//【注】从左往右，要不断记录更新的是min值；从右往左时,要不断记录更新的是max值。
	//此题无位差
	//http://www.ninechapter.com/solutions/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
    	int len = prices.length;
    	int[] left = new int[len];
    	int[] right = new int[len];
    	left[0] = 0; // left[i]表示从第0天到第i天只卖一次的最大收益
    	right[len - 1] = 0; // right[i]表示从第i天到最后一天只卖一次的最大收益
    	//得到left[]
    	int min = prices[0];
    	int maxProfitUntilToday = 0;
		for (int i = 1; i < len; i++) {
			min = Math.min(min, prices[i]);
			int profitSellToday = prices[i] - min;
			maxProfitUntilToday = Math.max(maxProfitUntilToday, profitSellToday);
			left[i] = maxProfitUntilToday; // 因为不一定要在第i天卖。可见left[]从左到右一定是递增的
		}
		//得到right[]
		int max = prices[len - 1];
		int maxProfitFromToday = 0;
		for (int i = len - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			int profitBuyToday = max - prices[i];
			maxProfitFromToday = Math.max(maxProfitFromToday, profitBuyToday);
			right[i] = maxProfitFromToday; // 可见right[]从左到右也一定是递增的
		}
		int maxTotalProfit = 0;
		//遍历每一天，得到max
		for (int i = 0; i < len; i++) {
			maxTotalProfit = Math.max(maxTotalProfit, left[i] + right[i]);
		}
    	return maxTotalProfit;
    }

}
