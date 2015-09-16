package Closest_Binary_Search_Tree_Value;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

		Note:
		
		Given target value is a floating point.
		You are guaranteed to have only one unique value in the BST that is closest to the target.
	 */
	
	//http://www.cnblogs.com/jcliBlogger/p/4763200.html
	//https://leetcode.com/discuss/54436/java-iterative-solution
	public int closestValue(TreeNode root, double target) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int val = root.val;
		double min = Math.abs(val - target);
		while (root != null) {
			if (Math.abs(root.val - target) < min) {
				min = Math.abs(root.val - target);
				val = root.val;
			}
			if (target < root.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return val;
	}

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
