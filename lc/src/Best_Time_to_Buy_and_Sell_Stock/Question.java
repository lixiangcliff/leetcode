package Best_Time_to_Buy_and_Sell_Stock;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 6, 3,20, 4, 10};
		System.out.println(maxProfit(prices));

	}
	
	/*public static int maxProfit(int[] prices) {
		if (prices.length <=1){
			return 0;
		}
		int max = 0;
		for (int i=1; i<prices.length;i++){
			int min=findMin(prices,i);
			if (prices[i] - min > max){
				max = prices[i] - min;
			}
		}		
        return max;
    }
	
	public static int findMin(int[] prices, int pos){
		if (prices.length <1){
			return 0;
		}
		int min=prices[0];
		for (int i=0;i<pos;i++){
			if (prices[i] < min){
				min=prices[i];
			}
		}
		return min;
	}
*/
	public static int maxProfit(int[] prices) {
	    if (prices.length <=1){
	        return 0;
	    }
	    int maxProfit = 0;
	    int minPrice = prices[0];
	    for(int i=1;i<prices.length;i++){
	        maxProfit = Math.max(maxProfit, prices[i]-minPrice);
	        minPrice = Math.min(minPrice, prices[i]);
	    }
	    return maxProfit;
	}
}
