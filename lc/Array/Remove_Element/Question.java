package Remove_Element;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//int[] A = {5,1,5,1,2,4,8,5,3,8,5,1,2,4};
		int[] A = {5,1,5,1,2,4};
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
	
	//相当于有两个pointer， i和end：i从左往右，end从右往左，直到相遇。
	//http://blog.csdn.net/linhuanmars/article/details/19965351
    public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int end = A.length - 1; // len从右往左扫 
		for (int i = 0; i <= end; i++) { // 【注】i和end“相离”才结束，每发现一个element，end就往左移动一个。
    		while (A[i] == elem && i <= end) { //只要A[i]==elem, 就用A[end]值来replace A[i]值,并一直检查i是否仍然<=end
    			A[i] = A[end--];     		}
    	}
    	return end + 1; //end最终所在位置， 是值不同于element的最右一个数。所以end + 1即为数组长度 
    }
}
