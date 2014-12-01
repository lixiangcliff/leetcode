package Balanced_Binary_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * https://oj.leetcode.com/problems/balanced-binary-tree/
	 * Given a binary tree, determine if it is height-balanced.
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 */
	//http://blog.csdn.net/linhuanmars/article/details/23731355
	//这里helper的返回值有两层含义：当>=0时，表示为树高；当<0时，表示失去平衡
    public boolean isBalanced(TreeNode root) {
    	if(root==null){
    		return true;
    	}
    	return helper(root)>=0; //判断树高是否大于0
    }
    
    //【注】返回值表示树的高度，特殊地当返回值（树高）为-1时，表示数失去平衡。
    private int helper(TreeNode root){
		if (root==null){
			return 0;
		}
		int leftH = helper(root.left);//左子树高度
		int rightH = helper(root.right);//右子树高度
		if (leftH < 0 || rightH < 0){//任何一个子树<0，则返回-1（即任何一个子树失去平衡，则以当前node为根的树必定失去平衡）
			return -1;
		}
		if(Math.abs(leftH-rightH) > 1){//表示左右子树高度相差>1，则返回-1，表示则失去平衡
			return -1;
		}
		//返回树的高度（左右子树高的那个+1）
		return (Math.max(leftH, rightH) + 1);
	}
	

}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
