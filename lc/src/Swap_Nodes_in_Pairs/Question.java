package Swap_Nodes_in_Pairs;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){ // 0 or 1 node
        	return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while(true){
        	int temp = left.val;
        	left.val = right.val;
        	right.val = temp;
        	if(right.next == null ||right.next.next ==null){
        		return head;
        	}
        	left = right.next;
        	right = left.next;
        }
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