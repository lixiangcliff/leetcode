package Count_and_Say;

import java.util.Stack;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(5));
	}
	//over kill...or say did not understand what they want to do...
/*    public static String countAndSay(int n) {
    	int count=1;
    	String str = Integer.toString(n);
    	while(count < n){
    		str = say(str);
    		count++;
    	}
    	return str;        		
    }
    
    private static String say(String str){
    	if (str.length() == 1){
    		return "1" + str;
    	}
    	int previous = 0;
    	int current = 1;
    	String result = "";
    	int count = 1;
    	while(current<str.length()){
    		if(str.charAt(current) != str.charAt(previous)){
    			result = result + count + str.charAt(previous);
    			count = 1;
    			previous = current;
    		}else{
    			count++;
    		}
    		current++;
    	}
    	result = result + count + str.charAt(previous);
    	return result;
    }*/
	
	public static String countAndSay(int n) {
    	int count=1;
    	String str = Integer.toString(1);
    	while(count < n){
    		str = say(str);
    		count++;
    	}
    	return str;        		
    }
    
    private static String say(String str){
    	if (str.length() == 1){
    		return "1" + str;
    	}
    	int previous = 0;
    	int current = 1;
    	String result = "";
    	int count = 1;
    	while(current<str.length()){
    		if(str.charAt(current) != str.charAt(previous)){
    			result = result + count + str.charAt(previous);
    			count = 1;
    			previous = current;
    		}else{
    			count++;
    		}
    		current++;
    	}
    	result = result + count + str.charAt(previous);
    	return result;
    }
}
