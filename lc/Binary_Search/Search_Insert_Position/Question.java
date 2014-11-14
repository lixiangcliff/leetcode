package Search_Insert_Position;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = {1,2};
		System.out.println(searchInsert(A, 0));
	}
	

	/*
	 * 要找比target大的最小元素
	 * 几个问题要问老师的
	 */
	//http://blog.csdn.net/linhuanmars/article/details/20278967
	public static int searchInsert(int[] A, int target) {  
	    if(A == null || A.length == 0)  
	    {  
	        return 0;  
	    }  
	    int l = 0;  
	    int r = A.length-1;  
	    while(l<=r)  //1. 循环条件中，l和r的关系，小于or小于等于
	    {  
	        int mid = (l+r+1)/2; //向上还是向下取整？这道题向上向下都行。为什么？  
	        if(A[mid]==target)  
	            return mid;  
	        if(A[mid]<target)  
	            l = mid+1; //l的边界怎么取？ 
	        else  
	            r = mid-1;  ////l的边界怎么取？ 
	    }  
	    //"如果没有找到目标元素，那么l一定停在恰好比目标大的index上，r一定停在恰好比目标小的index上" 为什么？
	    return l;  
	}  
}
