package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4};
		Question q = new Question();
/*		for (int m=0;m<num.length;m++){
			System.out.print(num[m]);
		}		
		q.swap(num, 0, 3);
		for (int m=0;m<num.length;m++){
			System.out.print(num[m]);
		}*/
		q.permute(num);

	}
	//idea from http://www.coderli.com/datastructure-c-perm
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0) {
            return result; 
        }
    	ArrayList<Integer> perm= new ArrayList<Integer>();
    	doPermute(result, num, 0, num.length-1);
    	return result;
    }
    private void doPermute(ArrayList<ArrayList<Integer>> result, int[] num, int k, int m){
    	if( k == m){
    		ArrayList<Integer> perm = new ArrayList<Integer>();
    		for (int i=0;i<num.length;i++){
    			perm.add(num[i]);
    		}
    		for (int i=0;i<perm.size();i++){
    			System.out.print(perm.get(i));
    		}
    		System.out.println("");
    		result.add(perm);
    	}else{
    		for (int i=k;i<=m;i++){
    			swap(num, k, i);
    			doPermute(result, num, k+1, m);
    			swap(num, k, i);
    		}
    	}
    }
    private void swap(int[] num, int i, int j){
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
    

}
