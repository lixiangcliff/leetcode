package Path_Sum_II;

import java.util.ArrayList;



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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (root == null){
    		return null;
    	}
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	helper(root, sum, item, result);
    	return result;
    }
    
    //backtracking
    private void helper(TreeNode root, int sum, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
    	if (root == null) {
    		return;
    	}
    	sum -= root.val; //sum减去当前root.val之后的新sum值
    	if (root.left == null && root.right == null) { //root为叶子node
    		if (sum == 0) { //刚好该叶子节点的值等于上次剩余的sum值
    			item.add(root.val); //当前叶子node加入item，使其成为solution之一
    			result.add(new ArrayList<Integer>(item));
    			item.remove(item.size() - 1); //backtrack
    		}
    	}
    	//如果root不为叶子，则把当前root.val加入item，然后对左右子树 分别递归。
    	item.add(root.val);
    	helper(root.left, sum, item, result);
    	helper(root.right, sum, item, result);
    	item.remove(item.size() - 1); //backtrack
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}