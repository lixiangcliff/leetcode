package Search_for_a_Range;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5, 7, 7, 8, 8, 10};
		//int[] A = {1,4};
		
		System.out.println((searchRange(A, 8))[0]);
		System.out.println((searchRange(A, 8))[1]);
	}

	//http://blog.csdn.net/linhuanmars/article/details/20593391
	//看图！
    public static int[] searchRange(int[] A, int target) {
    	int[] result = {-1, -1};
    	if(A == null || A.length == 0){
    		return result;
    	}
    	int ll = 0;
    	int lr = A.length -1;
        while (ll <= lr){
        	int m = (ll + lr)/2;
        	if (A[m] < target){
        		ll = m + 1;
        	}else{
        		lr = m - 1;
        	}
        }
        
    	int rl = 0;
    	int rr = A.length -1; 
        while (rl <= rr){
        	int m = (rl + rr)/2;
        	if (A[m] > target){
        		rr = m - 1;
        	}else{
        		rl = m + 1;
        	}
        }
        
        if (ll <= rr){
        	result[0] = ll;
        	result[1] = rr;
        }
        
        return result;   
    }
}
