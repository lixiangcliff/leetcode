package Maximum_Subarray;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(A));

	}
/*public static int maxSubArray(int[] A) {
	if(A.length == 0){
		return 0;
	}
	int max = A[0];
	int[] sum = new int[A.length];
	sum[0] = A[0];
	for(int i=1; i<A.length; i++){
		sum[i] = Math.max(A[i], sum[i-1]+A[i]);// that means if sum[i-1] is negative, we abandon sum[i-1];
		max = Math.max(max, sum[i]);
	}
	
        return max;
    }*/
	//reduce space
/*	public static int maxSubArray(int[] A) {
		if(A.length == 0){
			return 0;
		}
		int sum = A[0];
		int maxSum = A[0];
		for(int i=1; i<A.length;i++){
			sum = Math.max(A[i], A[i]+sum); // if A[i] is negative, abandon it.
			maxSum = Math.max(sum, maxSum);
		}
		
		return maxSum;
	    }*/
	
	//divide and conquer
	//http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
	public static int maxSubArray(int[] A) {
		return maxSubArraySum(A, 0, A.length-1);		
	}
	
	public static int maxSubArraySum(int arr[], int l, int h)
	{
	   // Base Case: Only one element
	   if (l == h)
	     return arr[l];
	 
	   // Find middle point
	   int m = (l + h)/2;
	 
	   /* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
	   return Math.max(Math.max(maxSubArraySum(arr, l, m),
	              maxSubArraySum(arr, m+1, h)),
	              maxCrossingSum(arr, l, m, h));
	   
	}
	
	public static int maxCrossingSum(int arr[], int l, int m, int h)
	{
	    // Include elements on left of mid.
	    int sum = 0;
	    int left_sum = Integer.MIN_VALUE;
	    for (int i = m; i >= l; i--)
	    {
	        sum = sum + arr[i];
	        if (sum > left_sum)
	          left_sum = sum;
	    }
	 
	    // Include elements on right of mid
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= h; i++)
	    {
	        sum = sum + arr[i];
	        if (sum > right_sum)
	          right_sum = sum;
	    }
	 
	    // Return sum of elements on left and right of mid
	    return left_sum + right_sum;
	}


}
