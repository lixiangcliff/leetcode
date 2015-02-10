package Merge_Two_Sorted_Lists;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
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
		ListNode l3 = q.mergeTwoLists(l1,l2);
		ListNode l3current = l3;
		while(l3current!=null){
			System.out.println("----:" + l3current.val);
			l3current = l3current.next;
		}
	}
    
	/**
	 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 */
	
	//simpler code; dummy ListNode reduce the redundancy!  
    //http://answer.ninechapter.com/solutions/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        //只有l1 l2同时不等于null时，循环才能继续，这是因为循环体里有l1.val,l2.val,li.next以及l2.next操作
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) {//l1的list上还有剩余node
            pre.next = l1;
        } else {		//l2的list上还有剩余node
            pre.next = l2;
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