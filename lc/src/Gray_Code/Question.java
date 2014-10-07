package Gray_Code;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//http://fisherlei.blogspot.com/2012/12/leetcode-gray-code.html
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	result.add(0);
    	for(int i=0;i<n;i++){
    		int len = result.size();
    		int highBit = 1 << i;
    		for(int j=len-1;j>=0;j--){
    			result.add(highBit + result.get(j));
    		}
    	}
    	return result;
    }
    
    //mathematic way
    public ArrayList<Integer> grayCode2(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i=0;i<(i<<n);i++){
    		result.add(i^(i-1));
    	}
    	return result;
    	
    }
   
}
