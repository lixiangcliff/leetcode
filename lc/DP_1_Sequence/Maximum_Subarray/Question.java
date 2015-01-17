package Maximum_Subarray;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int A[] = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(q.maxSubArray(A));
		

	}
	
	/**
	 * https://oj.leetcode.com/problems/maximum-subarray/
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
	 * subarray [4,−1,2,1] has the largest sum = 6.
	 * 
	 * click to show more practice.
	 * 
	 * More practice: If you have figured out the O(n) solution, try coding
	 * another solution using the divide and conquer approach, which is more
	 * subtle.
	 */
	
	//DP 1Seq
	//非常类似:http://lintcode.com/en/problem/longest-increasing-subsequence/
	//1.state: result[i]代表直到前i个字符，包涵i最大的sum值
	//2.function: 当result[i - 1] < 0, result[i] = A[i] (即对于result[i]来说因为result[i - 1]为负数，加上它还不如不加)
	//			      当result[i - 1] >= 0, result[i] = A[i] + result[i - 1] (result[i - 1]为正数，加上它会使sum变大，所以就加上)
	//3.initialize: result[1] = A[0];（即 如果一个元素都没有，那么sum为极小值）
	//4.answer: max(result[1]...result[nums.length];
	//有位差
	public int maxSubArray(int[] A) {  
		if (A == null || A.length == 0) {
			return Integer.MIN_VALUE;
		}
		int[] result = new int[A.length + 1];
		int maxSum = A[0];
		result[1] = A[0];
		for (int i = 2; i <= A.length; i++) {
			if (result[i - 1] < 0) {
				result[i] = A[i - 1]; //位差
			} else {
				result[i] = A[i - 1] + result[i - 1];
			}
			maxSum = Math.max(result[i], maxSum);
		}
		return maxSum;
	}
	
	
	//divide and conquer
	//http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
/*	public int maxSubArray(int[] A) {
		return maxSubArraySum(A, 0, A.length-1);		
	}
	
	public int maxSubArraySum(int arr[], int l, int h)
	{
	   // Base Case: Only one element
	   if (l == h)
	     return arr[l];
	 
	   // Find middle point
	   int m = (l + h)/2;
	 
	    Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint 
	   return Math.max(Math.max(maxSubArraySum(arr, l, m),
	              maxSubArraySum(arr, m+1, h)),
	              maxCrossingSum(arr, l, m, h));
	   
	}
	
	public int maxCrossingSum(int arr[], int l, int m, int h)
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
	}*/
	
	
}
