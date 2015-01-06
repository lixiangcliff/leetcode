package Insert_Node_in_a_Binary_Search_Tree;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
    	if (root == null) {
    		return node;
    	}
    	TreeNode cur = root;
    	while (cur != null) {
    		if (cur.val < node.val) {
    			if (cur.right == null) {
    				cur.right = node;
    				return cur;
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
