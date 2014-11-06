package Remove_Nth_Node_From_End_of_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		//ListNode node3 = new ListNode(3);
		node1.next = node2;
		//node2.next = node3;
		ListNode head = node1;
		ListNode current = head;		
		
		while(current != null){
			System.out.print(current.val + ",");
			current = current.next;
		}
		System.out.println("=========");
		removeNthFromEnd(head, 1);
		current = head;
/*		while(current != null){
			System.out.print(current.val + ",");
			current = current.next;
		}*/

	}
	
	//works locally BUT..
	//dont know why it does not work on leetcode
    /*public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null || head.next == null){
    		return null;
    	}
    	
    	ListNode previous = head;
    	ListNode current = head.next;
    	ListNode runner = head.next;
    	
    	for(int i=1;i<n;i++){
    		if(runner.next == null){
    			return null;
    		}else{
    			runner = runner.next;
    		}
    	}
    	
    	while(runner.next != null){
    		runner = runner.next;
    		current = current.next;
    		previous = previous.next;
    	}
    	
    	if (previous == head){ //remove head(when n equals the number of nodes)
    		head = current.next;
    	}else{
    		previous.next = current.next;
    	}
    	
    	return current;
    }*/
	
	//http://answer.ninechapter.com/solutions/remove-nth-node-from-end-of-list/
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null){
    		return null;
    	}
    	ListNode dummy = new ListNode(0);
    	ListNode previous = dummy;
    	previous.next = head;
    	ListNode current = head;
    	ListNode runner = head;
    	
    	for(int i=1;i<n;i++){
    		if(runner == null){
    			return null;
    		}else{
    			runner = runner.next;
    		}
    	}
    	
    	while(runner.next != null){
    		runner = runner.next;
    		current = current.next;
    		previous = previous.next;
    	}
    	previous.next = previous.next.next;
    	
	    while(head != null){
			System.out.print(head.val + ",");
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
         next = null;
     }
 }