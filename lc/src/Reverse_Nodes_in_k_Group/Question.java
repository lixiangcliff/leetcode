package Reverse_Nodes_in_k_Group;

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
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode head = l1;
		while(head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println("");
		//ListNode head2 = reverseKGroup(l1, 3);
/*		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}*/
	}
	//my way;
/*    public static ListNode reverseKGroup(ListNode head, int k) {
    	if (k==1){
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode cur = head;
    	ListNode tail = dummy;
    	while(cur != null){
    		ListNode groupDummy = new ListNode(0);
    		ListNode groupTail = cur;
    		int i = 0;
    		ListNode runner = cur;
    		while(runner != null && i<k){
    			runner = runner.next; // cannnot be missed
    			i++;
    		}
    		boolean enoughK = i == k? true : false;
    		i=0;
    		if (enoughK){
				while(cur != null && i<k){
					ListNode next = cur.next; // cur.next must be kept before doing manipulation on cur, otherwise cur.next will change 
					cur.next = groupDummy.next;
					groupDummy.next = cur;
					if (i==0){
						groupTail = cur;
					}
					cur = next;
					i++;
				}
					tail.next = groupDummy.next;
					tail = groupTail;
    		}else{
    			tail.next = cur;
    			break;
    		}
    	}
    	return dummy.next;
    }*/
    
    //http://blog.csdn.net/linhuanmars/article/details/19957455
    //need to understand "reversre" function well
/*    public ListNode reverseKGroup(ListNode head, int k) {  
    	
    }
    
    private ListNode reverse(ListNode pre, ListNode end) {
    	
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
