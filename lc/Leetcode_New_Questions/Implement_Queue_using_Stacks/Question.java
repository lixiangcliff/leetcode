package Implement_Queue_using_Stacks;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/implement-queue-using-stacks/
	 * Implement the following operations of a queue using stacks.
	 * 
	 * push(x) -- Push element x to the back of queue.
	 * pop() -- Removes the element from in front of queue.
	 * peek() -- Get the front element.
	 * empty() -- Return whether the queue is empty.
	 * 
	 * Notes:
	 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
	 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), 
	 * as long as you use only standard operations of a stack.
	 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
	 */

}


// same as Implement_Queue_by_Stacks in lintcode
class MyQueue {        
	private LinkedList<Integer> stack1;
	private LinkedList<Integer> stack2;
	
	public MyQueue() {
		stack1 = new LinkedList<Integer>();
		stack2 = new LinkedList<Integer>();
	}
	// Push element x to the back of queue.
	public void push(int element) { // push时，全都压入第一个栈
		stack1.push(element);
	}
	
	// Removes the element from in front of queue.
	public int pop() {
		if (stack2.isEmpty()) { // pop时，如果第二个栈为空，则把第一个栈里的所有内容压入第一个栈。最后从第二个栈弹出。
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} 
		return stack2.pop();
	}
	
	// Get the front element.
	public int peek() { // 和pop类似，唯一区别是最后从第二个栈中只是peek，而不是弹出元素。
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} 
		return stack2.peek();
	}
	
	// Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
}