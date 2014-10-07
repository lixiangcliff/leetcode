package Permutations;

import java.util.ArrayList;

public class Question2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3};
		//Question2 q = new Question2();
		permute(num);

	}
	
	
  //http://www.cnblogs.com/lifegoesonitself/p/3225803.html ------GOOD WAY!
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
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
    }

}
