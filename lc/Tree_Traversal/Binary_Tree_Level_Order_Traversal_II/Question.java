package Binary_Tree_Level_Order_Traversal_II;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

		For example:
		Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its bottom-up level order traversal as:
		[
		  [15,7],
		  [9,20],
		  [3]
		]
		
	 */
	
	//using BFS template
	//http://blog.csdn.net/linhuanmars/article/details/23414711
	//跟右边的题没什么区别：https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
	//要么用Collections.reverse； 要么把item暂时先装进stack，最后再倒出来给result
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null){
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<ArrayList<Integer>> stack = new LinkedList<ArrayList<Integer>>();
		queue.offer(root);
		while(!queue.isEmpty()){
			ArrayList<Integer> item = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				item.add(node.val);
				if (node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
			}
			//result.add(item);
			stack.push(item);
		}
		//Collections.reverse(result);
		while (!stack.isEmpty()) {
			result.add(stack.pop());
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