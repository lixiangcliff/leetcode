package Palindrome_Number;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 12033021;
		//int a = -1881;
		System.out.print(isPalindrome(a));
		//System.out.print((a));

	}
	
	//no good when inout is 1000021..
    /*public static boolean isPalindrome(int x) {   
    	if (x < 0){
    		return false;
    	}
        while(x>0){
        	int len = getLength(x);
        	int high = (int) (x / Math.pow(10, len-1));
        	int low = x%10;
        	System.out.println("x1:  "+ x);
        	System.out.println("high:" + high);
        	System.out.println("low :" + low);
        	if(high != low){
        		return false;
        	}       	
        	x = (int) (x - high*Math.pow(10, len-1))/10;
        }
        return true;
    }
    
    public static int getLength(int a){
    	int count =0;
    	while(a>0){
	    	a = a/10;
	    	count++;
    	}
    	return count;
    }*/
    
	//use exra space
/*    public static boolean isPalindrome(int x) {
    	if (x<0){
    		return false;
    	}
    	String str = Integer.toString(x);
    	for(int i=0;i<str.length();i++){
    		if(str.charAt(i) != str.charAt(str.length()-1 -i)){
    			return false;
    		}
    	}
    	return true;
    }*/
    
    public static boolean isPalindrome(int x) {   
		if (x < 0){
			return false;
		}
		int len = getLength(x);
		for (int i =0; i<len-1;i++){
			if(getDigit(x, i) != getDigit(x, len-1-i)){
				return false;
			}
		}
		    return true;
	}
	
	public static int getLength(int a){
		int count =0;
		while(a>0){
	    	a = a/10;
	    	count++;
		}
		return count;
	}
	
	public static int getDigit(int a, int b){
		while(b>0){
	    	a = a/10;
	    	b--;
		}
		return a % 10;
	}

}
