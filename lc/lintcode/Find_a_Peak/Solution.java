package Find_a_Peak;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
    	if (A == null || A.length < 3){
    		return -1;
    	}
    	int start = 0;
    	int end = A.length - 1;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2; 
    		if (A[mid] < A[mid + 1]) { //当前mid往右边看，如果升高的话，说明右边肯定有peak，把start挪到mid
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	
    	return Math.max(start, end);
    }

}
