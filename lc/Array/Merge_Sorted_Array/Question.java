package Merge_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] A = {1,3,5,7,0,0,0};
		int[] B = {2,6,8};
		//int[] B = {};
		int aLen = 4;
		q.merge(A, aLen, B, B.length);
		for(int i=0;i< aLen+B.length;i++){
			System.out.println(A[i]+ ",");
		}

	}

	/**
	 * https://oj.leetcode.com/problems/merge-sorted-array/
	 * Given two sorted integer arrays A and B, merge B into A as one sorted
	 * array.
	 * 
	 * Note: You may assume that A has enough space (size that is greater or
	 * equal to m + n) to hold additional elements from B. The number of
	 * elements initialized in A and B are m and n respectively.
	 */
	
	public void merge(int A[], int m, int B[], int n){
		//【注】此处不能用“m == 0” 当做条件来判断， 因为，如果A中内容都为空，我们仍然要把B merge到A里，而不是什么都不做就return
		if (A == null || B == null || A.length == 0 || B.length == 0) {
			return;
		}
		//【注】技巧：从后往前扫，以避免覆盖还未做比较的元素
		int aEnd = m - 1;
		int bEnd = n - 1;
		int end = m + n - 1; // 画图举例最稳妥
		while (aEnd >= 0 && bEnd >= 0) { //终止条件：A和B任何一个处理完了就跳出循环
			if (A[aEnd] > B[bEnd]) { // 谁大就把谁放入当前位置
				A[end--] = A[aEnd--];
			} else {
				A[end--] = B[bEnd--];
			}
		}
		while (bEnd >= 0) { //如果B中还有剩余元素，把他们按顺序填入A剩余的位置中
			A[end--] = B[bEnd--];
		}
		//【注】 无需考虑(处理)A中是否还有未比较的元素，因为如果有，就把它放在那里就好了（因为A已经有序）
	}
}
