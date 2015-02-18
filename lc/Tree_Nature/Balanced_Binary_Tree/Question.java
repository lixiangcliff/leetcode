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
	
	// http://www.ninechapter.com/solutions/balanced-binary-tree/
	// http://blog.csdn.net/linhuanmars/article/details/23731355
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root) != -1; // 判断树高是否大于等于0
	}

	// 【注】返回值表示树的高度，特殊地当返回值（树高）为-1时，表示数失去平衡。
	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftH = helper(root.left);// 左子树高度
		int rightH = helper(root.right);// 右子树高度
		if (leftH < 0 || rightH < 0 || Math.abs(leftH - rightH) > 1) {// 任何一个子树<0（失衡）,或左右子树高度相差>1，则以当前root为根的树必失去平和，则返回-1
			return -1;
		}
		return (Math.max(leftH, rightH) + 1); // 返回树的高度（左右子树高的那个+一个根节点）
	}
}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
