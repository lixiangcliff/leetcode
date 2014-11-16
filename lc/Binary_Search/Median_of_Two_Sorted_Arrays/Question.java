package Median_of_Two_Sorted_Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {2,4,8,10};
		int[] B = {1,3,5,7,9,11,13};
/*		int[] A = {1};
		int[] B = {2,3,4};*/
		
		System.out.println(findMedianSortedArrays(A, B));
		
	}
	
	//这个code更易懂好记 http://www.ninechapter.com/solutions/median-of-two-sorted-arrays/ 
	//思路两者一样：http://blog.csdn.net/linhuanmars/article/details/19905515
	//看图！
	//try using min and max heap later
	//http://blog.csdn.net/yutianzuijin/article/details/11499917
    public static double findMedianSortedArrays(int A[], int B[]) {
    	int len = A.length + B.length; 
        if (len % 2 == 1){
        	//i2 or j2 means the last item in their array
        	//A，B长度和为奇数，则取中间的一个值（和除以二，向下取整，再+1）
        	return helper(A, 0, B, 0, len / 2 + 1);
        }else{
        	//A，B长度和为偶数，则取中间两个值得平均数（和除以二，向下取整作为第一个数，再+1作为第二个数；再取平均）
        	return (helper(A, 0, B, 0, len / 2) + helper(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
    }
    
    //A_start为当前A中剩余待处理元素的起始位置，k表示取在当前剩余A和B长度和中第k个元素
    private static double helper(int[] A, int A_start, int[] B, int B_start, int k){
    	if (A_start >= A.length){//如果A中已经有元素（可以处理），则返回B中第k个元素
    		return B[B_start + k -1];
    	}
    	if (B_start >= B.length){
    		return A[A_start + k -1];
    	}
    	if (k == 1){//A和B都只剩一个待处理的元素
    		return Math.min(A[A_start], B[B_start]);
    	}
    	//得到A中第k/2的位置的值。看图！(之所以后面补的是Integer.MAX_VALUE，是因为数组是递增的)
    	int A_halfK_value = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
    	int B_halfK_value = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
    	if (A_halfK_value < B_halfK_value){//说明A_halfK_value之前的全都比A和B长度和第k个位置的值小，所以剔除之（A_halfK_value左边的值并且包括A_halfK_value）
    		//A_start从A_halfK_value的下一位（A_start + k / 2 - 1　+ 1 == A_start + k / 2）开始，B start的位置不变 , k减去 剔除的A_start左边的那部分（即k/2）
    		return helper(A, A_start + k / 2, B, B_start, k - k / 2);
    	}else{
    		return helper(A, A_start, B, B_start + k / 2, k - k / 2);
    	}
    }

}
