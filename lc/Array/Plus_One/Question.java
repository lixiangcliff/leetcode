package Plus_One;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] in = {1,9,9,9,9,9};
		//int[] in = {9,8,7,6,5,4,3,2,1,0};
		int[] in = {9};
		int[] out = plusOne(in);
		for(int i=0;i<out.length;i++){
			System.out.print(out[i]);
		}

	}
	
    public static int[] plusOne(int[] digits) {
    	//using integer increment is not allowed in leetcode..
       /* long value = 0;
        for (int i=0;i<digits.length; i++){
        	value+=Math.pow(10, i)*digits[digits.length-1-i];
        }
        value++;
        String valueStr = Long.toString(value);
        int newlength = valueStr.length();
        int[] result = new int[newlength];
        for (int i=newlength-1;i>=0; i--){
        	result[i] = (int) (value%10);
        	value /= 10;
        }
        return result;*/
    	
    	//another way
    	int carry = 1; // cause we want to plus one
    	int sum = 0;
    	ArrayList<Integer> resultRev = new ArrayList<Integer>();
    	for(int i=digits.length-1; i>=0; i--){
    		sum =  (carry + digits[i])%10;
    		carry = (carry + digits[i])/10; 
    		resultRev.add(sum);
    	}
    	// important! if last time carry is 1, that means we need to advance in one digit
    	if (carry ==1){
    		resultRev.add(1);
    	}
    	
    	int newLen = resultRev.size();
    	int[] result = new int[newLen];
    	for (int i=0;i<newLen;i++){
    		result[i] = resultRev.get(newLen-1-i);
    	}
    	return result;
    	
    	
    }
}
