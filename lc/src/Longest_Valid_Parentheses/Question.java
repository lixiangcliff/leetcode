package Longest_Valid_Parentheses;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses(")()())"));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/20439613
    public static int longestValidParentheses(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	//important! stack maintain the index! not the '(' or ')'
    	//LinkedList<Character> stack = new LinkedList<Character>(); //wrong!
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	int max = 0;
    	int start = 0;
    	for(int i=0; i<s.length();i++){
    		if(s.charAt(i) == '('){
    			//important! stack maintain the index! not the '(' or ')'
    			//stack.push(s.charAt(i)); // wrong!
    			stack.push(i);
    		}else{
    			if(stack.isEmpty()){
    				start = i+1;
    			}else{
    				stack.pop();
    				//max = stack.isEmpty() ? Math.max(max, i-start+1) : Math.max(max, i-stack.peek()+1); // wrong!
    				max = stack.isEmpty() ? Math.max(max, i-start+1) : Math.max(max, i-stack.peek()); 
    			}
    		}
    	}
        return max;
    }

}
