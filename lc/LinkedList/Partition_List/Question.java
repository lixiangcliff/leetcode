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
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		
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
    	/*
    	 * 中心思想是制造两个dummy：
    	 * beforeDummy.next指向比x小的元素组成的链表；
    	 * afterDummy.next指向和x相等或者比x大的元素组成的链表
    	 * 用head作为iter在原链表上跑
    	 * before作为iter在beforeDummy链表上跑
    	 * after作为iter在afterDummy链表上跑
    	 * head跑时候根据x值得不同决定把当前node分配到before还是after的list上
    	 * 最后要分别处理两个list的尾巴
    	 * 对after要把after.next置为null
    	 * 对before要把before和after连上(before.next = afterDummy.next;)
    	 */
    	ListNode beforeDummy = new ListNode(0);
    	ListNode afterDummy = new ListNode(0);
    	ListNode before = beforeDummy;
    	ListNode after = afterDummy;
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
    	//这步不能少，因为如果最后一个node不是等于x或者比x大的话，那么after.next并不是null，而是他的下一个有效node，则会出错！
    	after.next = null;
    	//把before和after连上
    	before.next = afterDummy.next;
    	return beforeDummy.next;
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
