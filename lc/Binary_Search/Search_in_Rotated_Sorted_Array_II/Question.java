package Search_in_Rotated_Sorted_Array_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,0,1,2};
		System.out.println(search(A, 9));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/20588511
	//http://answer.ninechapter.com/solutions/search-in-rotated-sorted-array-ii/
    public static boolean search(int[] A, int target) {
    	if(A == null || A.length == 0){
    		return false;
    	}
    	int l = 0;
    	int r = A.length-1;
    	while(l<=r){
    		int m = (l+r)/2;
    		if (target == A[m]){
    			return true;
    		}
    		if(A[m] < A[r]){
    			if(A[m] <= target && target <= A[r]){
    				l = m+1;
    			}else{
    				r = m-1;
    			}
    		}else if(A[m] > A[r]){
    			if(A[l] <= target && target <= A[m]){
    				r = m-1;
    			}else{
    				l = m+1;
    			}
    		}else{
    			r--;
    		}
    	}    	
        return false;
    }

}
