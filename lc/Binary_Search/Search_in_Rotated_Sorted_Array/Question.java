package Search_in_Rotated_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,0,1,2};
		System.out.println(search(A, 5));

	}
	
	/**
	 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * You may assume no duplicate exists in the array.
	 */
	//用BST模板
	//http://blog.csdn.net/linhuanmars/article/details/20525681
	//看图！（此题元素不重复）
    public static int search(int[] A, int target) {
    	if(A == null || A.length == 0){
    		return -1;
    	}
    	int start = 0;
    	int end = A.length-1;
    	while(start + 1 < end){
    		int mid = start+(end - start) / 2;
    		if (target == A[mid]){//找到target
    			return mid;
    		}
    		if(A[mid] < A[end]){//说明从mid到end这一部分是有序的
    			if(A[mid] <= target && target <= A[end]){ 
    				start = mid; //如果target在这一部分，更新左边界start变为m
    			}else{
    				end = mid; //如果target不在这一部分，更新右边界end变为mid
    			}
    		}else{	//说明从l到m这一部分是有序的
    			if(A[start] <= target && target <= A[mid]){
    				end = mid; //如果target在这一部分，更新右边界end变为mid
    			}else{
    				start = mid; //如果target不在这一部分，更新左边界start变为mid
    			}
    		}
    	}
    	
    	if (A[start] == target){
    		return start;
    	}
    	if (A[end] == target){
    		return end;
    	}
    	
        return -1; //没找到
    }

}
