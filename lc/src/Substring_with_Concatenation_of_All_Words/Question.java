package Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		ArrayList result = findSubstring(S, L);
		for (int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
		
	}
	
	//brutal force
	//http://n00tc0d3r.blogspot.com/2013/06/substring-with-concatenation-of-all.html
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(S == null || S.length()==0 || L == null ||L.length ==0){
    		return result;
    	}
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	int wordNum = L.length;
    	int wordLen = L[0].length();
    	for(int i=0; i<wordNum; i++){
    		if(map.containsKey(L[i])){
    			map.put(L[i], map.get(L[i])+1);
    		}else{
    			map.put(L[i], 1);
    		}
    	}
    	for(int i=0; i+wordNum*wordLen<=S.length();i++){
    		HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);
    		int j=i;
    		for(; j+wordLen<=S.length()&&!map2.isEmpty();j+=wordLen){
    			String str = S.substring(j, j+wordLen);
    			if(map.containsKey(str)){
    				if(!map2.containsKey(str)){
    	    			break;
    	    		}
    				if(map2.get(str) > 1){
    					map2.put(str, map2.get(str)-1);
    				}else{
    					map2.remove(str);
    				}
    			}else{
    				break;
    			}
    		}
    		if(map2.isEmpty()){
    			result.add(i);
    		}
    	}
    	return result;
    } 
}
