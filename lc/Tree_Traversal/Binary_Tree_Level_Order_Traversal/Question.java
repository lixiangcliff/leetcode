package Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
		
		For example:
		Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]
		
	 */
	
	//BFS template
	//http://www.cnblogs.com/yuzhangcmu/p/4178902.html
	//http://blog.csdn.net/linhuanmars/article/details/23404111
	//类似此题的iterative way：https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); //【注】java中Queue是interface，Stack是class
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> item = new ArrayList<Integer>(); // 当前的一层
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				item.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(item);
		}
		return result;
	}
	
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
