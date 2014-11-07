package Merge_k_Sorted_Lists;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/19899259
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if (lists == null ||lists.size() == 0){
    		return null;
    	}
        return helper(lists, 0, lists.size()-1);
    }
    
    private ListNode helper(ArrayList<ListNode> lists, int left, int right){
    	if (left < right){
    		//关于边界，向上向下取整问题。需要解答。
    		/*int mid = (left+right+1)/2;//向上取整
    		return mergeTwoLists(helper(lists, left, mid-1) , helper(lists, mid, right));*/
    		int mid = (left+right)/2;//向下取整
    		return mergeTwoLists(helper(lists, left, mid) , helper(lists, mid+1, right));
    	}
    	return lists.get(left);// or return lists.get(right);
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