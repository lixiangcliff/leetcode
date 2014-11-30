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
	//http://blog.csdn.net/linhuanmars/article/details/24354291
	public static ListNode deleteDuplicates(ListNode head) {
		/*
		 * 思路是维护两个指针，一个指向不重复的最后一个node，另一个作为当前node往后跑
		 */
		if(head==null || head.next ==null){
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur != null){
			//如果重复了，则把当前node剔除
			if (cur.val == pre.val){
				pre.next = cur.next;
			}else{//若不重复，则pre向下移动
			    pre =  pre.next;
			}
			cur = cur.next;
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