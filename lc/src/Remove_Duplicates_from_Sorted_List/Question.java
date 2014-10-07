package Remove_Duplicates_from_Sorted_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next ==null){
			return head;
		}
		ListNode previous = head;
		ListNode current = head.next;
		
		while(current != null){
			if (current.val == previous.val){
				previous.next = current.next;
			}else{
			    previous =  previous.next;
			}
			current = current.next;
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