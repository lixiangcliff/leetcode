package Find_Minimum_in_Rotated_Sorted_Array_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] num = {4, 5, 6, 7, 0, 1, 2};
		//int[] num = {3,3,3,3,3,1,2};
		//int[] num = {3,1,2,3,3,3,3};
		int[] num = {1,1,2,-1,0,1};
		System.out.println(findMin(num));
	}
	
	/**
	 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
	 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates
	 * are allowed?
	 * Would this affect the run-time complexity? How and why? Suppose a sorted
	 * array is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element.
	 * The array may contain duplicates.
	 */
	//binary search template
	public static int findMin(int[] num) {
		if(num == null || num.length ==0){
        	return Integer.MAX_VALUE;
        }
		int start = 0;
		int end = num.length - 1;
		int min = Integer.MAX_VALUE;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (num[mid] < num [end]) {
				end = mid;
				min = Math.min(num[mid], min);
			} else if (num[mid] > num [end]) {
				start = mid;
				min = Math.min(num[end], min);
			} else {
				end--;
			}
		}
		return Math.min(Math.min(num[start], num[end]), min);
	}
	
	
	//http://blog.csdn.net/linhuanmars/article/details/40449299
/*    public static int findMin(int[] num) {
        if(num == null || num.length ==0){
        	return 0;
        }
        int l =0;
        int r = num.length-1;
        int min = num[0];
        while(l<r-1){ // why not l<r?..
        	//comment from linhuanmars:
        	//这里的问题是这样的，原先因为是搜索某一个元素，所以可以夹逼到找到元素或者他们交错为止，
        	//现在的主要问题是如果l和r相差1以内，那么m就会等于l，如此下面的条件就会跳过r，
        	//而最小元素可能就在r里面，所以终止条件才改成l<r-1使得夹逼就停止在最后两个元素中哈～
        	int m = (l+r)/2;
        	if(num[l]<num[m]){
        		min = Math.min(min, num[l]);
        		l = m+1;
        	}else if(num[l]>num[m]){
        		min = Math.min(min, num[m]);
        		r = m-1;
        	}else{
        		l++;
        	}
        }
        return Math.min(Math.min(min, num[l]), num[r]);
    }
*/
}
