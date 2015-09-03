package Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://leetcode.com/problems/binary-tree-paths/
	 * Given a binary tree, return all root-to-leaf paths.
		For example, given the following binary tree:
		
		   1
		 /   \
		2     3
		 \
		  5
		All root-to-leaf paths are:
		
		["1->2->5", "1->3"]
	 */
	
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<String>();
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	helper(res, item, root);
    	return res;
    }
    
    private void helper(List<String> res, ArrayList<Integer> item, TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	if (root.left == null && root.right == null) {
    		item.add(root.val);
    		StringBuilder sb = new StringBuilder();
    		sb.append(item.get(0));
    		for (int i = 1; i < item.size(); i++) {
    			sb.append("->").append(item.get(i));
    		}
    		res.add(sb.toString());
    		item.remove(item.size() - 1);
    	}
    	item.add(root.val);
    	helper(res, item, root.left);
    	helper(res, item, root.right);
    	item.remove(item.size() - 1);
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
