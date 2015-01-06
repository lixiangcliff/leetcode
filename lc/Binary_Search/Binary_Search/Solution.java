package Binary_Search;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =  new Solution();
		int[] nums = {1, 2, 3, 3, 4, 5, 10};
		int target = 3;
		System.out.println(s.binarySearch(nums, target));
	}
	
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
    	int start = 0;
    	int end = nums.length - 1;
    	while (start + 1 < end) {//只要不相交或者相邻（或者说一旦相邻或者相交就跳出循环）
    		int mid = start + (end - start) / 2; //防止 如果 start+end值极大导致溢出的情况
    		if (nums[mid] ==  target){//此题要找first，所以如果遇到相等的，则尽量把窗口往左移，即让end=mid
    			end = mid;
    		}else if(nums[mid] <  target){
    			start = mid;
    		}else{
    			end = mid;
    		}
    	}
    	
    	if (nums[start] == target) {//此题要找first，所以先看start符合否，如果符合就返回了。否则再看end
    		return start;
    	}
    	if (nums[end] == target) {
    		return end;
    	}
    	
        return -1;
    }
	
	//尝试return last
	/*public int binarySearch(int[] nums, int target) {
        //write your code here
    	int start = 0;
    	int end = nums.length - 1;
    	while (start + 1 < end) {//只要不相交或者相邻（或者说一旦相邻或者相交就跳出循环）
    		int mid = start + (end - start) / 2; //防止 如果 start+end值极大导致溢出的情况
    		if (nums[mid] ==  target){//此题要找last，
    			start = mid;
    		}else if(nums[mid] <  target){
    			start = mid;
    		}else{
    			end = mid;
    		}
    	}
    	
    	if (nums[end] == target) { //此题要找last，
    		return end;
    	}
    	
    	if (nums[start] == target) {
    		return start;
    	}
        return -1;
    }*/

}
