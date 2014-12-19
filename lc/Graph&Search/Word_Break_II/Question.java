package Word_Break_II;

import java.util.ArrayList;
import java.util.Set;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://www.binglu.me/leetcode-word-break-and-word-break-ii/
/*	ArrayList<String> wordBreak(String s, Set<String> dict){
		ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>();
		if (s == null){
			return null;
		}
		int len = s.length();
		for(int i=0;i<len;i++){
			record.add(new ArrayList<Integer>());
		}
		
		// the reason i starts from len instead of len-1 is because
		// stored index is the actual ending index plus 1 
		for(int end=len; end>=0;end--){ 
			//if record.get(i).isEmpty(), we will skip this i;
			//only exception is when i==len
			if(end<len && record.get(end).isEmpty()){
				continue;
			}
			for(int runner=end-1;runner>=0;runner--){
				if(dict.contains(s.substring(runner, end))){
					record.get(runner).add(end); // use "end" and "runner" to avoid confusion
				}
			}
		}
		
		ArrayList<String> solutions = new ArrayList<String>();
		buildSolution(s, "", 0, record, solutions);
		return solutions;
	}
	
	private void buildSolution(String s, String oneSolution, int current, ArrayList<ArrayList<Integer>> record, ArrayList<String> solutions){
		//iterate on current character's word ending list
		for(int end: record.get(current)){
			String sub = s.substring(current, end);
			String newOneSolution = oneSolution + (current == 0 ? sub : " "+sub); 
			//if(end == s.length()-1) //wrong!!
			if(end == s.length()){ // got one solution
				//solutions.add(oneSolution); //wrong !!
				solutions.add(newOneSolution);
			}else{
				//buildSolution(s, newOneSolution, current+1, record, solutions); //wrong!!
				buildSolution(s, newOneSolution, end, record, solutions);
			}
		}
	}*/
	
	//brutal force
	//http://blog.csdn.net/linhuanmars/article/details/22452163
	ArrayList<String> wordBreak(String s, Set<String> dict){
		ArrayList<String> result = new ArrayList<String>();
		if(s==null || s.length() == 0 || !isWBable(s, dict)){
			return result;
		}
		helper(s, 0, dict, "", result);
		return result;
	}
	
	private void helper(String s, int start, Set<String> dict, String item, ArrayList<String> result){
		//if (start == s.length()-1){ wrong! when start == s.length() means finished traversing whole s
		if (start == s.length()){
			result.add(item);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=start; i<s.length();i++){
			sb.append(s.charAt(i)); //detect by adding one char each time to see whether current sb.toString is in dict; if yes, recurse. 
			if (dict.contains(sb.toString())){
				String newItem = (item.length()>0) ? (item + " " + sb.toString()) : sb.toString();  
				helper(s, i+1, dict, newItem, result);
			}
		}
	}
	
	//reuse function from below:
	//https://oj.leetcode.com/problems/word-break/	
	private boolean isWBable(String s, Set<String> dict) {  
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
