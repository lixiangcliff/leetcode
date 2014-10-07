package Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {1,1,1,2,2,2,2,2};
		Question q = new Question();
		q.permuteUnique(num);

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21570835
	//http://fisherlei.blogspot.com/2012/12/leetcode-permutations-ii.html
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0){
    		return result;
    	}
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	boolean[] used = new boolean[num.length];
    	Arrays.sort(num);//important!
    	helper(num, used, item, result);
    	return result;
    }
    
    private void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
    	if(item.size() == num.length){
    		result.add(new ArrayList<Integer>(item));
    		return;
    	}
    	for(int i=0; i<num.length; i++){
    		if(i>0 && num[i-1]==num[i] && !used[i-1]){ //if current value(num[i]) has occur previously(num[i-1]); 
    			continue;								// and previous has not be used, we will not do recursion
    		}											// i.e. if duplication happens, only to use current one, when previous one has been used for recursion
    		if (!used[i]){
    			used[i] = true;
    			item.add(num[i]);
    			helper(num, used, item, result);
    			item.remove(item.size()-1);
    			used[i] = false;
    		}
    	}
    }
}
