package Remove_Duplicates_from_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] A = {1,1,2,3,4,4,5,5,5,5,5,5,6,7,7,7,7};
		int[] A = {1};
		// TODO Auto-generated method stub
		int length = removeDuplicates(A);
		System.out.println(length);
		for (int i=0;i<length;i++){
			System.out.println(A[i] + ",");
		}

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/20023993
    public static int removeDuplicates(int[] A) {
    	if(A == null || A.length==0){
    		return 0;
    	}
    	/*
    	 * index表示的值有两层含义:
    	 * 1.它作为一个位标记，凡是它左边的都是比较过之后确保没有重复的元素
    	 * 2.同时它也从数值上表示了左半边数组的长度
    	 * 【注】这种一举两得的方式经常遇到
    	 */
    	int index = 1;
    	for (int i=1; i< A.length; i++){
    		/*
    		 * 比较相邻两个数，只有不相等才更新index位上的值
    		 * 否则什么也不做，相当于 continue
    		 */
    		if(A[i-1] != A[i]){
    			//更细完index位的值之后，index++；
    			A[index++] = A[i];
    		}
    	}
    	//index可以表示左半边数组长度，可以直接返回
    	return index;
    }

}
