package Combinations;

import java.util.ArrayList;
import java.util.HashSet;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combine(10,7);

	}
	
	//this only works for small numbers, won't pass leetcode when combine(10,7)..
    /*public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	int num[] = new int[n];
    	for(int i=0;i<num.length;i++){
    		num[i] = i+1;
    	}    	
    	ArrayList<Integer> oneComb = new ArrayList<Integer>();
    	doCombine(result, num, oneComb, k);
    	return result;
    }
    
    private static void doCombine(ArrayList<ArrayList<Integer>>result, int[] num, ArrayList<Integer> oneComb, int len){
        if(oneComb.size()==len){
        	boolean dup = false;
        	HashSet<Integer> oneCombSet = new HashSet<Integer>(oneComb);
        	for(int i=0; i<result.size(); i++){
        		HashSet<Integer> onePermSetRef = new HashSet<Integer>(result.get(i));
        		if (onePermSetRef.equals(oneCombSet)){
        			dup = true;
        			break;
        		}
        	}
        	if (!dup){
    			for (int i=0;i<oneComb.size();i++){
    				System.out.print(oneComb.get(i));
    			}
    			System.out.println("");
    			result.add(oneComb);
        	}     	
    	
        }else{
    		for(int i=0; i<num.length;i++){
    			if (oneComb.indexOf(num[i])<0 ){
    				ArrayList<Integer> newOneComb = (ArrayList<Integer>)oneComb.clone();
    				newOneComb.add(num[i]);
    				doCombine(result, num, newOneComb, len);
    			}
    			
    		}
    	}
    }*/
	
	//http://answer.ninechapter.com/solutions/combinations/
	//http://blog.csdn.net/u010500263/article/details/18435495
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> oneComb = new ArrayList<Integer>();
		getCombine(result, oneComb, n, k, 1);
		return result;
	}
	
	private static void getCombine(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> oneComb, int n, int k, int start){
		if(oneComb.size() == k){
			result.add(new ArrayList(oneComb));
		}else{
			for(int i=1;i<=n;i++){
				oneComb.add(i);
				getCombine(result, oneComb, n, k, start+1);
				//oneComb.remove(i); //wrong!!!
				// clear the current position to try next possible number
				oneComb.remove(oneComb.size()-1);
			}
		}
	}

}
