package Remove_Duplicates_from_Sorted_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, 
	 * Given 1->1->2, return 1->2. 
	 * Given 1->1->2->3->3, return 1->2->3.
	 */
	
	//思路是维护两个往右走的指针pre和cur，一个指向不重复的最后一个node，另一个作为当前node往后跑
	//http://blog.csdn.net/linhuanmars/article/details/24354291
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			if (cur.val == pre.val) { // 如果重复了，则把当前node剔除
				pre.next = cur.next;
			} else { // 若不重复，则pre向右移动
				pre = pre.next;
			}
			cur = cur.next; // 不论是否重复 cur都向右移动
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