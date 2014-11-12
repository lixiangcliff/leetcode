package _3Sum_Closest;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://answer.ninechapter.com/solutions/3sum-closest/
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length <3){
        	return Integer.MAX_VALUE; // means does not return a normal value;
        }
        Arrays.sort(num);
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE/2;// otherwise it will overflow for opeartion (closet-target)'
        for(int i=0; i<num.length-2;i++){
        	int left = i+1;
        	int right = num.length-1;
        	while(left<right){
        		int sum = num[i] + num[left] + num[right];
        		if(sum == target){
        			return sum;
        		}else if(sum>target){
        			right--;
        		}else {
        			left++;
        		}
        		
        		if(Math.abs(sum-target)<diff){
        			diff = Math.abs(sum-target);
        			result = sum;
        		}
        	}
        }
        return result;
    }

}
