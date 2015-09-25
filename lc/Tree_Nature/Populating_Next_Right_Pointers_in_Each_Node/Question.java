package Populating_Next_Right_Pointers_in_Each_Node;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
	 * Given a binary tree
		    struct TreeLinkNode {
		      TreeLinkNode *left;
		      TreeLinkNode *right;
		      TreeLinkNode *next;
		    }
		Populate each next pointer to point to its next right node. 
		If there is no next right node, the next pointer should be set to NULL.
		
		Initially, all next pointers are set to NULL.
		
		Note:
		You may only use constant extra space.
		You may assume that it is a perfect binary tree 
		(ie, all leaves are at the same level, and every parent has two children).
		
		For example,
		Given the following perfect binary tree,
		         1
		       /  \
		      2    3
		     / \  / \
		    4  5  6  7
		    
		After calling your function, the tree should look like:
		
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \  / \
		    4->5->6->7 -> NULL
	 */
	
	//2层循环。外层循环遍历每一层；内层循环遍历当前层每一个node
	//针对当前层，使用两个指针：一个指针leftMost记录每一层的最左边节点，另一个指针cur遍历本层的同时，把下一层的node链接上。
	//下层node链接完成后，将leftMost移动到它的左孩子即可。
	// http://www.cnblogs.com/yuzhangcmu/p/4041341.html
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode leftMost = root.left;
		TreeLinkNode cur = root;
		while (leftMost != null) { // 要连接的是下一层，所以如果下一层最左边已经为null，则可直接跳出循环了。
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			cur = leftMost;
			leftMost = leftMost.left;
		}
	}



}


  class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { 
    	  val = x; 
      }
  }
 