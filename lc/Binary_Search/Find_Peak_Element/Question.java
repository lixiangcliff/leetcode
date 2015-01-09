package Find_Peak_Element;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] num = {1, 2, 3, 1};
		System.out.println(q.findPeakElement(num));

	}
	
	/**
	 * https://oj.leetcode.com/problems/find-peak-element/
	 * A peak element is an element that is greater than its neighbors.
	 * Given an input array where num[i] ≠ num[i+1], find a peak element and
	 * return its index.
	 * The array may contain multiple peaks, in that case return the index to
	 * any one of the peaks is fine.
	 * You may imagine that num[-1] = num[n] = -∞.
	 * 
	 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
	 * should return the index number 2.
	 * 
	 * Note: Your solution should be in logarithmic complexity.
	 */
	
	//the same as Find_a_Peak (http://lintcode.com/en/problem/find-a-peak/)
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
        	return Integer.MIN_VALUE;
        }
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
        	int mid = start + (end - start) / 2;
        	if (num[mid] < num[mid + 1]) {
        		start = mid;
        	} else {
        		end = mid;
        	}
        }
        return num[start] > num[end] ? start : end;
    }

}
