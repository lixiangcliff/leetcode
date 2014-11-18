package Search_in_Rotated_Sorted_Array_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,0,1,2};
		System.out.println(search(A, 9));
	}
	
	//using BST template
	//http://blog.csdn.net/linhuanmars/article/details/20588511
    public static boolean search(int[] A, int target) {
    	if(A == null || A.length == 0){
    		return false;
    	}
    	int start = 0;
    	int end = A.length-1;
    	while(start + 1 < end){
    		int mid = start + (end - start) / 2;
    		if (target == A[mid]){
    			return true;
    		}
    		//以下和 “Search_in_Rotated_Sorted_Array”一样（看【注】的区别）
    		if(A[mid] < A[end]) {
    			if(A[mid] <= target && target <= A[end]){ 
    				start = mid; 
    			}else{
    				end = mid; 
    			}
    		}else if (A[mid] > A[end]) {//【注】	此处要把else if的条件写全，因为下面还有一处else
    			if(A[start] <= target && target <= A[mid]){
    				end = mid; 
    			}else{
    				start = mid; 
    			}
    		}
    		//以上和 “Search_in_Rotated_Sorted_Array”一样
    		else{//即A[mid] == A[end]， 此时无法判断到底哪一半是有序的（因为有重复元素），所以能做的只有左移end一位，直到A[mid] != A[end]为止
    			end--; //运气坏时就是O(n)比如 {2,3,1,1,1,1,1,1}如果target==3,r需要一直从最右一直挪到左边第一个1时(mid==1,end==2)，才有(A[mid]!=A[end])，然后才能再继续用二分查找。
    		}
    	}
    	
    	if (A[start] == target || A[end] == target){
    		return true;
    	}
    	
        return false;
    }
    
    //http://answer.ninechapter.com/solutions/search-in-rotated-sorted-array-ii/ 
    //此题最坏情况就是O(n),最坏情况就是顺序遍历（就像下边的）。但是大多数情况按上面的解法还是O(nlogn)的。
    //这个可以类比quicksort，最坏情况是O(n^2)，但是avarage的复杂度仍然是O(nlogn)。
    public boolean searchWorst(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }

}
