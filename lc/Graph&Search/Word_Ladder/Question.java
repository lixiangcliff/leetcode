package Word_Ladder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.print(ladderLength(start, end, dict));
	}
	
	//http://shanjiaxin.blogspot.com/2014/04/word-ladder-leetcode.html
	//http://blog.csdn.net/linhuanmars/article/details/23029973
	public static int ladderLength(String start, String end, HashSet<String> dict) {  
	    if(start == null || end == null || start.length()!=end.length() || start.length() == 0 || end.length()==0){
	    	return 0;
	    }
	    int len = 1;
	    LinkedList<String> queue = new LinkedList<String>();
	    queue.offer(start);
	    dict.remove(start);
	    while(!queue.isEmpty()){
	    	int queueSize = queue.size();
	    	for(int i=0; i<queueSize;i++){
		    	String cur = queue.poll();
		    	for(int j=0;j<cur.length();j++){
		    		char[] curChar = cur.toCharArray();
		    		// wrong!! it is same as if...break, but we need if...continue!
		    		//for(char c='a'; c<='z'&&cur.charAt(j)!=c; c++){ 
		    		for(char c='a'; c<='z'; c++){
		    			if(cur.charAt(j)==c){
		    				continue;
		    			}
		    			curChar[j] = c;
		    			//String temp = curChar.toString(); //wrong!
		    			String temp = new String(curChar);  
		    			if(temp.equals(end)){
		    				return len+1;
		    			}
		    			if(dict.contains(temp)){
		    				queue.offer(temp);//important!
		    				dict.remove(temp);
		    			}
		    		}
		    	}
		    	//len++; // wrong!
	    	}
	    	//after same position's string all tried, then we can len++
	    	//e.g. after hot->dot and hot->lot then we can len++;
	    	len++;
	    }
	    return 0;
	}

	
}
