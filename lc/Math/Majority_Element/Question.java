package Majority_Element;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//int[] num = {1, 1, 1, 1, 2, 2, 2};
		int[] num = {10,9,9,9,10};
		System.out.print(q.majorityElement(num));
	}
	
	/**
	 * https://oj.leetcode.com/problems/majority-element/
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 */
	
	//中心思想是只要找到两个不一样的元素，就把他们抵消掉，最后剩下的就是超过 n / 2个数量的那个
    public int majorityElement(int[] num) {
    	if (num == null || num.length == 0) {
    		return Integer.MAX_VALUE;
    	}
        int candidate = num[0];
        int count = 1; // 表示当前candidate出现过的次数（已经减去抵消的次数）
        for (int i = 1; i < num.length; i++) {
        	if (count == 0) { // 说明前面的全都抵消掉了
        		candidate = num[i]; // 用当前值来更换candidate
        		count = 1; // count重置为1
        	} else {
        		if (candidate == num[i]) { 
        			count++;
        		} else { 
        			count--; 
        		}
        	}
        }
        return candidate; //【注】能这样直接返回剩余元素的前提条件是：保证array中一定有Majority Element才行
    }

}
