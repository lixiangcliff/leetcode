package Deepest_Node_In_A_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * http://www.glassdoor.com/Interview/Find-the-deepest-node-in-a-binary-tree-Build-a-tree-out-of-given-edges-etc-QTN_887354.htm
	 * Find the deepest node in a binary tree
	 */
	
	//iterative 
	public List<TreeNode> findDeepestNode(TreeNode root) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (root == null) {
			return res;
		}
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<TreeNode> item = new ArrayList<TreeNode>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				item.add(node);
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			if (q.isEmpty()) {
				res.addAll(item);
			}
		}
		return res;
	}
	
	//recursive
	//discuss with Zhe
	

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
