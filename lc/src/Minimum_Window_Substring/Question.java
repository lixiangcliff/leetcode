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
	
	//http://blog.csdn.net/linhuanmars/article/details/20343903
    public static String minWindow(String S, String T) {
        if(S ==  null|| S.length()==0){
        	return "";
        }
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
        int minLen = S.length()+1;
        int minStart = 0;
        int count = 0;
        for(int right=0; right<S.length();right++){
        	char sRightChar = S.charAt(right);
        	if(map.containsKey(sRightChar)){
        		map.put(sRightChar, map.get(sRightChar)-1);
        		//after decrease by one, still positive, so count can add by one
        		if (map.get(sRightChar)>=0){
        			count++;
        		}
        		//current window(from left to right) can cover all chars in T
        		while(count == T.length()){
        			//update minLen and minStart if applicable
        			if(right-left+1 < minLen){
        				minLen = right-left+1;
        				minStart = left;
        			}
        			//after finding one result, move left rightward to continue finding new result
        			char sLeftChar = S.charAt(left);
        			if(map.containsKey(sLeftChar)){
        				map.put(sLeftChar, map.get(sLeftChar)+1);
        				// important!!
        				if(map.get(sLeftChar)>0){
        					count--;
        				}
        			}
        			left++;
        		}
        	}
        }
        return minLen > S.length() ? "" : S.substring(minStart, minStart+minLen);
    }
    

}
