package Remove_Element;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {5,1,5,1,2,4,8,5,3,8,5,1,2,4};
		int[] A = {5,1,5,1,2,4,8,5,3,8,5,1,2,4};
		int a = removeElement(A,5);
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
	//http://blog.csdn.net/linhuanmars/article/details/19965351
    public static int removeElement(int[] A, int elem) {
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	//len 表示最后一个仍在有效array内的数的index 
    	int len=A.length-1;
    	for(int i=0; i<=len;i++){
    		//只要A[i]==elem, 就replace A[i]和 A[len], 即使A[len]也等于elem 也照样换
    		if(A[i] == elem){
    			//i--: 因为新换来的A[i]上的数值(A[len])可能仍然是elem，所以i--，使其仍留在此位置，
    			//继续循环，直到A[i]!=elem, i才继续向右移动
    			A[i--] = A[len--];
    		}
    	}
    	//之所以返回len+1是因为:
    	//elem出现几次，replace就发生了几次，同时len向左就移动了几次
    	//即，len始终“表示最后一个仍在有效array内的数的index” 
    	//换言之：len右边所有的数都是被排除于array的数
    	//len+1即为数组长度
    	return len+1;       
    }
}
