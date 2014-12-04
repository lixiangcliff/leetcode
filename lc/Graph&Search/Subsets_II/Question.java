package Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1,2,2};
		subsetsWithDup(S);

	}
	
	//iterative way
	//http://blog.csdn.net/linhuanmars/article/details/24286377
	//quite similar to Subsets https://oj.leetcode.com/problems/subsets/
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
    	result.add(new ArrayList<Integer>()); //adding empty set
    	Arrays.sort(num);
    	for(int i=0; i<num.length;i++){
    		int size = result.size();
    		for(int j=0; j<size;j++){
    			ArrayList<Integer> oneSet = new ArrayList<Integer>(result.get(j));
    			oneSet.add(num[i]);
    			if (!result.contains(oneSet)){ // only add to result if oneSet has not been added before
    				result.add(oneSet);
/*    				for(int k=0;k<oneSet.size();k++){
        				System.out.print(oneSet.get(k)+",");
        			}
        			System.out.println("");*/
    			}
    			
    		}	
    	}
    	//System.out.println("result size:"+ result.size());
    	return result;
    }

}
