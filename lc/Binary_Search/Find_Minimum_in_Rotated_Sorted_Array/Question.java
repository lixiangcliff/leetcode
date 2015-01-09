package Find_Minimum_in_Rotated_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] num = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(q.findMin(num));
	}
	
	/**
	 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element.
	 * You may assume no duplicate exists in the array.
	 */
	
	//Using Binary Search template
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
        	return Integer.MAX_VALUE;
        }
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	if (num[mid] < num[end]) { //“num[mid] < num[end]”和“右边有序”是等价的。所以min一定在左边
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        return Math.min(num[start], num[end]);
    }

}
