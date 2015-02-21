package Reorder_List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
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
		q.reorderList(l1);
		while (l1 != null){
			System.out.print(l1.val + ",");
			l1 = l1.next;
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/reorder-list/
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, 
	 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * 
	 * You must do this in-place without altering the nodes' values.
	 * 
	 * For example, 
	 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 */
	
	//此題不需要dummy， 因为head已经确定了。
	// http://blog.csdn.net/linhuanmars/article/details/21503215
    public void reorderList(ListNode head) {
    	if (head == null) {
    		return;
    	}
    	ListNode walker = head;
    	ListNode runner = head;
    	while (runner != null && runner.next != null) {
    		runner = runner.next.next;
    		walker = walker.next;
    	}
    	ListNode head1 = head; // 不要真正地移动head，因为如果移动head，就无法用head所在位置表示该链表了
    	ListNode head2 = walker.next; // head2为后半段的表头
    	walker.next = null; // 把前半段和后半段分开
    	head2 = reverse(head2);
    	while (head1 != null && head2 != null) {
    		ListNode next1= head1.next;
    		ListNode next2= head2.next;
    		head1.next = head2;
    		head2.next = next1;
    		head1 = next1;
    		head2 = next2;
    	}
    }
    
    //reverse链表要熟练掌握（一共四步）
    private ListNode reverse(ListNode head) {
    	ListNode tail = head; //【注】始终不更新cur，是因为cur指向最原始的头，它最终会变成尾。而head则一直在更新。
    	while(tail != null && tail.next != null){
    		ListNode next = tail.next;
    		tail.next = next.next;
    		next.next = head;
    		head = next;
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
