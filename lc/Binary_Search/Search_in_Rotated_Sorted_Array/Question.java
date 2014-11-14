package Search_in_Rotated_Sorted_Array;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,0,1,2};
		System.out.println(search(A, 9));

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/20525681
	//看图！（此题元素不重复）
    public static int search(int[] A, int target) {
    	if(A == null || A.length == 0){
    		return -1;
    	}
    	int l = 0;
    	int r = A.length-1;
    	while(l<=r){
    		int m = (l+r)/2;
    		if (target == A[m]){//找到target
    			return m;
    		}
    		if(A[m] < A[r]){//说明从m到r这一部分是有序的
    			if(A[m] <= target && target <= A[r]){ 
    				l = m+1; //如果target在这一部分，更新左边界l变为m+1
    			}else{
    				r = m-1; //如果target不在这一部分，更新右边界r变为m-1
    			}
    		}else{	//说明从l到m这一部分是有序的
    			if(A[l] <= target && target <= A[m]){
    				r = m-1; //如果target在这一部分，更新右边界r变为m-1
    			}else{
    				l = m+1; //如果target不在这一部分，更新左边界l变为m+1
    			}
    		}
    	}
    	
        return -1; //没找到
    }

}
