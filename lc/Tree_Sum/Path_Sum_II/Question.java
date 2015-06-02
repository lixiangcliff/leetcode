package Path_Sum_II;

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
	 * https://oj.leetcode.com/problems/path-sum-ii/
	 * Given a binary tree and a sum, find all root-to-leaf paths 
	 * where each path's sum equals the given sum.

		For example:
		Given the below binary tree and sum = 22,
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \    / \
		        7    2  5   1
		return
		[
		   [5,4,11,2],
		   [5,8,4,5]
		]
		
	 */
	
	//http://www.ninechapter.com/solutions/path-sum-ii/
	//http://blog.csdn.net/linhuanmars/article/details/23655413
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root == null) {
    		return result;
    	}
    	List<Integer> item = new ArrayList<Integer>();
    	helper(root, sum, item, result);
    	return result;
    }
    
    //backtracking
    private void helper(TreeNode root, int sum, List<Integer> item, List<List<Integer>> result) {
    	if (root == null) {
    		return;
    	}
    	if (root.left == null && root.right == null && sum == root.val) { //root为叶子node
			item.add(root.val); // 当前叶子node加入item，使其成为solution之一
			result.add(new ArrayList<Integer>(item));
			item.remove(item.size() - 1); //backtrack
    	}
    	//如果root不为叶子，则把当前root.val加入item，然后对左右子树 分别递归，最后再backtrack。
    	item.add(root.val);
    	helper(root.left, sum - root.val, item, result);
    	helper(root.right, sum - root.val, item, result);
    	item.remove(item.size() - 1); //backtrack
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}