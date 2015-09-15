package Find_a_Peak;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] A = {1, 2, 1, 3, 4, 5, 7, 6};
		System.out.println(s.findPeak(A));
	}
	
    /**
     * http://www.lintcode.com/en/problem/find-peak-element/
	 * There is an integer array which has the following features:
	 * The numbers in adjacent positions are different.
	 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
	 * We define a position P is a peek if A[P] > A[P-1] && A[P] > A[P+1].
	 * Find a peak in this array. Return the index of the peak.
	 * Note The array may contains multiple peeks, find any of them.
	 * 
	 * Example [1, 2, 1, 3, 4, 5, 7, 6]
	 * return index 1 (which is number 2) or 6 (which is number 7)
	 * 
	 * Challenge Time complexity O(logN)
	 */
	
	
    public int findPeak(int[] A) {
    	if (A == null || A.length < 3){
    		return -1;
    	}
    	int start = 0;
    	int end = A.length - 1;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2; 
    		if (A[mid] < A[mid + 1]) { // 当前mid往右边看，如果升高的话，说明右边肯定有peak，把start挪到mid
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (A[start] > A[end]) {
    	    return start;
    	} else {
    	    return end;
    	}
    }

}
