package Trapping_Rain_Water;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));

	}
	
	//http://obcerver.com/post/view/p/21
 /*   public static int trap(int[] A) {
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	int n = A.length;
    	int[] highestLeft = new int[n];
    	int[] highestRight = new int[n];
    	
    	int max = 0;
    	highestLeft[0] = 0;
    	for(int i=1;i<n;i++){
    		if(A[i-1] > max){
    			max = A[i-1];
    		}
    		highestLeft[i] = max;
    	}
    	
    	max = 0;
    	highestRight[n-1] = 0;
    	for(int i=n-2;i>=0;i--){
    		if(A[i+1] > max){
    			max = A[i+1];
    		}
    		highestRight[i] = max;
    	}
    	int water = 0;
    	for(int i = 0;i<n;i++){
    		int current = Math.min(highestLeft[i], highestRight[i]) - A[i];
    		if(current > 0){
    			water += current;
    		}
    	}
    	
        return water;
    }*/
	
	//enhancement use 2*O(n) instead of 3*O(n)
	//http://blog.unieagle.net/2012/10/31/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Atrapping-rain-water/
    public static int trap(int[] A) {
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	int n = A.length;
    	int[] highestLeft = new int[n];
    	int[] highestRight = new int[n];
    	
    	int max = 0;
    	highestLeft[0] = 0;
    	for(int i=1;i<n;i++){
    		if(A[i-1] > max){
    			max = A[i-1];
    		}
    		highestLeft[i] = max;
    	}
    	
    	max = A[n-1];
    	highestRight[n-1] = 0;

    	int water = 0;
    	for(int i=n-2;i>=0;i--){
    		highestRight[i] = max;
    		int current = Math.min(highestLeft[i], highestRight[i]) - A[i];
    		if(current > 0){
    			water += current;
    		}
    		if(A[i] > max){
    			max = A[i];
    		}   		
    	}
    	
        return water;
    }

}
