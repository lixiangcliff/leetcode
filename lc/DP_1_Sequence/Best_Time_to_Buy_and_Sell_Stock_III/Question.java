package Best_Time_to_Buy_and_Sell_Stock_III;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	//
	//1.state: result[i][j]代表： 在前i天，进行j次交易，并且第j次卖出必须在第i天进行，最大profit的值。
	//2.function: 当S[i] != T[j]， result[i][j] = result[i - 1][j - 1] + （prices[i] - prices[i - 1]）
	//			      当S[i] == T[j]， result[i][j] = result[i - 1][j - 1] + result[i - 1][j]) （S[i]==T[i],则result[i - 1][j - 1]满足的都可以被result[i][j]所用）
	//3.initialize: result[0][j] = 0; 第一行（S为空，则没有任何办法可以从S中找到子串和T相同）
	//				result[i][0] = 1; 第一列（T为空，则只有一种办法从S中找到子串和T相同，即S也取空）
	//4.answer: result[A.length][B.length];
	//4.answer: max(result[0][2], result[1][2]...result[priecs.length][2]);
	//【注】result[][]和prices有位差
	
	//http://blog.csdn.net/linhuanmars/article/details/23236995
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length == 0){
    		return 0;
    	}
    	int[] global = new int[3];
    	int[] local = new int[3];
    	//global[0] = 0;
    	//local[0] = 0;
    	for(int i=1;i<prices.length;i++){
    		int diff = prices[i]-prices[i-1];
    		for(int j=2;j>=1;j--){
    			local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j]+diff);
    			global[j] = Math.max(global[j], local[j]);
    		}
    	}
    	return global[2];
    }

}
