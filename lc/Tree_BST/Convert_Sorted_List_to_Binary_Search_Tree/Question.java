package Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		//ListNode l7 = new ListNode(7);
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		//l6.next = l7;
		System.out.println(q.sortedListToBST(l0).val);
		
		
		
		//q.sortedListToBST(head);
	}
	/*
	 * 		Example
			         4
			       /    \
			      2      6
			     / \    / \
			    1   3  5   7
	 */
	/**
	 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
	 * Given a singly linked list where elements are sorted in ascending order,
	 * convert it to a height balanced BST.
	 */
	
	//Divide and Conquer
	public TreeNode sortedListToBST(ListNode head) {
		int len = getLen(head);
		ListNode[] curHead = new ListNode[1];
		curHead[0] = head;
		return helper(curHead, len);
	}
	
	private TreeNode helper(ListNode[] curHead, int len) { //返回以curHead[0]的node作为起始位置，直到长度为len的一组node，所组成的BST的root
		if (len <= 0) {
			return null;
		}
		TreeNode left = helper(curHead, len / 2);//【左】
		TreeNode root = new TreeNode(curHead[0].val);//【根】【注】计算完左子树之后，curHead[0]值已经变为在len /2 + 1位置上的node了
		curHead[0] = curHead[0].next;
		TreeNode right = helper(curHead, len - len / 2 - 1);//【右】
		root.left = left;
		root.right = right;
		return root;
	}
	
	private int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
	
	//try myself...not working correctly
/*	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int count = 0;
		ListNode runner = head;
		while (runner != null) {
			runner = runner.next;
			count++;
		}
		return helper(head, 0, count - 1);
	}
	
	private TreeNode helper(ListNode head, int l, int r) {
		if (l > r) {
			return null;
		}
		int m = (l + r) / 2;
		ListNode cur = head;
		int count = 0;
		while (count < m && cur != null) {
			cur = cur.next;
			count++;
		}
		if (cur == null) {
			return null;
		}
		TreeNode root = new TreeNode(cur.val);
		TreeNode left = helper(head, l, m - 1);
		cur = cur.next;
		TreeNode right = helper(cur, m + 1, r);
		root.left = left;
		root.right = right;
		return root;
	}*/
	//bottom to top:
	// 	1. construct the left tree 
	//	2. construct the root node, list pointer +1.
	//	3. construct the right node
	//http://blog.csdn.net/linhuanmars/article/details/23904937
	//http://joycelearning.blogspot.com/2013/09/leetcode-convert-sorted-list-to-binary.html
	//http://yucoding.blogspot.com/2012/12/leetcode-question-24-convert-sorted.html
/*	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int count = 0;
		ListNode runner = head;
		while (runner != null) {
			runner = runner.next;
			count++;
		}
		ListNode[] headNode = new ListNode[1];
		headNode[0] = head;
		return helper(headNode, 0, count - 1);
	}*/

	// headNode里只存一个元素，即待转化为tree的ListNode的头 
	//返回值即为: 以当前headNode[0]的值作为新建tree中【注】最小值【注】，左边界为l，右边界为r，所构建的树的根
	/*private TreeNode helper(ListNode[] headNode, int l, int r) {
		if (l > r) {
			return null;
		}
		int m = (l + r) / 2;
		TreeNode left = helper(headNode, l, m - 1); //【左】找到左半边的根left
		TreeNode root = new TreeNode(headNode[0].val); // 【注】递归做完左子树之后，headNode[0].val最后变为原链表中第"m"个值。【根】用当前headNode[0]的值创造一个TreeNode作为根
		headNode[0] = headNode[0].next; // 把headNode[0]的值置为，当前根值在原链表上 下一个位置（得到右子树的最小值）
		TreeNode right = helper(headNode, m + 1, r); // 【右】找到右半边的根right
		root.left = left; // 当前根连上左子树的根
		root.right = right; // 当前根连上右子树的根
		return root;
	}*/
	

	

}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}