package Best_Time_to_Buy_and_Sell_Stock_III;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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
