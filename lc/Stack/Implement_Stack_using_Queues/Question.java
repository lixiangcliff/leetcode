package Implement_Stack_using_Queues;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/implement-stack-using-queues/
	 * Implement the following operations of a stack using queues.
	 * push(x) -- Push element x onto stack.
	 * pop() -- Removes the element on top of the stack.
	 * top() -- Get the top element.
	 * empty() -- Return whether the stack is empty.
	 * 
	 * Notes:
	 * You must use only standard operations of a queue -- which means only 
	 * push to back, peek/pop from front, size, and is empty operations are valid.
	 * Depending on your language, queue may not be supported natively. 
	 * You may simulate a queue by using a list or deque (double-ended queue), 
	 * as long as you use only standard operations of a queue.
	 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
	 */

}
// Only push is O(n), others are O(1). Using one queue.
//https://leetcode.com/discuss/40202/only-push-others-using-queue-combination-shared-solutions
class MyStack {
	LinkedList<Integer> q;
	
	MyStack() {
		q = new LinkedList<Integer>();
	}
	
	// Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++) {
        	q.offer(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}

//my own way using two queues, not efficient
/*class MyStack {
	LinkedList<Integer> q1;
	LinkedList<Integer> q2;
	boolean curIsQ1;
	
	public MyStack() {
		this.q1 = new LinkedList<Integer>();
		this.q2 = new LinkedList<Integer>();
		this.curIsQ1 = true;
	}
	
    // Push element x onto stack.
    public void push(int x) {
        if (curIsQ1) {
        	q1.offer(x);
        } else {
        	q2.offer(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
    	int val = 0;
        if (curIsQ1) {
        	while (!q1.isEmpty()) {
        		val = q1.poll();
        		if (!q1.isEmpty()) {
        			q2.offer(val);
        		}
        	}
        } else {
        	while (!q2.isEmpty()) {
        		val = q2.poll();
        		if (!q2.isEmpty()) {
        			q1.offer(val);
        		}
        	}
        }
        curIsQ1 = !curIsQ1;
    }

    // Get the top element.
    public int top() {
    	int val = 0;
        if (curIsQ1) {
        	while (!q1.isEmpty()) {
        		val = q1.poll();
        		q2.offer(val);
        	}
        } else {
        	while (!q2.isEmpty()) {
        		val = q2.poll();
        		q1.offer(val);
        	}
        }
        curIsQ1 = !curIsQ1;
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
       return q1.isEmpty() && q2.isEmpty(); 
    }
}*/
