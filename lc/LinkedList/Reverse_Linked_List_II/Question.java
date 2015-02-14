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
	
	/**
	 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass.
	 * 
	 * For example: 
	 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of
	 * list.
	 */
	
	// http://blog.csdn.net/linhuanmars/article/details/24613781
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		int i = 1;// i从始至终作为标记， 表示现在走到了哪里，对于确定m和n的位置很方便
		while (pre.next != null && i < m) {
			pre = pre.next;
			i++;
		}
		if (i < m) { // 表长度小于m
			return head;
		}
		ListNode mNode = pre.next;
		ListNode cur = mNode.next;
		while (cur != null && i < n) {//画图！依次从m后面直到n，拿node塞在preNode的后边（preNode.next = cur） 一共拿来n-m次（如果链表长度足够n的话），故边界条件是i<n
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
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
