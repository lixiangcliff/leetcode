package _4Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/4sum/
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: 
	 * Elements in a quadruplet (a,b,c,d) must be in non-descending order.
	 * (ie, a ≤ b ≤ c ≤ d) 
	 * The solution set must not contain duplicate quadruplets. 
	 * 
	 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
	 * 
	 * A solution set is: 
	 * (-1, 0, 0, 1) 
	 * (-2, -1, 1, 2) 
	 * (-2, 0, 0, 2)
	 */
	//http://answer.ninechapter.com/solutions/4sum/
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length<4){
    		return result;
    	}
    	Arrays.sort(num);
    	for(int i=0;i<num.length-3;i++){
    		if(i!=0 && num[i] == num[i-1]){
    			continue;
    		}
	    	for(int j=i+1;j<num.length-2;j++){ //j=i+1
	    		if(j!=i+1 && num[j] == num[j-1]){
	    			continue;
	    		}
	    		int left = j+1;
	    		int right = num.length-1;
	    		while(left<right){
	    			int sum = num[i] + num[j] + num[left] + num[right]; // add FOUR of them!
	    			if(sum==target){
	    				ArrayList<Integer> oneResult = new ArrayList<Integer>();
	    				oneResult.add(num[i]);
	    				oneResult.add(num[j]);
	    				oneResult.add(num[left]);
	    				oneResult.add(num[right]);
	    				result.add(oneResult);
	    				left++;
	    				right--;
	    				while (left < right && num[left] == num[left-1]){ 
	    					left++;
	    				}
	    				while(left<right && num[right] == num[right+1]){
	    					right--;
	    				}
	    			}else if(sum>target){
	    				right--;
	    			}else{
	    				left++;
	    			}
	    		}
	    	}
    	}
    	return result;
    }

}
