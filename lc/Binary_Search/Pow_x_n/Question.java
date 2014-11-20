package Pow_x_n;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(-13.62608,3));
	}
	
    public static double pow(double x, int n) {
    	boolean positive;
    	if (n>0){
    		positive = true;
    	}else{
    		n *= -1;
    		positive = false;
    	}
    	if(x == 1){
    		return 1;
    	}
    	if (x == -1){
    		return n%2==0 ? 1 : -1;
    	}
        double result = 1.0;
        while(n>0){
        	if (Math.abs(result) < Double.MIN_VALUE){
        		return Double.MIN_VALUE;
        	}
        	result *= x;
        	n--;
        }
        return positive? result : 1/result;
    }

}
