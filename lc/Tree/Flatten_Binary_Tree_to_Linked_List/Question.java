package Flatten_Binary_Tree_to_Linked_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
	 * Given a binary tree, flatten it to a linked list in-place.
		For example,
		Given
		
		         1
		        / \
		       2   5
		      / \   \
		     3   4   6
		     
		The flattened tree should look like:
		
		   1
		    \
		     2
		      \
		       3
		        \
		         4
		          \
		           5
		            \
		             6
		
		Hints:
		If you notice carefully in the flattened tree, 
		each node's right child points to the next node of a pre-order traversal.
	 */
	//http://www.cnblogs.com/feiling/p/3278639.html
	/*
	 * 看图！
	 * 思想：整个树分成三份，根，左子树，右子树；
	 * 递归体     1.根left指向null,
	 * 		2.根right指向原来左子树
	 * 		3.找到原左子树的最右孩子p
	 * 		4.p指向原来右子树
	 */
    public void flatten(TreeNode root) {
        if(root == null){
        	return;
        }
        if(root.left != null){
        	TreeNode leftNode = root.left;
        	TreeNode rightNode = root.right;
        	root.left = null; // 【注】勿忘！
        	root.right = leftNode;
        	TreeNode p = leftNode;
        	while(p.right != null){
        		p = p.right;
        	}
        	p.right = rightNode;
        }
        flatten(root.right);
    }

}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
