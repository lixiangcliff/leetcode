package Evaluate_Reverse_Polish_Notation;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/21058857
    public static int evalRPN(String[] tokens) {
    	if(tokens == null || tokens.length == 0){
    		return 0;
    	}
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].equals("+")){
        		stack.push(stack.pop() + stack.pop());
        	}else if(tokens[i].equals("-")){
        		stack.push(-stack.pop() + stack.pop());
        	}else if(tokens[i].equals("*")){
        		stack.push(stack.pop() * stack.pop());
        	}else if(tokens[i].equals("/")){
        		//below is wrong:
        		//imagine: 5/4 == 1; but if you do 1/4 * 5 == 0 * 5 == 0
        		//stack.push((1/stack.pop()) * stack.pop());
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		stack.push(num2/num1);
        	}else{
        		stack.push(Integer.parseInt(tokens[i]));
        	}
        }
        return stack.pop();
    }

}
