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
    public static int[] searchRange(int[] A, int target) {
    	int l = 0;
    	int r = A.length -1;
    	int[] result = {-1, -1};
        while(l<=r){
        	int mid = (l+r)/2;
        	if (A[mid] == target){ // find it
        		int ll = 0;
        		int rr = A.length -1;
        		int mm = mid;
        		int k = 0;
        		while(ll<=mm){ // process left part of found target
        			k = (ll+mm)/2;
        			if(target == A[k]){
        				mm = k-1; // start of "target" is on left side of k
        			}else{
        				//ll is the first value of target;mm is last value of non-target
        				ll = k+1; // start of "target" is on right side of k; 
        			}
        		}

        		result[0] = ll;
        		mm = mid;
        		while(mm<=rr){ // process right part of found target
        			k = (mm+rr)/2;
        			if(target == A[k]){
        				mm = k+1; // end of "target" is on right side of k
        			}else{
        				//rr is the last value of target;mm is first value of non-target
        				rr = k-1; // end of "target" is on left side of k
        			}
        		}
        		result[1] = rr;
        		return result;
        		
        	}else if(A[mid] < target){
        		l = mid+1;
        	}else{
        		r = mid-1;
        	}
        }
        return result;   
    }
}
