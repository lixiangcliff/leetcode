package Reverse_Linked_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Reverse a singly linked list.
	 */
	
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        while (head.next != null) {
        	ListNode next = head.next;
        	head.next = next.next;
        	next.next = pre.next;
        	pre.next = next;
        }
        return pre.next;
    }
	

}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}