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
    	/*
    	 * 加法和乘法比较直接
    	 * 减法和除法有trick。尤其除法要把弹出的两个数先存起来，再做运算。
    	 * 每次pop之前，应该先判断stack是否为空，如果为空则报错。
    	 */
        for(int i=0;i<tokens.length;i++){
        	if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
        		stack.push(Integer.parseInt(tokens[i]));
        	}else{
        		int num1 = Integer.MAX_VALUE;
        		int num2 = Integer.MAX_VALUE;
        		if (!stack.isEmpty()){
        			num1 = stack.pop();
        		}else{
        			return Integer.MAX_VALUE;
        		}
        		if (!stack.isEmpty()){
        			num2 = stack.pop();
        		}else{
        			return Integer.MAX_VALUE;
        		}
        		
            	if(tokens[i].equals("+")){
            		stack.push(num1+num2);
            	}else if(tokens[i].equals("-")){
            		stack.push(num2-num1);
            	}else if(tokens[i].equals("*")){
            		stack.push(num1*num2);
            	}else if(tokens[i].equals("/")){
            		stack.push(num2/num1);
            	}
        	}
        }
        
        int result = Integer.MAX_VALUE;
        if(!stack.isEmpty()){
        	result = stack.pop();
        }
        if(stack.isEmpty()){
        	return result;
        }else{
        	return Integer.MAX_VALUE;
        }
    }
    
}
