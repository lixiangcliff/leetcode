package Median_of_Two_Sorted_Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] A = {2,4,8,10};
		int[] B = {1,3,5,7,9,11,13};
/*		int[] A = {1};
		int[] B = {2,3,4};*/
		
		System.out.println(q.findMedianSortedArrays(A, B));
		
	}
	
	/**
	 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 */
	
	//这个code更易懂好记 http://www.ninechapter.com/solutions/median-of-two-sorted-arrays/ 
	//思路两者一样：http://blog.csdn.net/linhuanmars/article/details/19905515
	//看图！
	//问题等价于求两个array的第k=(m+n)/2（假设m和n分别是两个数组的元素个数）大的数是多少。
	//基本思路是每次通过查看两个数组的第k/2大的数(假设是A[k/2],B[k/2])，如果两个A[k/2]=B[k/2]，说明当前这个数即为两个数组剩余元素的第k大的数，
	//如果A[k/2]>B[k/2], 那么说明B的前k/2个元素都不是我们要的第k大的数，反之则排除A的前k/2个，如此每次可以排除k/2个元素，
	//最终k=1时即为结果。
	//try using min and max heap later
	//http://blog.csdn.net/yutianzuijin/article/details/11499917
    public double findMedianSortedArrays(int A[], int B[]) {
    	int len = A.length + B.length; 
        if (len % 2 == 1){
        	//A，B长度和为奇数，则取中间的一个值（和除以二，向下取整，再+1）
        	return helper(A, 0, B, 0, len / 2 + 1);
        }else{
        	//A，B长度和为偶数，则取中间两个值得平均数（和除以二，向下取整作为第一个数，再+1作为第二个数；再取平均）。用举例法
        	return (helper(A, 0, B, 0, len / 2) + helper(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
    }
    
    //A_start为当前A中剩余待处理元素的起始位置(B_start类似)，k表示取在当前剩余A和B长度和中第k个元素
    private double helper(int[] A, int startA, int[] B, int startB, int k) {
    	//【注】这个要先于k == 1操作。否则会fail corner case：
    	// Runtime Error Message:Line 16: java.lang.ArrayIndexOutOfBoundsException: 0; Last executed input:[], [1]
    	if (startA >= A.length) {//如果A中元素已经全部处理完了，则返回B中第k个元素
    		return B[startB + k - 1];
    	}
    	if (startB >= B.length) {
    		return A[startA + k - 1];
    	}
    	if (k == 1) {//A和B都只剩一个待处理的元素
    		return Math.min(A[startA], B[startB]);
    	}
        int halfKSize = k / 2 - 1; // -1是因为索引本身是从0开始的。而前k大元素含有k个元素。
        //得到A中第k/2的位置的值。看图！边界举例。(之所以后面补的是Integer.MAX_VALUE，是因为数组是递增的)
    	int halfKValueA = startA + halfKSize < A.length ? A[startA + halfKSize] : Integer.MAX_VALUE;
    	int halfKValueB = startB + halfKSize < B.length ? B[startB + halfKSize] : Integer.MAX_VALUE;
        int kNew = k - k / 2; //因为丢弃了k / 2个元素
    	if (halfKValueA < halfKValueB){//说明A_halfK_value之前的全都比A和B长度和第k个位置的值小，所以剔除之（A_halfK_value左边的值并且包括A_halfK_value）
    		//A_start从A_halfK_value的下一位（A_start + k / 2 - 1　+ 1 == A_start + k / 2）开始，B start的位置不变 , k减去 剔除的A_start左边的那部分（即k/2）
    		return helper(A, startA + k / 2, B, startB, kNew);
    	}else{
    		return helper(A, startA, B, startB + k / 2, kNew);
    	}
    }

}
