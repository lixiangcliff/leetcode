package Maximum_Product_Subarray;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,-2,4};
		System.out.println(maxProduct(A));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/39537283
    public static int maxProduct(int[] A) {
        if(A == null || A.length == 0){
        	return 0;
        }
        if(A.length == 1){
        	return A[0];
        }
        int globalMax = A[0];
        int localMax = A[0];
        int localMin= A[0];
        for(int i=1; i<A.length; i++){
        	int localMaxCopy = localMax;
        	localMax = Math.max(Math.max(A[i], A[i]*localMax), A[i]*localMin);
        	localMin = Math.min(Math.min(A[i], A[i]*localMaxCopy), A[i]*localMin);
        	globalMax = Math.max(localMax, globalMax);
        }
        return globalMax;
    }

}
