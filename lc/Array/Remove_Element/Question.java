package Remove_Element;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//int[] A = {5,1,5,1,2,4,8,5,3,8,5,1,2,4};
		int[] A = {5,1,5,1,2,4,8,5,3,8,5,1,2,4};
		int a = q.removeElement(A,5);
		System.out.println(a);
		for(int i = 0; i<A.length; i++){
			System.out.print(A[i] + ",");
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/remove-element/
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 */
	
	//相当于有两个pointer， i和len：i从左往右，len从右往左，直到相遇。
	//http://blog.csdn.net/linhuanmars/article/details/19965351
    public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int len = A.length - 1; // len从右往左扫 
		for (int i = 0; i <= len; i++) { // i和len相遇才能停，因为i负责检查该位是否为element
    		if (A[i] == elem) { //只要A[i]==elem, 就用A[len]值来replace A[i]值, 即使A[len]也等于elem也照样换
    			A[i--] = A[len--]; // 因为新换来的A[i]上的数值(A[len])可能仍然是elem，所以i--，使其仍留在此位置，继续循环，直到A[i]!=elem, i才继续向右移动
    		}
    	}
    	return len + 1; //len最终表示：值不是element的最右一个数。所以len + 1即为数组长度 
    }
}
