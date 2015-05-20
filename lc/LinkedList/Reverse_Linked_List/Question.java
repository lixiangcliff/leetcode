package Reverse_Linked_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/reverse-linked-list/
	 * Reverse a singly linked list.
	 */
	
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
        	ListNode next = cur.next;
        	cur.next = next.next;
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