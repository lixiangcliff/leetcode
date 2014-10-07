package Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/20828631
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (candidates == null || candidates.length == 0){
    		return result;
    	}
    	//cannot be missed!!!
    	Arrays.sort(candidates);
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	int start = 0;
    	helper(candidates, start, target, item, result);
    	return result;
    }
    
    private void helper(int[] candidates, int start, int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
    	if(target < 0){ // necessary? 
    		return;		// answer: yes! if "new target" ---- "target-candidates[i]" < 0, consider it is invalid then return
    	}
    	if(target == 0){
    		//result.add(item);
    		result.add(new ArrayList<Integer>(item)); // still kind of not clear the difference...
    		return;
    	}
    	//for(int i=0; i<candidates.length; i++){// Wrong!
    	for(int i=start; i<candidates.length; i++){ //"i=start", because we've process value before "start" index
    		if(i>0 && candidates[i] == candidates[i-1]){
    			continue;
    		}
    		item.add(candidates[i]);
        	//helper(candidates, start, target-candidates[i], item, result); //Wrong!! each time "start" will be changed, "i" will keep this change
    		helper(candidates, i, target-candidates[i], item, result); //still "i" means can be used repeatedly
        	item.remove(item.size()-1);
    	}
    }
    
    
    
    
}
