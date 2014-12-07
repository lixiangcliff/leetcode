package Longest_Consecutive_Sequence;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(num));

	}
	
	/**
	 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.
	 * 
	 * For example, 
	 * Given [100, 4, 200, 1, 3, 2], 
	 * The longest consecutive elements sequence is [1, 2, 3, 4]. 
	 * Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 */
	//http://blog.csdn.net/linhuanmars/article/details/22964467
	//http://www.ninechapter.com/solutions/longest-consecutive-sequence/
    public static int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) { 
            return 0;  
        }
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : num) { //将所有元素存入hashmap，并将每个元素的value置为0
			map.put(i, 0);
		}
		int maxLen = 1;
		for (int i : num) { 
    		if (map.get(i) == 1) { // value为1，表示当前i已被访问
    			continue;
    		}
    		//以当前i为原点，找它左边和右边的连续值
    		int curLen = 1; //包涵当前i的最大连续长度
    		int neighbor = i;
    		//i右边
    		while (map.containsKey(neighbor + 1)) {
    			curLen++;
    			map.put(++neighbor,1); //把当前neighbor的value置为1，表示已访问
    		}
    		neighbor = i; //neighbor恢复到i的位置
    		//i左边
    		while (map.containsKey(neighbor - 1)) {
    			curLen++;
    			map.put(--neighbor, 1);
    		}
    		maxLen = Math.max(curLen, maxLen); //更新maxLen
    	}
        return maxLen;
    }

}
