package Sort_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/sort-list/
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/21133949
	public ListNode sortList(ListNode head){
		return mergeSort(head);
	}
	
	//之所以要单独写一个mergeSort的方法而不是把这个写在sortList里的目的，是为了显性地说明这个sort用的是merge sort
    private ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        //找list中点
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null){
        	walker = walker.next;
        	runner = runner.next.next;
        }
        //将list一分为二
        ListNode head2 = walker.next;
        walker.next = null; 
        //对两半儿list递归sort
        ListNode head1 = head;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return mergeTwoLists(head1, head2);
    }
    
    //https://oj.leetcode.com/problems/merge-two-sorted-lists/
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
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
