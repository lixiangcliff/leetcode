package Remove_Linked_List_Elements;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/remove-linked-list-elements/
	 * Remove all elements from a linked list of integers that have value val.
	 * Example
	 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	 * Return: 1 --> 2 --> 3 --> 4 --> 5
	 */
	
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while (head != null) {
        	if (head.val != val) {
        		pre.next = head;
        		pre = head;
        	} else {
        		pre.next = head.next;
        	}
        	head = head.next;
        }
        return dummy.next;
    }
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
