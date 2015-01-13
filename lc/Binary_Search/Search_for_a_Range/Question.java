package Search_for_a_Range;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {5, 7, 7, 8, 8, 10};
		int[] A = {2,2};
		
		System.out.println((searchRange(A, 2))[0]);
		System.out.println((searchRange(A, 2))[1]);
	}
	
	/**
	 * https://oj.leetcode.com/problems/search-for-a-range/
	 * Given a sorted array of integers, find the starting and ending position
	 * of a given target value.
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * If the target is not found in the array, return [-1, -1].
	 * For example, 
	 * Given [5, 7, 7, 8, 8, 10] and target value 8, 
	 * return [3, 4].
	 */
	
	//用BS模板【注】，要灵活利用模板！比如下面【注】处的else，体会start和end只能二者选一的逻辑关系
    public static int[] searchRange(int[] A, int target) {
    	int[] result = {-1, -1};
    	if(A == null || A.length == 0){
    		return result;
    	}
    	int start = 0;
    	int end = A.length - 1;
    	//先找target在A中的first
    	while (start + 1 < end) {//只要不相交或者相邻（或者说一旦相邻或者相交就跳出循环）
    		int mid = start + (end - start) / 2; //防止 如果 start+end值极大导致溢出的情况
    		if (A[mid] ==  target) {//此题要找first，所以如果遇到相等的，则尽量把窗口往左移，即让end=mid 画图可知
    			end = mid;
    		} else if (A[mid] < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (A[start] == target) {//此题要找first，所以先看start符合否，如果符合就找到了first。否则再看end
    		result[0] = start;
    	}else if (A[end] == target) { //【注】这个else非常重要！因为如果在start处找到了，我们就不需要也不可以再去end处找（否则会覆盖掉在start处）
    		result[0] = end;
    	}else {//说明干脆没找到target，则直接返回内容为{-1, -1}的result
    		return result;
    	}
    	//恢复start和end初始值
    	start = 0;
    	end = A.length - 1;
    	//再找target在A中的last
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2; 
    		if (A[mid] ==  target) { // 窗口尽量右移
    			start = mid;
    		} else if (A[mid] < target) {
    			start = mid;
    		}else{
    			end = mid;
    		}
    	}
    	if (A[end] == target) { // 先试end
    		result[1] = end;
    	} else if (A[start] == target) {
    		result[1] = start;
    	}
        return result;   
    }
}
