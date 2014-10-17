package Divide_Two_Integers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-999999, 123));
		//System.out.println(Integer.MIN_VALUE);
	}
	
	//O(n) leetcode TLE...
/*    public static int divide(int dividend, int divisor) {
    	if (dividend == 0){
    		return 0;
    	}
    	if (divisor == 0){
    		return Integer.MAX_VALUE;
    	}
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        if (!positive){
        	dividend = -dividend;
        }
        int quot = 1;
        while(Math.abs(dividend-divisor)>Math.abs(divisor)){
        	dividend -= divisor;
        	quot++;
        }
        return positive ? quot : -quot;
    }*/
	
	//O(logn)
	//http://blog.csdn.net/linhuanmars/article/details/20024907
	public static int divide(int dividend, int divisor) {
    	if (dividend == 0){
    		return 0;
    	}
    	if (divisor == 0){
    		return Integer.MAX_VALUE;
    	}
		int result = 0;
		if (dividend == Integer.MIN_VALUE){//process min int value to avoid exceed boundary when "Math.abs()" it 
			dividend += Math.abs(divisor);
			result = 1;
		}
		if (divisor ==  Integer.MIN_VALUE){
			return result;
		}
		//to determine whether dividend and divisor share the same positive or negative sign
		boolean isNeg = (dividend^divisor)>>>31 == 1; // any difference between >> and >>> here? Yes! see below:
		//http://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
		//"The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension."
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int digit = 0;
		while(divisor <= dividend>>1){
			divisor <<= 1;
			digit++;
		}
		while(digit>=0){
			if(dividend-divisor>=0){
				dividend -= divisor;
				//result += divisor; wrong !!
				result += 1<<digit;
			}
			digit--;
			divisor >>= 1;
		}
		return isNeg ? -result : result;
	}

}
