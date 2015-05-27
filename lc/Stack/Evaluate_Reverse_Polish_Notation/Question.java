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
	//【注】 严谨的话，每次pop()之前都要先检查stack是否empty。
	//代码里三个【可能】可以写的更严谨
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();
		String opers = "+-*/";
		for (String token : tokens) {
			if (!opers.contains(token)) { //【注】判断是符号还是数字的技巧
				stack.push(Integer.parseInt(token));
			} else {
				int num2 = stack.pop(); //先弹出操作数
				int num1 = stack.pop(); //后弹出被操作数
				if (token.equals("+")) {
					stack.push(num1 + num2);
				} else if (token.equals("-")) {
					stack.push(num1 - num2);
				} else if (token.equals("*")) {
					stack.push(num1 * num2);	//【可能】溢出。
				} else if (token.equals("/")) {
					stack.push(num1 / num2); //【可能】num2 == 0。
				}
			}
		}
		return stack.pop(); //【可能】pop完之后stack里仍有剩余。
	}
    
}
