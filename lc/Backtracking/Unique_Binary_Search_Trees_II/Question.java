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
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i).val + ",");
		}
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
	// “思路是每次一次选取一个点为作为根节点；然后递归求解左右子树的所有结果；最后根据所有返回的左右子树依次选取，然后接在所选的根节点上。
	//（每个左边的子树跟所有右边的子树匹配，而每个右边的子树也要跟所有的左边子树匹配，总共有左右子树数量的乘积种情况），构造好之后作为当前树的结果返回。”
	//http://blog.csdn.net/linhuanmars/article/details/24761437
	//http://answer.ninechapter.com/solutions/unique-binary-search-trees-ii/
	public ArrayList<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	//DFS helper函数得到的是范围从leftMost到rightMost的所有满足条件的树
	private ArrayList<TreeNode> helper(int leftMost, int rightMost) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (leftMost > rightMost) { // 如果最左比最右大，则无法找到合法的树
			result.add(null); //【注】加入一个空元素进去来表示这是一颗空树，并且同时也是保证下面循环时即使一边是空树，也会跑另一边。
			return result;
		}
		// 好好体会下面"在循环中调用递归函数求解子问题"
		for (int i = leftMost; i <= rightMost; i++) {
			ArrayList<TreeNode> leftChildren = helper(leftMost, i - 1);
			ArrayList<TreeNode> rightChildren = helper(i + 1, rightMost);
			for (TreeNode l : leftChildren) { // 以i为root的，各个左子树和各个右子树两两相配
				for (TreeNode r : rightChildren) {
					TreeNode root = new TreeNode(i); // 此处必须要new一个root的出来，因为每个tree都需要一个自己的root
					root.left = l; // 根分别接上遍历出来的两两相配的左右子树
					root.right = r;
					result.add(root); // 做好一个tree 加入结果集
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
	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}
