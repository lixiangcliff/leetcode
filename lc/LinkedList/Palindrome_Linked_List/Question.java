package Palindrome_Linked_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/palindrome-linked-list/
	 * Given a singly linked list, determine if it is a palindrome.
	 * Follow up:
	 * Could you do it in O(n) time and O(1) space?
	 */
	
	
	// 一分两半，翻转后半，然后对比，再把后半翻转回来，两半接上
    public boolean isPalindrome(ListNode head) {
    	if (head == null) { // no node
    		return true;
    	}
    	ListNode run = head.next;
    	ListNode walk = head;
    	int count = 1;
    	while (run != null && run.next != null) {
    		walk = walk.next;
    		run = run.next.next;
    		if (run == null) {
    			count += 1;
    		} else {
    			count += 2;
    		}
    	}
    	if (walk.next == run) { // there is only one or two nodes
    		if (run == null) { // one node
    			return true;
    		} else {	// two nodes
    			return walk.val == run.val;
    		}
    	}
    	ListNode h1 = head;
    	ListNode h2 = walk.next;
    	if (count % 2 == 1) { //如果有奇数个node，则在后半段的头，补一个前半段的尾
    		ListNode node = new ListNode(walk.val);
    		node.next = walk.next;
    		h2 = node;
    	}
    	h2 = reverse(h2);
    	while (h1 != null && h2 != null) {
    		if (h1.val != h2.val) {
    			return false;
    		}
    		h1 = h1.next;
    		h2 = h2.next;
    	}
        return true;
    }
    
    //背诵！
    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) {
        	return head;
        }
    	ListNode tail = head;
    	while (tail.next != null) {
    		ListNode next = tail.next;
    		tail.next = next.next;
    		next.next = head;
    		head = next;
    	}
    	return head;
    }
}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}