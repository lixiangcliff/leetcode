package Implement_Queue_by_Stacks;

import java.util.LinkedList;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * http://www.lintcode.com/en/problem/implement-queue-by-two-stacks/
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
	
	public void push(int element) { // push时，全都压入第一个栈
		stack1.push(element);
	}
	
	public int pop() {
		if (stack2.isEmpty()) { // pop时，如果第二个栈为空，则把第一个栈里的所有内容压入第一个栈。最后从第二个栈弹出。
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} 
		return stack2.pop();
	}
	
	public int top() { // 和pop类似，唯一区别是最后从第二个栈中只是peek，而不是弹出元素。
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} 
		return stack2.peek();
	}
}