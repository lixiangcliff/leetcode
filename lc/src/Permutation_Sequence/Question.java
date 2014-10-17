package Permutation_Sequence;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4,10));
	}

	//http://blog.csdn.net/linhuanmars/article/details/22028697
    public static String getPermutation(int n, int k) {
    	if(n<=0){
    		return "";
    	}
    	k--; // to adjust index
        StringBuilder result = new StringBuilder();
        int factorial = 1;
        for(int i=2;i<n;i++){
        	factorial *= i;
        }
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
        	nums.add(i);
        }
        int round = n-1;
        while(round>=0){
        	int index = k/factorial;
        	result.append(nums.get(index));
        	nums.remove(index);
        	k %= factorial;
        	if(round>0){ // without this, when round == 0, it will fail; 
        		factorial /= round;
        	}
        	round--;
        }
        return result.toString();
    }
}
