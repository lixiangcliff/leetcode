package Single_Number_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 6,2,3,2,1,3,6,1,2,3,7,6};
		System.out.println(singleNumber(A));

	}
	
	
	//normal way
	//http://answer.ninechapter.com/solutions/single-number-ii/
	 public static int singleNumber(int[] A) {
	        if (A == null || A.length == 0) {
	            return -1;
	        }
	        int result=0;
	        int[] bits=new int[32];
	        for (int i = 0; i < 32; i++) { //for each bit, to process out the final value for result
	            for(int j = 0; j < A.length; j++) {
	                bits[i] += A[j] >> i & 1;
	                bits[i] %= 3;
	            }
	            result |= (bits[i] << i); //after process out the value for this bit, add it up into result
	        }
	        return result;
	    }
	 
	//nb method
	//http://www.cnblogs.com/daijinqiao/p/3352893.html or http://www.acmerblog.com/leetcode-single-number-ii-5394.html
	//honestly not quite understand
	/*public static int singleNumber(int[] A) {
		int ones = 0, twos = 0, xthrees = 0;
	    for(int i = 0; i < A.length; ++i) {
	        twos |= (ones & A[i]);
	        ones ^= A[i];
	        xthrees = ~(ones & twos);
	        ones &= xthrees;
	        twos &= xthrees;
	    }
	    return ones;
        
    }*/
	
	

}
