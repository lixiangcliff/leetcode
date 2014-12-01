package Minimum_Window_Substring;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
	
	/**
	 * https://oj.leetcode.com/problems/minimum-window-substring/
	 * Given a string S and a string T, find the minimum window in S which will
	 * contain all the characters in T in complexity O(n).
	 * 
	 * For example, 
	 * S = "ADOBECODEBANC" 
	 * T = "ABC" 
	 * Minimum window is "BANC".
	 * 
	 * Note: If there is no such window in S that covers all characters in T,
	 * return the emtpy string "".
	 * If there are multiple such windows, you are guaranteed that there will
	 * always be only one unique minimum window in S.
	 */
	
	//同样很多细节！！
	//http://blog.csdn.net/linhuanmars/article/details/20343903
    public static String minWindow(String S, String T) {
        if(S ==  null|| S.length()==0){
        	return "";
        }
        //T中的char装入map
        HashMap<Character, Integer> map = new  HashMap<Character, Integer>();
        for(int i=0; i<T.length(); i++){
        	char tchar = T.charAt(i);
        	if (map.containsKey(tchar)){
        		map.put(tchar, map.get(tchar)+1);
        	}else{
        		map.put(tchar, 1);
        	}
        }
        int left = 0;
        //分别用minStart和minLen来记录所求string的起始位置和长度
        int minStart = 0;
        int minLen = S.length()+1;
        int count = 0;//T中的char在当前窗口中已经出现的次数
        //此题相比于“Substring with Concatenation of All Words”，之所以不需要维护curMap：
        //是因为，当前窗口里可以有多余的（不是T中的）char，即不需要和map中的char种类和数量上严格对应
        //在下面code中，根据窗口中含有T中的char的情况来更新map。
        //具体来说就是：【注】map里放置的是窗口里不包含的char及其个数
        //所以每次右窗口右移并且纳入了T中含有的char时，就从map中减小该char的个数
        //  而每次左窗口右移并且剔除了T中含有的char时，就从map中增加该char的个数
        for(int right=0; right<S.length();right++){
        	char sRightChar = S.charAt(right);
        	if(map.containsKey(sRightChar)){
        		map.put(sRightChar, map.get(sRightChar)-1);
        		//之所以count++的先决条件是map.get(sRightChar)>=0是因为：
        		//如果map.get(sRightChar)已经小于0,则值为sRightChar的char在T中早已经被拿空了，所以在S中即使遇到了sRightChar，count的数目也不该增加！
        		if (map.get(sRightChar)>=0){
        			count++;
        		}
        		//只要当前窗口(from left to right) 还能包涵所有T中的char（就右移left）
        		while(count == T.length()){
        			//update minLen and minStart if applicable
        			if(right-left+1 < minLen){
        				minLen = right-left+1;
        				minStart = left;
        			}
        			//发现一个结果(minLen)之后，继续用右移过的新的left来寻找新的结果
        			char sLeftChar = S.charAt(left);
        			//左窗口右移，来剔除当前left
        			//如果当前left的char存在于map里，说明把它剔除之后，窗口里就不能包涵所有T中的char了，此层循环也就可以跳出了
        			if(map.containsKey(sLeftChar)){
        				//把剔除的char重新加回map（或者说+1）
        				map.put(sLeftChar, map.get(sLeftChar)+1);
        				// 确认map中已经有sLeftChar
        				if(map.get(sLeftChar)>0){
        					count--;
        				}
        			}
        			left++;//left右移
        		}
        	}
        }
        //如果minLen > S.length()，说明S中不含有这样的窗口，使所有T中的char都在其中，所以返回""
        return minLen > S.length() ? "" : S.substring(minStart, minStart+minLen);
    }
    

}
