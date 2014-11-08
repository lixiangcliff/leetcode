package Valid_Parentheses;

import java.util.Stack;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("([)]"));
	}
	
    public static boolean isValid(String s) {
    	if (s == null || s.length() == 0 || s.length() %2 ==1){
    		return false;
    	}
    	
    	String left  = "([{";
    	String right = ")]}";
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0;i<s.length();i++){
    		char curChar = s.charAt(i);
    		if(left.indexOf(curChar) > -1){
    			stack.push(curChar);
    		}else if(right.indexOf(curChar) > -1){
    			if (stack.isEmpty()){
    				return false;
    			}else{
    				char preChar = stack.pop();
    				if(left.indexOf(preChar) != right.indexOf(curChar)){
    					return false;
    				}
    			}
    		}else{
    			return false;
    		}
    	}
    	
    	return stack.isEmpty();
    }

}
