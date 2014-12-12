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
/*	public static int maxProfit(int[] prices) {
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
	}*/
	
	//http://blog.csdn.net/linhuanmars/article/details/23162793
	public static int maxProfit(int[] prices) {  
	    if(prices==null || prices.length==0)  
	        return 0;  
	    int local = 0;  
	    int global = 0;  
	    for(int i=0;i<prices.length-1;i++)  
	    {   
	        //local means: if sell at current i, what is the biggest profit it can make
	    	local = Math.max(local+prices[i+1]-prices[i],0); 
	    	//global means: until current i, what is the biggest profit ever made
	        global = Math.max(local, global);  
	    }  
	    return global;  
	}
}
