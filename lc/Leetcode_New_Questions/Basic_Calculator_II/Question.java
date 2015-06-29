package Basic_Calculator_II;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/basic-calculator-ii/
	 * Implement a basic calculator to evaluate a simple expression string.
	 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
	 * The integer division should truncate toward zero.
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples:
	 * "3+2*2" = 7
	 * " 3/2 " = 1
	 * " 3+5 / 2 " = 5
	 * 
	 * Note: Do not use the eval built-in library function.
	 */
	
	//https://leetcode.com/discuss/41627/easy-c-solution-with-detailed-explanations
    public int calculate(String s) {
    	ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
    	ArrayDeque<Character> ops = new ArrayDeque<Character>();
    	
        return 0;
    }
    
    private void cal(LinkedList<Integer> s1, LinkedList<Character> s2) {
    	int num1 = s1.pop();
    	int num2 = s1.pop();
    	char oper = s2.pop();
    	int res = 0;
    	if (oper == '+') {
    		res = num1 + num2;
    	} else if (oper == '-'){
    		res = num1 - num2;
    	}
    	s1.push(res);
    }

}
