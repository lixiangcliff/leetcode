package _3Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://answer.ninechapter.com/solutions/3sum/
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length<3){
    		return result;
    	}
    	Arrays.sort(num);
    	for(int i=0;i<num.length-2;i++){
    		if(i!=0 && num[i] == num[i-1]){
    			continue;
    		}
    		int left = i+1;
    		int right = num.length-1;
    		//int sum = num[i] + num[left] + num[right]; // Wrong!
    		while(left<right){
    			//need to be here, because changed left and right will produce new sum each time!
    			int sum = num[i] + num[left] + num[right];
    			if(sum==0){
    				ArrayList<Integer> oneResult = new ArrayList<Integer>();
    				oneResult.add(num[i]);
    				oneResult.add(num[left]);
    				oneResult.add(num[right]);
    				result.add(oneResult);
    				//cannot be missed!!!
    				left++;
    				right--;
    				//while(left<right && num[left] == num[left+1]){ //wrong! check whether duplicate with previous left
    				while (left < right && num[left] == num[left-1]){ 
    					left++;
    				}
    				//while(left<right && num[right] == num[right-1]){ //wrong!
    				while(left<right && num[right] == num[right+1]){
    					right--;
    				}
    			}else if(sum>0){
    				right--;
    			}else{
    				left++;
    			}
    		}
    	}
    	return result;
    }

}
