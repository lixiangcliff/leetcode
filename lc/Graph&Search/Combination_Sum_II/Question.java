package Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/20829099
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0){
    		return result;
    	}
    	Arrays.sort(num);
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	int start = 0;
    	helper(num, start, target, item, result);
    	return result;
    }
    
    private void helper(int[] num, int start, int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
    	if(target < 0){ // necessary? 
    		return;		// answer: yes! if "new target" ---- "target-candidates[i]" < 0, consider it is invalid then return
    	}
    	if(target == 0){
    		//result.add(item);
    		result.add(new ArrayList<Integer>(item)); // still kind of not clear the difference...
    		return;
    	}
    	for(int i=start; i<num.length; i++){ 
    	    if(i>start && num[i]==num[i-1]){ //cannot be missed! //kind of not clear...
    	        continue;     
    	    }
    		item.add(num[i]);
    		helper(num, i+1, target-num[i], item, result); //"i+1" means can be used only once!
        	item.remove(item.size()-1);
    	}
    }

}
