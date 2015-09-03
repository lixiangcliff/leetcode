package Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(q.findKthLargest(nums, k));
	}
	
	/**
	 * https://leetcode.com/problems/kth-largest-element-in-an-array/
	 * Find the kth largest element in an unsorted array. 
	 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
	 * 
	 * For example,
	 * Given [3,2,1,5,6,4] and k = 2, return 5.
	 * Note: 
	 * You may assume k is always valid, 1 ≤ k ≤ array's length.
	 */
	
	//PriorityQueue == min heap
	//way to impement max heap: PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
    public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
    	for (int i = 0; i < k; i++) {
    		heap.add(nums[i]);
    	}
    	for (int i = k; i < nums.length; i++) {
    		if (nums[i] > heap.peek()) {
    			heap.remove();
    			heap.add(nums[i]);
    		}
    	}
    	return heap.peek();
    }
}
