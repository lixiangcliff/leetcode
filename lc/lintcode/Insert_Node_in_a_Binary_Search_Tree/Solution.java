package Insert_Node_in_a_Binary_Search_Tree;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * http://lintcode.com/en/problem/insert-node-in-a-binary-search-tree/
	 * Given a binary search tree  and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
		Example 
		Given binary search tree as follow:
		     2
		    /  \
		   1     4
		        /   
		       3 
		after Insert node 6, the tree should be:
		     2
		    /  \
		   1    4
		        / \ 
		       3   6
		Challenge 
		Do it without recursion

	 */
	
	// @return: The root of the new binary search tree.
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
    	if (root == null) {
    		return node;
    	}
    	if (node == null) {
    		return root;
    	}
    	TreeNode cur = root;
    	while (cur != null) {
    		if (cur.val < node.val) {
    			if (cur.right == null) { // 如果已经走到子树的最右
    				cur.right = node;
    				return root;
    			} 
    			cur = cur.right;
    		} else if (cur.val > node.val) {
    			if (cur.left == null) {
    				cur.left = node;
    				return root;
    			}
    			cur = cur.left;
    		}
    	}
    	return root;
    }

}

 class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }
