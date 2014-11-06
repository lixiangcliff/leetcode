package Rotate_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
/*		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(5);
		ListNode l8 = new ListNode(6);*/
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
	/*	l5.next = l6;
		l6.next = l7;
		l7.next = l8;*/
		ListNode head = l1;
		
		while (head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println("");
		head = rotateRight(l1, 10);
		while (head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
/*    public static ListNode rotateRight(ListNode head, int n) {
    	if (head == null){
    		return null;
    	}
    	ListNode walker = new ListNode(0);
    	walker.next = head;
    	ListNode pre = walker;
    	ListNode runner = head;
    	int count = 0;
    	for(int i=0;i<n;i++){
    		if(runner.next != null){
    			pre = pre.next;
    			runner = runner.next;
    			count++;
    		}else{
    			break;
    		}
    	}
    	if(count == n){
	    	while(runner.next != null){
	    		runner = runner.next;
	    		walker = walker.next;
	    	}
	    	runner.next = head;
	    	head = walker.next.next;
	    	walker.next.next = null;
    	}else{
    		runner.next =  head;
    		head = runner;
    		pre.next = null;
    		
    	}
    	return head;
    	
    }*/
	
	public static ListNode rotateRight(ListNode head, int n){
		if (head == null){
    		return null;
    	}
		ListNode walker = head;
		ListNode runner = head;
		int count = 0;
		while(runner != null){
			runner = runner.next;
			count++;
		}
		//n is possibly bigger than linklist's size
		n %= count;
		runner = head;
    	for(int i=0;i<n;i++){
    		if(runner.next != null){
    			runner = runner.next;
    			count++;
    		}else{
    			break;
    		}
    	}
    	while(runner.next != null){
    		runner = runner.next;
    		walker = walker.next;
    	}
    	runner.next = head;
    	head = walker.next;
    	walker.next= null;
    	return head;
	}
	
	/*public static ListNode rotateRight(ListNode head, int n) {
	    if(head == null)
	    {
	        return null;
	    }
	    ListNode walker = head;
	    ListNode runner = head;
	    int idx = 0;
	    while(runner!=null && idx<n)
	    {
	        runner = runner.next;
	        idx++;
	    }
	    if(runner == null)
	    {
	        n %= idx;
	        runner = head;
	        idx=0;
	        while(runner!=null && idx<n)
	        {
	            runner = runner.next;
	            idx++;
	        }
	    }
	    while(runner.next!=null)
	    {
	        walker = walker.next;
	        runner = runner.next;
	    }
	    runner.next = head;
	    ListNode newHead = walker.next;
	    walker.next = null;
	    return newHead;
	}*/
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
