package Rotate_List;

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
/*		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(5);
		ListNode l8 = new ListNode(6);*/
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
	/*	l5.next = l6;
		l6.next = l7;
		l7.next = l8;*/
		ListNode head = l1;
		
		while (head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println("");
		head = q.rotateRight(l1, 10);
		while (head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/rotate-list/
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example: 
	 * Given 1->2->3->4->5->NULL and k = 2, 
	 * return 4->5->1->2->3->NULL.
	 */
	
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode walker = head;
		ListNode runner = head;
		int count = 0;
		while (runner != null) {// 先计算链表长度
			runner = runner.next;
			count++;
		}
		n %= count;// 如果n大于链表长度，则取余
		runner = head;// 重新把runner放回表头
		for (int i = 0; i < n; i++) { // 这样做是为了方便walker用walker.next处理表尾
			if (runner.next != null) { // 这样保证跳出循环时，runner停在最后一位，walker的下一位 就是要放在新链表最前面一位的
				runner = runner.next;
			} else {
				break;
			}
		}
		while (runner.next != null) { // 只要runner还在链表内
			runner = runner.next;
			walker = walker.next;
		}
		runner.next = head; // 表尾接表头
		head = walker.next; // 更新head
		walker.next = null; // 使新表尾指向null
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
