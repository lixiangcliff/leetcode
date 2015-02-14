package Reverse_Nodes_in_k_Group;

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
		ListNode head2 = q.reverseKGroup(l1, 2);
		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
	 * Given a linked list, reverse the nodes of a linked list k at a time and
	 * return its modified list. If the number of nodes is not a multiple of k
	 * then left-out nodes in the end should remain as it is. You may not alter
	 * the values in the nodes, only nodes itself may be changed. Only constant
	 * memory is allowed.
	 * 
	 * For example, 
	 * Given this linked list: 1->2->3->4->5 
	 * For k = 2, you should return: 2->1->4->3->5 
	 * For k = 3, you should return: 3->2->1->4->5
	 */
	
    //http://blog.csdn.net/linhuanmars/article/details/19957455
    //need to understand "reverse" function well
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int count = 0;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			count++;
			ListNode next = cur.next; // 要提前把cur.next存好。不然如果经过if里面的处理，再取cur.next，取的就不是原来的了
			if (count == k) { // only do reverse when reach to k nodes
				pre = reverse(pre, next); // 新的pre往右挪了k个node的位子
				count = 0;
			}
			cur = next;
		}
		return dummy.next;
	}

	// 这个函数不但把pre和end之间的所有node reverse了，而且保证reverse之后，中间被reverse的node 左边仍连接平pre,右边仍连接end.
	// 关于这个函数的两个参数pre和 end: pre的下一个node是k个node里面的第1个 end的前一个node是k个node里面的第k个。即pre和end之间夹的node一共有k个
	private ListNode reverse(ListNode pre, ListNode end) {
		if (pre == null || pre.next == null) {
			return pre;
		}
		ListNode head = pre.next;// 把head保留起来，reverse之后和end接上
		ListNode cur = pre.next.next;
		while (cur != end) {
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur; // connect from "left" side每一轮都把右边挪过来的node和左边的pre接上
			cur = next;
		}
		head.next = end; // connect from "right" side (connect kth node to k.next)最后把之前保留好的head和end接上
		return head; // 返回的head作为下一轮新的pre（如果还有下一轮的话）
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
