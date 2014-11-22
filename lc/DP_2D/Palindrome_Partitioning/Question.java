package Palindrome_Partitioning;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/22777711
    public ArrayList<ArrayList<String>> partition(String s) {
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(s == null | s.length() == 0){
        	return result;
        }
        helper(s, getDict(s), 0, new ArrayList<String>(), result);
        return result;
    }
    
    private void helper(String s, boolean[][] dict, int start, ArrayList<String> item, ArrayList<ArrayList<String>>result){
    	if(start == s.length()){
    		result.add(new ArrayList<String>(item));
    		return;
    	}
    	for(int i=start;i<s.length();i++){
    		if(dict[start][i]){
    			item.add(s.substring(start, i+1));
    			helper(s, dict, i+1, item, result);
    			item.remove(item.size()-1);
    		}
    	}
    }
    
    private boolean[][] getDict(String s){
    	int len = s.length();
    	boolean[][] dict = new boolean[len][len];
    	for (int i=len-1;i>=0;i--){
    		for(int j=i;j<len;j++){
    			//if(s.charAt(i) == s.charAt(j) && (j-i<=2 || s.charAt(i+1) == s.charAt(j-1))){ wrong!
    			if(s.charAt(i) == s.charAt(j) && (j-i<=2 || dict[i+1][j-1])){ // important!
    				dict[i][j] = true;
    			}
    		}
    	}
    	return dict;
    }

}
