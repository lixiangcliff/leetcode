package Multiply_Strings;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//to understand it:
	//leftmost of each number is index 0.
	//e.g 427851, 4 is the 0th,2 is 1st, etc..
	//http://blog.csdn.net/linhuanmars/article/details/20967763
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
        	return "";
        }
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0'){
        	return "0";
        }
        StringBuilder result = new StringBuilder();
        int num = 0;
        for(int i=num1.length()+num2.length(); i>0; i--){
        	//j start from then end of num1, and move leftward;
        	for(int j=Math.min(i-1, num1.length()); j>0; j--){
        		if (num2.length() >= i-j){
        			//num += (int)num1.charAt(j-1) * (int)num1.charAt(i-2-(j-1));
        			num += (int)(num1.charAt(j-1)-'0') * (int)(num2.charAt(i-2-(j-1))-'0');
        		}
        	}
        	if(i!=1 || num>0){
        		result.append(num%10);
        	}
        	num /= 10;
        }
        result.reverse();
        return result.toString();
    }

}
