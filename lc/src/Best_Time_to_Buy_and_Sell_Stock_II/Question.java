package Best_Time_to_Buy_and_Sell_Stock_II;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {15, 1, 3,2, 10, 20,7,8,11};
		System.out.println(maxProfit(prices));

	}
	/*
     * misunderstand the question, actually "you can only hold 1 stock at most for any time."
     * Here is the comment from the forum "If you are already holding a stock, buying another stock is considered two transactions."
     */
	/*public static int maxProfit(int[] prices) {
	    if (prices.length <=1){
	        return 0;
	    }
	    int maxProfit = 0;
	    int[] orders = new int [prices.length];
		int[] pricesCopy = new int [prices.length];
		System.arraycopy( prices, 0, pricesCopy, 0, prices.length );
		for (int i = 0; i<orders.length;i++){
			int k = findMaxPostion(pricesCopy);
			orders[i] = k;
			pricesCopy[k] = -1;
		}
		for (int i=0;i <orders.length; i++ ){
			System.out.print(orders[i]+",");
		}
		int i=0;
		int j=prices.length-1;
		while(i<j){
			if (orders[i]>orders[j]){
				maxProfit = maxProfit + prices[orders[i]] - prices[orders[j]];
				i++;
				j--;
			}else{
				i++;
			}
		}
	    return maxProfit;
	}
	
	public static int findMaxPostion(int[] prices){
		if (prices.length<1){
			return 0;
		}
		int max=prices[0];
		int k=0;
		for (int i=0;i<prices.length;i++){
			if (prices[i] > max){
				max=prices[i];
				k = i;
			}
		}
		return k;
	}*/
	
	//explanation 
	//buy first and sell second(n-1 transaction at the most); 
	//as long as today is higher than yesterday, sell it!
	//http://blog.csdn.net/linhuanmars/article/details/23164149
	public static int maxProfit(int[] prices) {
	    if (prices.length <=1){
	        return 0;
	    }
	    int maxProfit = 0;
	    for(int i = 1; i < prices.length; i++){
	        maxProfit += Math.max(0, prices[i]-prices[i-1]);
	    }
	    return maxProfit;
	}
}
