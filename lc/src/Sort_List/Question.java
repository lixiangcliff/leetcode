package Sort_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode walker = head;
        ListNode runner = head;
        
        while(runner.next != null && runner.next.next != null){
        	walker = walker.next;
        	runner = runner.next.next;
        }
        ListNode head2 = walker.next;
        walker.next = null; //split "left part" from the whole list
        /*ListNode left = sortList(head);
        ListNode right = sortList(head2);
        return mergeTwoLists(left, right);*/
        //simpler code:
        ListNode head1 = head;
        head1 = sortList(head1);
        head2 = sortList(head2);
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
