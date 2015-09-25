package Binary_Search_Tree_Iterator;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/binary-search-tree-iterator/
	 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
		Calling next() will return the next smallest number in the BST.
		Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
	 */
	
	

}

//同Implement_Iterator_of_Binary_Search_Tree
class BSTIterator {
	private LinkedList<TreeNode> stack; 
	private TreeNode cur;
	
    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
        	cur = cur.left;
        }
        TreeNode node = stack.pop();
        cur = node.right;
        return node.val;
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