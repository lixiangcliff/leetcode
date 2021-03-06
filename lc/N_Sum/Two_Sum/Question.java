package Two_Sum;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] numbers={0,2,4,0};
		int[] result = q.twoSum(numbers,0);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	
	/**
	 * https://oj.leetcode.com/problems/two-sum/
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2. Please
	 * note that your returned answers (both index1 and index2) are not
	 * zero-based.
	 * 
	 * You may assume that each input would have exactly one solution.
	 * Input: numbers={2, 7, 11, 15}, target=9 
	 * Output: index1=1, index2=2
	 */
	
	//HashMap, O(n) Space, O(n) Time;
	//【注】因为这道题要求返回的是index，所以不能打乱原来数组的顺序，故不能sort。
	//否则也可以用two pointers达到O(1) Space, O(nlogn) Time; 
	//http://blog.csdn.net/linhuanmars/article/details/19711387
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // 结构为：HashMap<value, index>【注】不能设计成<index, value>，是因为之后map只能通过key来找val。
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) { // find them! 之前已经放入map的value为target - numbers[i]
				result[0] = map.get(target - numbers[i]) + 1; // 通过value作为map中的key，找map中的value也就是index
				result[1] = i + 1;
				return result;
			}
			map.put(numbers[i], i);
		}
		return null;
	}
    
    

}
