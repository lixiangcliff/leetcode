package Palindrome_Linked_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/palindrome-linked-list/
	 * Given a singly linked list, determine if it is a palindrome.
	 * Follow up:
	 * Could you do it in O(n) time and O(1) space?
	 */
	
	
	// 一分两半，翻转后半，然后对比，再把后半翻转回来，两半接上
    public boolean isPalindrome(ListNode head) {
        return false;
    }

}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}