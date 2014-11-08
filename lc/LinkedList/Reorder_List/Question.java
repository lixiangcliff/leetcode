package Reorder_List;


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
		reorderList(l1);
		while (l1 != null){
			System.out.print(l1.val + ",");
			l1 = l1.next;
		}

	}
	
	//my way
	//refered to http://blog.csdn.net/linhuanmars/article/details/21503215
    public static void reorderList(ListNode head) {
    	if(head == null){
    		return;
    	}
    	ListNode walker = head;
    	ListNode runner = head;
    	while(runner != null && runner.next != null){
    		runner = runner.next.next;
    		walker = walker.next;
    	}
    	/*【注】
    	 * e.g原始链表为1->2->3->4->5->6
    	 * 上面操作之后
    	 * head1:1->2->3->4
    	 * head2:5->6
    	 */
    	ListNode head1 = head;//不要真正地移动head，因为如果移动head，函数执行完之后就找不到表头了
    	ListNode head2 = walker.next;//head2为后半段的表头
    	walker.next = null;//把前半段和后半段分开
    	head2 = reverse(head2);
    	while(head1!=null && head2 != null){
    		ListNode next1= head1.next;
    		ListNode next2= head2.next;
    		head1.next = head2;
    		head2.next = next1;
    		head1 = next1;
    		head2 = next2;
    	}
    }
    
    private static ListNode reverse(ListNode head){
    	ListNode cur = head;
    	while(cur != null && cur.next != null){
    		ListNode next = cur.next;
    		cur.next = next.next;
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
