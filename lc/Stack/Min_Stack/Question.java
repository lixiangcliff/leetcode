package Min_Stack;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * https://oj.leetcode.com/problems/min-stack/ 
		 * Design a stack that supports push, pop, top, and retrieving the
		 * minimum element in constant time.
		 * 
		 * push(x) -- Push element x onto stack.
		 * pop() -- Removes the element on top of the stack.
		 * top() -- Get the top element. 
		 * getMin() -- Retrieve the minimum element in the stack.
		 */
		Question q = new Question();
		MinStack ms = new MinStack();
		ms.push(1);
		ms.pop();
		ms.push(2);
		ms.push(3);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		
	}

}

/**
 * https://leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
 *
 */

//原则：1. minStack从栈顶到栈底是递增的(相邻元素壳相等)
//2.入栈时，当x <= min栈顶时，则入min栈
//3.出栈时，当stack栈顶 == min栈顶时，则从min出栈
//http://blog.csdn.net/linhuanmars/article/details/41008731
class MinStack {
	LinkedList<Integer> stack = new LinkedList<Integer>();
	LinkedList<Integer> minStack = new LinkedList<Integer>();

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		int elem = stack.pop();
		if (elem == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
