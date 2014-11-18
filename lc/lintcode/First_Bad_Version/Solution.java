package First_Bad_Version;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	boolean isBadVersion(int version){
		return true;
	}
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
    	if (n <= 0){
    		return -1;
    	}
    	int start = 1;
    	int end = n;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (VersionControl.isBadVersion(mid)){
    			end = mid;
    		} else {
    			start = mid;
    		}
    	}
    	
    	if (VersionControl.isBadVersion(start)) {
    		return start;
    	}
    	if (VersionControl.isBadVersion(end)) {
    		return end;
    	}
    	return n+1;//means error
    }

}

class VersionControl {
	      public static boolean isBadVersion(int k){
	    	  return true;
	  }
}