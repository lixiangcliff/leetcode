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
		int[] in = {9,9,9,9,9};
		int[] out = plusOne(in);
		for(int i=0;i<out.length;i++){
			System.out.print(out[i]);
		}

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/22365957
    public static int[] plusOne(int[] digits) {
    	if(digits == null || digits.length == 0){
    		return digits;
    	}
    	for(int carry=1, i=digits.length-1;i>=0;i--){//carry 初始化为1，因为我们要加1
    		int value = (digits[i]+carry)%10;
    		carry = (digits[i]+carry)/10;
    		digits[i] = value;
    		if(carry == 0){//如果不再进位，i左边的位都不用再检查了
    			return digits;
    		}
    	}
    	//如果能执行到这一步，说明一直在进位直到加1后的数组比原数组多了一位。
    	//说明原来的数组全是9构成的，而新数组是1加上后面若干个0构成的
    	//初始化int[]，默认每一位都是0。所以只需置第0位为1即可
    	int[] result = new int[digits.length+1];
    	result[0] = 1;
    	return result;
    }
}
