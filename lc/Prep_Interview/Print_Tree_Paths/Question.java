package Print_Tree_Paths;

import java.util.ArrayList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		TreeNode l0 = new TreeNode(0);
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(6);
		TreeNode l7 = new TreeNode(7);
		l4.left = l2;
		l4.right = l6;
		l2.left = l1;
		l2.right = l3;
		l6.left = l5;
		l6.right = l7;
		int[] path = new int[20];
		int pathLen = 0;
		//q.printPaths(l4, 50);
		q.printPaths(l4);
		
		
		//q.sortedListToBST(head);
	}
	/*
	 * 		Example
			         4
			       /    \
			      2      6
			     / \    / \
			    1   3  5   7
	 */
	
	/**
	 * http://www.1point3acres.com/bbs/thread-139354-1-1.html
	 * 给一个binary tree 打印所有的path
	 */

	//backtracking
	public void printPaths(TreeNode root) {
		if (root == null) {
			return;
		}
		ArrayList<Integer> item = new ArrayList<Integer>();
		helper(root, item);
	}
	
	private void helper(TreeNode root, ArrayList<Integer> item) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			item.add(root.val);
			for (Integer i : item) {
				System.out.print(i + ",");
			}
			System.out.println("");
			item.remove(item.size() - 1);
		}
		item.add(root.val);
		helper(root.left, item);
		helper(root.right, item);
		item.remove(item.size() - 1);
	}
	
	
	//http://www.doumiaoer.com/print-all-path-binary-tree/
	//http://blog.csdn.net/randyjiawenjie/article/details/6772145
	/*
	//Given a binary tree, prints out all of its root-to-leaf
	//paths, one per line. Uses a recursive helper to do the work.
	public void printPaths(TreeNode root, int n) {
	    int[] path = new int[n];
	    helper(root, path, 0);
	}
	
	//Recursive printPaths helper -- given a node, and an array containing
	//the path from the root node up to but not including this node,
	//prints out all the root-leaf paths.
	private void helper(TreeNode node, int[] path, int pathLen) {
	    if (node == null) return;
	    // append this node to the path array
		    path[pathLen++] = node.value;
	    // it"s a leaf, so print the path that led to here
	    if (node.left == null && node.right == null) {
	    	printArray(path, pathLen);
	    }
	    else {
		    // otherwise try both subtrees
	    	helper(node.left, path, pathLen);
	    	helper(node.right, path, pathLen);
	    }
	}
	
	//Utility that prints ints from an array on one line.
	private void printArray(int[] ints, int len) {
	    for (int i = 0; i < len; i++) {
	    	System.out.print(ints[i] + " ");
	    }
	    System.out.println();
	}*/
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
