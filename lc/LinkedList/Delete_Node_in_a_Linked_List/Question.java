package Delete_Node_in_a_Linked_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/delete-node-in-a-linked-list/
	 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
	 * the linked list should become 1 -> 2 -> 4 after calling your function.
	 */

    public void deleteNode(ListNode node) {
        //use the next val to replace current value, and to do this iteartively till the end
        if (node == null) {
        	return;
        }
        ListNode next = node.next;
        if (next == null) {
        	node = null;
        	return;
        }
        while (next != null) {
        	node.val = next.val;
        	if (next.next == null) {
        	    node.next = null;
        	    return;
        	}
        	node = node.next;
        	next = next.next;
        }
        return;
    }
}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}