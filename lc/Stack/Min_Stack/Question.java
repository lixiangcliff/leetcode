package Min_Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

//http://blog.csdn.net/linhuanmars/article/details/41008731
//不能通过leetcode “Memory Limit Exceeded”，不知道为什么。ArrayList，Stack都试过了，也不行… =。=
class MinStack {
	private LinkedList<Integer> stack;
	private LinkedList<Integer> minStack;

	public MinStack() {
		stack = new LinkedList();
		minStack = new LinkedList();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			minStack.push(x);
		} else {
			minStack.push(Math.min(minStack.peek(), x));
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		int item = stack.pop();
		if (!minStack.isEmpty() && item == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		return Integer.MAX_VALUE;
	}

	public int getMin() {
		if (!minStack.isEmpty()) {
			return minStack.peek();
		}
		return Integer.MAX_VALUE;
	}
}

