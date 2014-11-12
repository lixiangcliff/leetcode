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
	/* 思想：
	 * 维护一个HashSet, 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，
	 * 如果发现重复字符，则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结果，
	 * 此时移动左窗口，直到不再有重复字符为止
	 * 此题很多小细节，要仔细！
	 */
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0){
        	return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        int walker = 0;
        int runner = 0;
        while(runner!=s.length()){
        	if(set.contains(s.charAt(runner))){//当前值在set中已经有了，
        		max = Math.max(runner-walker, max);//更新max
        		//walker持续右移，直到找到和runner当前值相等的那一个
        		while(s.charAt(walker)!=s.charAt(runner)){
        			set.remove(s.charAt(walker));//更新set
        			walker++;
        		}
        		walker++;//相当于剔除和runner当前值相等的那一个
        	}else{//当前值不重复，把当前值加入set
        		set.add(s.charAt(runner));
        	}
        	runner++;//如论重复与否（实际上重复的情况处理完之后，相当于不再重复了），runner都要右移
        }
        //当runner走到尽头后，需要再判断（更新）一次max
        max = Math.max(runner-walker, max);
        return max;
    }

}
