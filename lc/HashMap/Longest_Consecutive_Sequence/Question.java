package Longest_Consecutive_Sequence;

import java.util.HashSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {100, 4, 200, 1, 3, 2};
		Question q = new Question();
		System.out.println(q.longestConsecutive(num));

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
	
	//用HashSet来标记数组中元素哪些访问过(set中不存在该元素)，哪些还没有访问过（set中存在该元素）
	//http://blog.csdn.net/linhuanmars/article/details/22964467
	//http://www.ninechapter.com/solutions/longest-consecutive-sequence/
	public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) { 
            return 0;  
        }
    	HashSet<Integer> set = new HashSet<Integer>();
		for (int i : num) { //将所有元素存入HashSet中
			set.add(i);
		}
		int maxLen = 1;
		for (int i : num) { 
    		if (!set.contains(i)) { // 如果map里已经没有i了，表示当前i已被访问
    			continue;
    		}
    		//以当前i为原点，找它左边和右边的连续值
    		int curLen = 1; //包涵当前i的最大连续长度
    		int neighbor = i;
    		//i右边
    		while (set.contains(neighbor + 1)) {
    			curLen++;
    			set.remove(++neighbor); //把当前neighbor从HashSet中移除，表示已访问
    		}
    		neighbor = i; //neighbor恢复到i的位置
    		//i左边
    		while (set.contains(neighbor - 1)) {
    			curLen++;
    			set.remove(--neighbor);
    		}
    		maxLen = Math.max(curLen, maxLen); //更新maxLen
    	}
        return maxLen;
    }

}
