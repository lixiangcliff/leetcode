package Linked_List_Cycle_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://answer.ninechapter.com/solutions/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null){
        	return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(true){
        	if (slow == fast){
        		break;
        	}
        	if (fast.next == null || fast.next.next == null){
        		return null;
        	}
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        while(slow != head){
        	slow = slow.next;
        	head = head.next;
        }
        return head;
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
