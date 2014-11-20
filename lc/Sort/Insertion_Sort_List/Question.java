package Insertion_Sort_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		ListNode head = l1;
		while(head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
		
		ListNode head2 = insertionSortList(l1);
		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}
		
	}
	
	//my way
/*    public static ListNode insertionSortList(ListNode head) {
    	if (head == null){
    		return null;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
        ListNode runner = head.next;
        ListNode pre =  head;
        while(runner != null){
        	ListNode currentNext = runner.next;
        	ListNode position = dummy;
        	boolean foundPos = false;
        	while(position!= pre){
        		if (runner.val <= position.next.val){//find position
        			runner.next = position.next;
        			position.next = runner;
        			foundPos = true;
        			break;
        		}
        		position = position.next;
        	}
        	if(foundPos){
        		//pre.next = runner.next; // wrong! runner may have already be moved!!
        		pre.next = currentNext;
        	}else{
        		pre = pre.next;
        	}
        	//pre = pre.next; // wrong! 
        	//runner = runner.next; // wrong! runner may have already be moved!!
        	runner = currentNext;
        }
        return dummy.next;
    }*/
    
    //similar way but simpler code
    //http://blog.csdn.net/linhuanmars/article/details/21144553
	 public static ListNode insertionSortList(ListNode head) {
		 if (head == null){
			 return null;
		 }
		 ListNode dummy = new ListNode(0);
		 ListNode pre = dummy;
		 ListNode cur = head;
		 //first loop(cur == head) will cut the head from original linkedlist and
		 //put it at the tail of dummy's tail;
		 //from second loop(cur == head.next), pick each new start node and 
		 //insert it into dummy's linkedlist
		 while(cur != null){
			 pre = dummy;
			 ListNode next = cur.next;
			 while(pre.next != null && cur.val >= pre.next.val){
				 pre = pre.next;
			 }
			 cur.next = pre.next;
			 pre.next = cur;
			 cur = next;
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
