package Count_Complete_Tree_Nodes;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/count-complete-tree-nodes/
	 * Given a complete binary tree, count the number of nodes.
	 * Definition of a complete binary tree from Wikipedia: https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees
	 * In a complete binary tree every level, except possibly the last, is completely filled, 
	 * and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
	 */
	//http://www.programcreek.com/2014/06/leetcode-count-complete-tree-nodes-java/
	
	//LTE
    public int countNodes(TreeNode root) {
    	int res = 0;
    	if (root == null) {
    		return res;
    	}
    	//level traversal: LTE for leetcode (Special Judge: very large tree)
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		for (int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			if (node.left != null) {
    				queue.offer(node.left);
    			}
    			if (node.right != null) {
    				queue.offer(node.right);
    			}
    			res++;
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
