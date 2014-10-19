package Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/19949159
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0){
        	return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        int walker = 0;
        int runner = 0;
        while(runner!=s.length()){
        	if(set.contains(s.charAt(runner))){
        		max = Math.max(runner-walker, max);
        		while(s.charAt(walker)!=s.charAt(runner)){
        			set.remove(s.charAt(walker));
        			walker++;
        		}
        		walker++;
        	}else{
        		set.add(s.charAt(runner));
        	}
        	runner++;
        }
        max = Math.max(runner-walker, max);
        return max;
    }

}
