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
	
	//http://answer.ninechapter.com/solutions/longest-consecutive-sequence/
    public static int longestConsecutive(int[] num) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i:num){
    		map.put(i, 0);
    	}
    	int maxLen = 1;
    	for(int val:num){
    		if (map.get(val) == 1){ // means this val has been processed
    			continue;
    		}
    		int maxCur = 1;
    		int temp = val;
    		while(map.containsKey(temp+1)){ // right side
    			maxCur++;
    			map.put(++temp,1);
    		}
    		temp = val;
    		while(map.containsKey(temp-1)){ // right side
    			maxCur++;
    			map.put(--temp,1);
    		}
    		maxLen = Math.max(maxCur, maxLen);
    	}
        return maxLen;
    }

}
