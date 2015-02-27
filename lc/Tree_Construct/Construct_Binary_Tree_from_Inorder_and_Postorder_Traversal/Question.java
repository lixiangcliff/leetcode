package Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.HashMap;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	 * Given inorder and postorder traversal of a tree, construct the binary
	 * tree.
	 * Note: You may assume that duplicates do not exist in the tree.
	 */
	
	//http://blog.csdn.net/linhuanmars/article/details/24390157
	//此题和Construct Binary Tree from Preorder and Inorder Traversal，非常类似。唯一区别是后序排列根在最后。
	//具体注释参考那一题即可
	//还有一个注意点：
	//"有朋友可能会想根据先序遍历和后序遍历能不能重新构造出树来，答案是否定的。只有中序便利可以根据根的位置切开左右子树，其他两种遍历都不能做到，
	//其实先序遍历和后序遍历是不能唯一确定一棵树的，会有歧义发生，也就是两棵不同的树可以有相同的先序遍历和后序遍历，"
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(postorder, 0, postorder.length - 1, inorder, 0,
				inorder.length - 1, map);
	}
    
    private TreeNode helper(int[] postorder, int postL, int postR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map) {
		if (postL > postR || inL > inR) { // base case
			return null;
		}
		int index = map.get(postorder[postR]);
		TreeNode root = new TreeNode(postorder[postR]);
		root.left = helper(postorder, postL, postL - 1 + index - inL, inorder, inL, index - 1, map);
		root.right = helper(postorder, postR - inR + index, postR - 1, inorder, index + 1, inR, map);
		return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }
}
