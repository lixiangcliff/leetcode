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
		/*for (int m=0;m<num.length;m++){
			System.out.print(num[m]);
		}*/

	}
	
	/**
     * see method 3 and 4
     * 
	 */
	//idea from http://www.coderli.com/datastructure-c-perm
/*    public ArrayList<ArrayList<Integer>> permute(int[] num) {
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
    }*/
	
	 //http://www.cnblogs.com/lifegoesonitself/p/3225803.html ------GOOD WAY!
    /*public static ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (num == null || num.length == 0) {
            return result; 
        }
    	ArrayList<Integer> onePerm = new ArrayList<Integer>();
    	doPermute(result, num, onePerm, num.length);
    	return result;
    }
	
    public static void doPermute(ArrayList<ArrayList<Integer>> result, int[] num ,ArrayList<Integer> onePerm ,int len){
        if(onePerm.size()==len){ 
        	for (int i=0;i<onePerm.size();i++){
				System.out.print(onePerm.get(i));
			}
			System.out.println("");
			result.add(onePerm);
        } else{
			  for(int i=0;i<num.length;i++){
			      if(onePerm.indexOf(num[i]) < 0){ 
			    	  //here is the tricky part:
			    	  //in doPermute, must give another ArrayList<Integer>, not the original one!
			    	  ArrayList<Integer> newOnePerm = (ArrayList<Integer>)onePerm.clone();
			    	  newOnePerm.add(num[i]);
			    	  doPermute(result, num, newOnePerm,len);
			      }
			  } 
          }
    }*/

	
	//递归函数必须保证在进入和离开函数的时候，变量的状态是一样的, 这样才能保证正确性.
	// recursive function must meet requirement that:
	// variable must stay the same after entering and before leaving current function body
	//http://blog.csdn.net/linhuanmars/article/details/21569031
	//recursive
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0){
			return result;
		}
		ArrayList<Integer> item = new ArrayList<Integer>();
		boolean[] used = new boolean[num.length];
		helper(num, used, item, result);
		return result;
		
	}
	
	private void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
		if (item.size() == num.length){// got a permutation
			result.add(new ArrayList<Integer>(item)); // must "new" a new item, because item is shared among recursion, 
			return;//everything will add on this item if not "new" a item every single time
		}
		for(int i=0;i<num.length;i++){
			if(!used[i]){//important! to determine whether to process it for permuting
				// recursive function must meet requirement that:
				// variable must stay the same after entering and before leaving current function body
				used[i] = true;
				item.add(num[i]);
				helper(num, used, item, result);
				item.remove(item.size()-1); // recover to its original statuts
				used[i] = false; // recover to its original statuts
			}
		}
	}
	
	//iterative
/*	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
		if (num== null || num.length == 0){
			return result;
		}
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(num[0]);
		result.add(first);
		for(int i=1;i<num.length;i++){
			ArrayList<ArrayList<Integer>> newResult = new ArrayList<ArrayList<Integer>>();
			for(int j=0;j<result.size();j++){
				ArrayList<Integer> cur = result.get(j);
				for(int k=0;k<cur.size()+1;k++){
					ArrayList<Integer> item = new ArrayList<Integer>(cur);
					item.add(k, num[i]);
					//result.add(item); wrong!
					newResult.add(item);
				}
			}
			result = newResult;
		}
		return result;
	}*/

}
