package Evaluate_Reverse_Polish_Notation;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(q.evalRPN(tokens));
	}
	
	/**
	 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation. Valid operators are +, -, *, /. 
	 * Each operand may be an integer or another expression.
	 * 
	 * Some examples: 
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
	 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	
	// http://www.ninechapter.com/solutions/evaluate-reverse-polish-notation/
	// http://www.cnblogs.com/yuzhangcmu/p/4124870.html
	//【注】 严谨的话，每次pop()之前都要先检查stack是否empty
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();
		String opers = "+-*/";
		for (String token : tokens) {
			if (!opers.contains(token)) {
				stack.push(Integer.parseInt(token));
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				if (token.equals("+")) {
					stack.push(num1 + num2);
				} else if (token.equals("-")) {
					stack.push(num1 - num2);
				} else if (token.equals("*")) {
					stack.push(num1 * num2);
				} else if (token.equals("/")) {
					stack.push(num1 / num2);
				}
			}
		}
		return stack.pop();
	}
    
}
