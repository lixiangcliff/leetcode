package Lowest_Common_Ancestor;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
	//返回值即为最小公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // root已经 为null或者碰到了A，B其中某一个点
    	if (root == null || root == A || root == B) {
    		return root;
    	}
    	//divide
    	TreeNode left = lowestCommonAncestor(root.left, A, B);
    	TreeNode right = lowestCommonAncestor(root.right, A, B);
    	//conquer
    	if (left != null && right != null) { //即，左右子树中分别有A和B中的一个，也就是找到了最小公共祖先
    		return root;
    	}
    	if (left != null) { //即AB都在左子树
    		return left;
    	}
    	if (right != null) { //即AB都在右子树
    		return right;
    	} 
    	return null; //两个子树都没有 则返回null
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
