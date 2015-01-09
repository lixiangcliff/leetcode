package Find_Minimum_in_Rotated_Sorted_Array_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//int[] num = {4, 5, 6, 7, 0, 1, 2};
		//int[] num = {3,3,3,3,3,1,2};
		//int[] num = {3,1,2,3,3,3,3};
		int[] num = {1,1,2,-1,0,1};
		System.out.println(q.findMin(num));
	}
	
	/**
	 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
	 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates
	 * are allowed?
	 * Would this affect the run-time complexity? How and why? Suppose a sorted
	 * array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element.
	 * The array may contain duplicates.
	 */
	
	//http://www.cnblogs.com/yuzhangcmu/p/4049117.html
	public int findMin(int[] num) {
		if(num == null || num.length ==0){
        	return Integer.MAX_VALUE;
        }
		int start = 0;
		int end = num.length - 1;
		
		while (start + 1 < end) {
			if (num[start] < num[end]) { // 这一句很重要，因为我们移除一些元素后，可能会使整个数组变得有序...
				return num[start];
			}
			int mid = start + (end - start) / 2;
			if (num[mid] < num [end]) {
				end = mid;
			} else if (num[mid] > num [end]) {
				start = mid;
			} else { // 如果num[mid] == num [end]， 则end左移1位
				end--;
			}
		}
		return Math.min(num[start], num[end]);
	}
}
