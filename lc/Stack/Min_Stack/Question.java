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

//http://blog.csdn.net/linhuanmars/article/details/41008731
class MinStack {
	LinkedList<Integer> stack = new LinkedList<Integer>();
	LinkedList<Integer> minStack = new LinkedList<Integer>();

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || minStack.peek() >= x) {
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
