package Implement_Queue_by_Stacks;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * http://lintcode.com/en/problem/implement-queue-by-stacks/
	 * As the title described, you should only use two stacks to implement a
	 * queue's actions.
	 * The queue should support push(element), pop() and top() where pop is pop
	 * the first(a.k.a front) element in the queue.
	 * Both pop and top methods should return the value of first element.
	 * 
	 * Example For push(1), pop(), push(2), push(3), top(), pop(), you should
	 * return 1, 2 and 2
	 * 
	 * Challenge implement it by two stacks, do not use any other data structure
	 * and push, pop and top should be O(1) by AVERAGE.
	 */
	
	

}
class StackedQueue {
	private LinkedList<Integer> stack1;
	private LinkedList<Integer> stack2;
	
	public StackedQueue() {
		stack1 = new LinkedList<Integer>();
		stack2 = new LinkedList<Integer>();
	}
	
	public void push(int element) {
		stack1.push(element);
	}
	
	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} 
		return stack2.pop();
	}
	
	public int top() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} 
		return stack2.peek();
	}
}