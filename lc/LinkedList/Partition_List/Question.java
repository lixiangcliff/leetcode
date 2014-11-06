package Partition_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1->4->3->2->5->2
/*		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;*/
		
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		l1.next = l2;
		/*l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;*/
		
		
		ListNode head = l1;
		int x = 2;
		ListNode newHead = partition(head, x);
		while(newHead != null){
			System.out.print(newHead.val + ",");
			newHead = newHead.next;
		}

	}
	
	//http://answer.ninechapter.com/solutions/partition-list/
    public static ListNode partition(ListNode head, int x) {
    	if(head == null){
    		return null;
    	}
    	ListNode beforeHead = new ListNode(0);
    	ListNode afterHead = new ListNode(0);
    	ListNode before = beforeHead;
    	ListNode after = afterHead;
    	while(head != null){
    		if(head.val < x){
    			before.next = head;
    			before = before.next;
    		}else {
    			after.next = head;
    			after = after.next;
    		} 
    		head = head.next;
    	}
    	//Cannot miss!!! otherwise, if the last ListNode is not "after", after.next will not be null!
    	after.next = null;
    	before.next = afterHead.next;
    	return beforeHead.next;
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
