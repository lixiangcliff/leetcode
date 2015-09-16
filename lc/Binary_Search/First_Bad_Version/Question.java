package First_Bad_Version;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * You are a product manager and currently leading a team to develop a new product. 
	 * Unfortunately, the latest version of your product fails the quality check. 
	 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
	 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
	 * which causes all the following ones to be bad.
	 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
	 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
	 */
	
    public int firstBadVersion(int n) {
        if (n <= 1) { //invalid input
        	return n;
        }
        int l = 1;
        int r = n;
        while (l + 1 < r) {
        	int m = l + (r - l) / 2;
        	if (isBadVersion(m)) {
        		r = m;
        	} else {
        		l = m;
        	}
        }
        if (isBadVersion(l)) {
        	return l;
        }
        if (isBadVersion(r)) {
        	return r;
        }
        return n + 1; //failed to find any bad version
    }
    
    boolean isBadVersion(int version){
    	return false;
    }

}
