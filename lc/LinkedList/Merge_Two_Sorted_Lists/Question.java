package Merge_Two_Sorted_Lists;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l1_2 = new ListNode(3);
		ListNode l1_3 = new ListNode(5);
		ListNode l1_4 = new ListNode(9);
		l1.next = l1_2;
		l1_2.next = l1_3;
		l1_3.next = l1_4;
		
		ListNode l2 = new ListNode(2);
		ListNode l2_2 = new ListNode(3);
		ListNode l2_3 = new ListNode(4);
		ListNode l2_4 = new ListNode(8);
		l2.next = l2_2;
		l2_2.next = l2_3;
		l2_3.next = l2_4;
		ListNode l3 = mergeTwoLists(l1,l2);
		ListNode l3current = l3;
		while(l3current!=null){
			System.out.println("----:" + l3current.val);
			l3current = l3current.next;
		}
	}
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {    	
    	if(l1 == null && l2 == null){
    		return null;
    	}else if(l1 == null){
    		return l2;
    	} else if(l2 == null){
    		return l1;
    	} 
    	ListNode l1current =  l1;
    	ListNode l2current =  l2;
    	ListNode l3;
    	if (l1current.val <= l2current.val){
    		l3 = new ListNode(l1current.val);
    		l1current = l1current.next;
    	}else{
    		l3 = new ListNode(l2current.val);
    		l2current = l2current.next;
    	}
    	ListNode l3current = l3;
    	while(l1current != null && l2current != null){
    		if (l1current.val <= l2current.val){
    			l3current.next = new ListNode(l1current.val);
    			l3current = l3current.next;
        		l1current = l1current.next;
        	}else{
        		l3current.next = new ListNode(l2current.val);
        		l3current = l3current.next;
        		l2current = l2current.next;
        	}
    	}    	
    	if (l1current == null && l2current == null){
    		return l3;
    	}else if(l1current == null){
    		l3current.next = l2current; 
    		return l3;
    	}else if(l2current == null){
    		l3current.next = l1current; 
    		return l3;
    	}else{
    		return null;
    	}
    }
    
  //simpler code; dummy ListNode reduce the redundancy!  
    //http://answer.ninechapter.com/solutions/merge-two-sorted-lists/
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
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