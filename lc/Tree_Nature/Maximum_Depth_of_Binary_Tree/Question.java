package Maximum_Depth_of_Binary_Tree;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	/**
	 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 */
	//http://blog.csdn.net/linhuanmars/article/details/19659525
	//recursive way
	public int maxDepth(TreeNode root) {
		if (root == null){
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
	
	//using BFS template
	//traverse by level(using bsf)
	public int maxDepthBSF(TreeNode root) {
		if (root == null){
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int level = 0; //根据题意，只有一个root的的Tree高度为0
		queue.offer(root);
		//BSF的原理，看图！
		while(!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
			}
			level++;
		}
		return level;
	}
	

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }