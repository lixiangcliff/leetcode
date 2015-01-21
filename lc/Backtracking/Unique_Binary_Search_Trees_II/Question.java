package Unique_Binary_Search_Trees_II;

import java.util.ArrayList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ArrayList<TreeNode> result = q.generateTrees(3);
		/*for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + ",");
		}*/
	}
	/**
	 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
		For example,
		Given n = 3, your program should return all 5 unique BST's shown below.
		
		   1         3     3      2      1
		    \       /     /      / \      \
		     3     2     1      1   3      2
		    /     /       \                 \
		   2     1         2                 3
	 */
	//http://blog.csdn.net/linhuanmars/article/details/24761437
	//http://answer.ninechapter.com/solutions/unique-binary-search-trees-ii/
	public ArrayList<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	//helper函数得到的是范围从leftMost到rightMost的所有满足条件的树
	private ArrayList<TreeNode> helper(int leftMost, int rightMost) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (leftMost > rightMost) { // 如果最左比最右大，则无法找到合法的树
			result.add(null);
			return result;
		}
		// "在循环中调用递归函数求解子问题"
		for (int i = leftMost; i <= rightMost; i++) {
			ArrayList<TreeNode> leftChildren = helper(leftMost, i - 1);
			ArrayList<TreeNode> rightChildren = helper(i + 1, rightMost);
			for (TreeNode l : leftChildren) { // 以i为root的，各个左子树和各个右子树两两相配
				for (TreeNode r : rightChildren) {
					TreeNode root = new TreeNode(i); // 此处必须要new一个root的出来，因为每个tree都需要一个自己的root
					root.left = l;
					root.right = r;
					result.add(root);
				}
			}
		}
		return result;
	}
}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
 }
