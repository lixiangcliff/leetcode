package Remove_Duplicates_from_Sorted_List_II;



public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(5);
		ListNode l8 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		ListNode head = l1;
		
		while (head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println("");
		head = deleteDuplicates(l1);
		while (head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24389429
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next == null){
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;//pre will track the node that will be kept; i.e pre.next is the starting node to be removed
        ListNode cur = head;
        int count = 1;
        while(cur!=null){
        	if (cur.next != null && cur.next.val == pre.next.val){
        		count++;
        	}else{
        		if(count>1){
        			//romove node from "pre.next ~ cur"
        			pre.next = cur.next;
        		}else{
        			//means keep "cur" in result
        			pre = cur;
        		}
        		count=1;
        	}
        	cur = cur.next;
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
