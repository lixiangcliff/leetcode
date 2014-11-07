package Reverse_Linked_List_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l1b = new ListNode(2);
		ListNode l1c = new ListNode(3);
		ListNode l1d = new ListNode(4);
		ListNode l1e = new ListNode(5);
		l1.next = l1b;
		l1b.next = l1c;
		l1c.next = l1d;
		l1d.next = l1e;
	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24613781
	public ListNode reverseBetween(ListNode head, int m, int n){
		if (head == null){
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode preNode = dummy;
		int i=1;//i从始至终作为标记走到哪里，对于确定m和n的位置很方便
		while(preNode.next != null && i<m){
			preNode = preNode.next;
			i++;
		}
		if(i<m){ //表长度小于m
			return head;
		}
		ListNode mNode = preNode.next;
		ListNode cur = mNode.next;
		/*
		 * 思想是：依次从m后面直到n，拿来node塞在preNode的后边（preNode.next = cur）
		 * 一共拿来n-m次（如果链表长度足够n的话），所以边界条件是i<n
		 */
		while(cur != null && i<n){
			ListNode next = cur.next;
			cur.next = preNode.next;
			preNode.next = cur;
			mNode.next = next;
			cur = next;
			i++;
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
