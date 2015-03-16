package Majority_Number_III;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//int[] numArray = {3,1,2,3,2,3,3,4,4,4};
		int[] numArray = {3,1,2,3,2,3,3,4,4,4};
		int k = 3;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int num : numArray) {
			nums.add(num);
		}
		System.out.println(s.majorityNumber(nums, k));

	}
	
	/**
	 * http://lintcode.com/en/problem/majority-number-iii/
	 * Given an array of integers and a number k, the majority number is the
	 * number that occurs more than 1/k of the size of the array. Find it.
	 * Note There is only one majority number in the array.
	 * 
	 * Example For [3,1,2,3,2,3,3,4,4,4] and k = 3, return 3
	 * Challenge O(n) time and O(k) extra space
	 */
    
    public int majorityNumber(ArrayList<Integer> nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int num : nums) {
    		if (map.containsKey(num)) {
    			map.put(num, map.get(num) + 1);
    		} 
    		else {
    			map.put(num, 1);
    		}
    		if (map.size() == k) { // 已经凑够了k个不同的值，每个值都减去一个count，特别的 如果count的值已经为0了，则从map中删去（删去的目的是为了下一轮统计时，仍能保证map.size()等于k时表示取到了k个不同的值）
    			Iterator<Integer> it = map.keySet().iterator(); // 【注】记住如何iterate map
    			while (it.hasNext()) {
    		    	int key = (Integer)it.next();
    		        if ((Integer)map.get(key) <= 1) {
    		        	//map.remove(key); //http://stackoverflow.com/questions/602636/concurrentmodificationexception-and-a-hashmap
    		        	it.remove();
    		        } else {
    		        	map.put(key, (Integer)map.get(key) - 1);
    		        }
    		    }
    		} 
    	}
    	
    	//【注】不可以直接在map里统计每个num剩余的个数，然后取其中最大的那个为结果。
    	//因为数字的编排可以让majority 数被过度消耗，使其计数反而等于或小于比其他num。以k == 3为例如下：
    	//1 1 1 1 2 3 2 3 4 4 4 这个 1就会被消耗过多，最后余下的反而比4少。
    	HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
    	int result = Integer.MIN_VALUE;
    	for (int num : nums) {
    		if (map.containsKey(num)) {
    			if (resultMap.containsKey(num)){
    				resultMap.put(num, resultMap.get(num) + 1);
    			} else {
    				resultMap.put(num, 1);
    			}
    			if (!resultMap.containsKey(result) || resultMap.get(num) > resultMap.get(result)) { // !resultMap.containsKey(result)只针对第一个map里包涵的num。
        			result = num;
        		}
    		}
    	}
    	return result;
    }
}
