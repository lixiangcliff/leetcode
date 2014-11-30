package Remove_Duplicates_from_Sorted_List_II;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(5);
		ListNode l8 = new ListNode(6);
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
		head = deleteDuplicates(l1);
		while (head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * 
	 * For example, 
	 * Given 1->2->3->3->4->4->5, return 1->2->5. 
	 * Given 1->1->1->2->3, return 2->3.
	 */
	//http://blog.csdn.net/linhuanmars/article/details/24389429
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next == null){
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;//
        while(cur!=null){
        	/*
        	 * 可以理解为：如果当前node(pre.next)值和下一个node(cur.next)值相等
        	 * 跳出循环的条件之一是pre.next.val!=cur.next.val
        	 * 即cur.next.val为一个不重复的值(不同于pre.next.val), 换言之cur.val仍然是重复的值(仍为pre.next.val)
        	 */
        	while(cur.next != null && pre.next.val == cur.next.val){
        		cur = cur.next;
        	}
        	if(pre.next == cur){//即从pre.next到当前cur没有出现重复元素，则平pre前进一个
        		pre = pre.next;
        	}else{//有重复元素出现，删除从pre.next到当前cur(包括cur，因为上面分析了，cur.val也是重复的值)的所有元素
        		pre.next = cur.next;
        	}
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
