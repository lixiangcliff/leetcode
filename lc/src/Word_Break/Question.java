package Word_Break;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		String s = "abcd";
		String s1 = "a";
		String s2 = "abc";
		String s3 = "b";
		String s4 = "cd";*/
		String s = "leetcode";
		String s1 = "leet";
		String s2 = "code";
		String s3 = "ab";
		String s4 = "cd";
		
	/*	Set<String> dict = null;
		dict.add(s1);
		dict.add(s2);
		dict.add(s3);
		dict.add(s4);*/
		
		String elements[] = { s1,s2,s3,s4};
		Set<String> dict = new HashSet(Arrays.asList(elements));
/*		System.out.println(dict.contains("e"));
		StringBuilder str = new StringBuilder(s.substring(0,1+1));
		System.out.println("before:" + str.toString());
		str.deleteCharAt(0);
		System.out.println("after:" + str.toString());*/
		System.out.println(wordBreak(s, dict));
		
	}
	
/*    public static boolean wordBreak(String s, Set<String> dict) {
    	if(s == null || s.length() == 0){
    		return false;
    	}
    	return helper(s, dict);
    	
    }
    
    private static boolean helper(String s, Set<String> dict){
    	if(s.length() == 0){
    		return true;
    	}
    	
    	for (String str : dict) {
    		int index = s.indexOf(str);
    		if(index == 0){
    			return helper(s.substring(str.length()), dict);
    		}
    	}
        return false;
    }*/
	
	//code strucure: http://blog.csdn.net/linhuanmars/article/details/22358863 
	//core idea:     http://www.binglu.me/leetcode-word-break-and-word-break-ii/
	public static boolean wordBreak(String s, Set<String> dict) {  
	    if(s==null || s.length()==0)  
	        return true;  
	    boolean[] result = new boolean[s.length()+1];  
	    //result[i] means until index i, whether s can still be segmented by words in dict
	    //result[0] means when s is empty, apparently it can be. 
	    result[0] = true;  
	    for(int i=0;i<s.length();i++)  
	    {  
	        for(int j=0;j<=i;j++)  
	        {  
	        	String sub = s.substring(j,i+1); 
	            if(result[j] && dict.contains(sub))  
	            {  
	                result[i+1] = true;  
	                break;  
	            }  
	        }  
	    }  
	    return result[s.length()];  
	} 

}
