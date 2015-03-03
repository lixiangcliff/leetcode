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
	//看图！
	// http://www.ninechapter.com/solutions/populating-next-right-pointers-in-each-node/
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode parent = root;
		TreeLinkNode nextLevelLeftMost = parent.left;
		// 处理整个树
		while (nextLevelLeftMost != null) {
			TreeLinkNode pre = null; //用这个pre将parent这一行node的所有孩子们连接起来
			// 处理parent这个node所在的那一行
			while (parent != null) { //（除了第一次循环只处理一个孩子外，其余每次处理两个孩子（即pre右移两次）。具体的，画图！）
				if (pre == null) { //单独处理pre是最左边的node时的情况
					pre = parent.left; 
				} else { //上一个parent的右孩子连上当前parent的左孩子
					pre.next = parent.left;
					pre = pre.next;
				}
				pre.next = parent.right; //当前parent的左孩子连上其右孩子
				pre = pre.next; // pre移向其右边
				parent = parent.next; //parent移向其右边
			}
			parent = nextLevelLeftMost;
			nextLevelLeftMost = parent.left;
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
 