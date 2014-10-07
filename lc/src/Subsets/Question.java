package Subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1,2,3};
		subsets(S);
	}
	
	//iterative way
	//http://blog.csdn.net/linhuanmars/article/details/24286377
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0) {
            return result;
        }
    	result.add(new ArrayList<Integer>()); //adding empty set
    	Arrays.sort(S);
    	for(int i=0; i<S.length;i++){
    		int size = result.size();
    		//for(int j=0; j<result.size();j++){ //Wrong! cannot use "j< result.size()", because size of result will change!
    		for(int j=0; j<size;j++){
    			ArrayList<Integer> oneSet = new ArrayList<Integer>(result.get(j));
    			oneSet.add(S[i]);
    			result.add(oneSet);
    			for(int k=0;k<oneSet.size();k++){
    				System.out.print(oneSet.get(k)+",");
    			}
    			System.out.println("");
    		}	
    	}
    	//System.out.println("result size:"+ result.size());
    	return result;
    }

}
