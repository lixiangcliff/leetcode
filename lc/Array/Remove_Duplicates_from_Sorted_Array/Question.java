package Remove_Duplicates_from_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Question q = new Question();
		int[] A = {1,1,2,3,4,4,5,5,5,5,5,5,6,7,7,7,7};
		//int[] A = {1};
		// TODO Auto-generated method stub
		int length = q.removeDuplicates(A);
		System.out.println("length: " + length);
		for (int i=0;i<length;i++){
			System.out.print(A[i] + ",");
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array A = [1,1,2],
	 * Your function should return length = 2, and A is now [1,2].
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/20023993
    public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		// index表示的值有两层含义:
		// 1.它作为一个位标记，凡是它左边的都是比较过之后确保没有重复的元素
		// 2.同时它也从数值上表示了左半边数组的长度
		// 【注】这种一举两得的方式经常遇到
		int index = 1; // 
		for (int i = 1; i < A.length; i++) { // i可以理解为two pointer中的那个runner
			if (A[i - 1] != A[i]) { // 比较相邻两个数，只有不相等才更新index位上的值; 否则什么也不做，相当于 continue
				A[index++] = A[i]; // 更细完index位的值之后，index++；
			}
		}
		return index; // index可以表示左半边数组长度，可以直接返回
    }

}
