package Binary_Tree_Upside_Down;

import java.util.ArrayList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
		For example:
		Given a binary tree {1,2,3,4,5},
		    1
		   / \
		  2   3
		 / \
		4   5
		return the root of the binary tree [4,5,2,#,#,3,1].
		   4
		  / \
		 5   2
		    / \
		   3   1  
	 */
	
	//http://www.cnblogs.com/EdwardLiu/p/4232896.html 解释得很好
	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		res.add(null);
		helper(root, res);
		return res.get(0);
	}
	
	//返回当前层的上一层root
	public TreeNode helper(TreeNode root, ArrayList<TreeNode> res) {
		if (root.left == null) {
			res.set(0, root);
			return root;
		}
		TreeNode newRoot = helper(root.left, res);
		newRoot.left = root.right;
		newRoot.right = root;
		return newRoot.right;
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
