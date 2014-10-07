package Linked_List_Cycle;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	
    public static boolean hasCycle(ListNode head) {
        if(head ==null || head.next == null){
            return false;
        }
        ListNode current = head;
        ListNode runner = head;
        while(runner != null && runner.next !=null){
        	if (current == runner){
        		return true;
        	}
        	current = current.next;
        	runner = runner.next.next;
        }
        return false;
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