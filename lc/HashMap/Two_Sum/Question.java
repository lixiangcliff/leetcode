package Two_Sum;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers={0,2,4,0};
		int[] result = twoSum(numbers,0);
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
	//http://blog.csdn.net/linhuanmars/article/details/19711387
    public static int[] twoSum(int[] numbers, int target) {
    	if(numbers == null || numbers.length < 2){
    		return null;
    	}
    	int[] result = new int[2];
    	//结构为：HashMap<value, index>
    	//【注】之所以不设计成<index, value>，是因为之后map只能通过key来找val，反之不行
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < numbers.length; i++){
    		//find them!
    		if(map.containsKey(target - numbers[i])){
    			//之前已经放入map的value为target - numbers[i]
    			result[0] = map.get(target - numbers[i])+1; //通过value作为map中的key，找map中的value也就是index
    			result[1] = i+1;
    			return result;
    		}
    		map.put(numbers[i], i);
    	}
        return null;
    }

}
