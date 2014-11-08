package Swap_Nodes_in_Pairs;


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
		ListNode head2 = swapPairs(l1);
		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}
	}
	
	public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null &&cur.next!=null){
        	ListNode next = cur.next;
        	/*
        	 * pre.next= next;这行很重要
        	 * 在第一次循环的时候相当于dummy.next=next（即dummy.next指向第二个元素）
        	 * 在此之后pre被更新，以后dummy再也不会跟随pre的变化而变化
        	 */
        	pre.next= next;
        	cur.next = next.next;
        	next.next = cur;
        	pre = cur;
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