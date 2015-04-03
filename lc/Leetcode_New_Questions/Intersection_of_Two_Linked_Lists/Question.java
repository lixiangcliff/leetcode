package Intersection_of_Two_Linked_Lists;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ListNode n1 = new ListNode(1);
		//ListNode n2 = new ListNode(2);
		ListNode n2 = n1;
		ListNode res = q.getIntersectionNode(n1, n2);
		System.out.print(res.val);
	}
	/**
	 * https://leetcode.com/problems/intersection-of-two-linked-lists/
	 * Write a program to find the node at which the intersection of two singly linked lists begins.
		For example, the following two linked lists:
		
		A:          a1 → a2
		                   	↘
		                     c1 → c2 → c3
		                   	↗            
		B:     b1 → b2 → b3
		
		begin to intersect at node c1.
		Notes:
			1.If the two linked lists have no intersection at all, return null.
			2.The linked lists must retain their original structure after the function returns.
			3.You may assume there are no cycles anywhere in the entire linked structure.
			4.Your code should preferably run in O(n) time and use only O(1) memory.
	 */
	
	//1.HashSet: O(n) time, O(n) space
	//2.i,j iterative: O(n^2) time, O(1) space
	//3.let cur in A and B reach the intersection simultaneously 
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int len1 = 0;
		int len2 = 0;
		ListNode cur = headA;
		while (cur != null) {
			cur = cur.next;
			len1++;
		}
		cur = headB;
		while (cur != null) {
			cur = cur.next;
			len2++;
		}
		int minLen = Math.min(len1, len2);
		int maxLen = Math.max(len1, len2);
		ListNode headMax = null;
		ListNode headMin = null;
		if (minLen == len1) {
			headMin = headA;
			headMax = headB;
		} else {
			headMin = headB;
			headMax = headA;
		}
		ListNode curMax = headMax;
		ListNode curMin = headMin;
		for (int i = 0; i < maxLen - minLen; i++) {
			curMax = curMax.next;
		}
		while (curMax != curMin && curMin != null && curMax != null) {
			curMin = curMin.next;
			curMax = curMax.next;
		}
		return curMax == null ? null : curMax;
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
