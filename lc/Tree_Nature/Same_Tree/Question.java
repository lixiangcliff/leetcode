package Same_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * https://oj.leetcode.com/problems/same-tree/
	 * Given two binary trees, write a function to check if they are equal or
	 * not. Two binary trees are considered equal if they are structurally
	 * identical and the nodes have the same value.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/22839819
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) { // 两个都到头了，返回true
			return true;
		}
		if (p == null || q == null) { // 一个到头了，但是另一个没到头，所以不同，返回false
			return false;
		}
		if (p.val != q.val) { // 两个都不为空，但是值不相同，返回false
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // 递归。左右子树对应same，最终才能same
	}
}
	
class TreeNode {
	      int val;
	     TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
