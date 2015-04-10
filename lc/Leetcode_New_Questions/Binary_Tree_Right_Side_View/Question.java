package Binary_Tree_Right_Side_View;

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

	/**
	 * https://leetcode.com/problems/binary-tree-right-side-view/
	 * Given a binary tree, imagine yourself standing on the right side of it, 
	 * return the values of the nodes you can see ordered from top to bottom.
	 * 
		For example:
		Given the following binary tree,
		   1            <---
		 /   \
		2     3         <---
		 \     \
		  5     4       <---
		You should return [1, 3, 4].
	 */
	
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (root == null) {
    		return res;
    	}
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			if (i == size - 1) {
    				res.add(node.val);
    			}
    			if (node.left != null) {
    				queue.offer(node.left);
    			}
    			if (node.right != null) {
    				queue.offer(node.right);
    			}
    		}
    	}
    	return res;
    }
	
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
