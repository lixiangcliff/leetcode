package Gas_Station;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gas[] = {1,2,3,4,5};
		int cost[] = {3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas, cost));
	}
	
	//TLE leetcode...
/*    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	if (gas == null || cost == null || gas.length == 0 || cost.length == 0){
    		return -1;
    	}
    	if (gas.length == 1 && cost.length == 1){
    		return gas[0] > cost[0] ? 0 : -1;
    	}
    	int n = gas.length;
    	for(int i=0;i<n; i++){
    		if (gas[i] >= cost[i]){
    			int gasSum = gas[i];
    			int costSum = cost[i];
    			int next = getNext(i, n);
    			while(next !=i){
    				gasSum += gas[next];
    				costSum += cost[next];
    				if(gasSum < costSum){
    					break;
    				}
    				next = getNext(i, n);
    			}
    			if(next == i){
    				return i;
    			}
    		}
    	}
        return -1;
    }
    
    private static int getNext(int i, int n){
    	return i== n-1 ? 0 : i+1;
    }*/
	
	//http://leetcodenotes.wordpress.com/2013/11/21/leetcode-gas-station-%E8%BD%AC%E5%9C%88%E7%9A%84%E5%8A%A0%E6%B2%B9%E7%AB%99%E7%9C%8B%E8%83%BD%E4%B8%8D%E8%83%BD%E8%B5%B0%E4%B8%80%E5%9C%88/
	//http://blog.csdn.net/linhuanmars/article/details/22706553
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		//sum += gas[j] – cost[j]
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length){
    		return -1;
    	}
		return 0;
		
	}
}
