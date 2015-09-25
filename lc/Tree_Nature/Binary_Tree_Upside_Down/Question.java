package Binary_Tree_Upside_Down;

import java.util.ArrayList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
	 * (a left node that shares the same parent node) or empty, 
	 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
	 * Return the new root.
		For example:
		Given a binary tree {1,2,3,4,5},
		    1
		   / \
		  2   3
		 / \
		4   5
		return the root of the binary tree [4,5,2,#,#,3,1].
		   4
		  / \
		 5   2
		    / \
		   3   1  
	 */
	
	//http://www.cnblogs.com/EdwardLiu/p/4232896.html 解释得很好
	
	/*
	 * 这题第一眼看上去觉得没头绪，不知道怎么上下翻转和左右翻转。但在纸上画几个例子就清楚了。所有的右子树要么为空、要么就是叶子节点且有左子树存在。
	 * 那么原来的数一直沿左子树走下去最左的那个节点就是新树的根节点。
	 * 这道题最关键在于想到要用递归去做！这种树的结构、父子两层节点关系的问题多半都要用递归去做。这是大方向。
	 * 一旦确定递归，问题就迎刃而解了，就是一直往左走到叶子节点，返回该点作为新的根节点newRoot，定义newRoot.left, newRoot.right, 再返回newRoot.right作为上一层的newRoot。
	 * 注意递归函数最终返回的节点并非我们所求，如上图返回1节点，而我们需要新树的root节点：节点4. 
	 * 所以在递归里加一个argument，ArrayList<TreeNode>, 来包裹新root节点当找到它时。这是java函数参数传递问题，如果直接用TreeNode作为argument, 传的是引用，函数里引用所指的地址发生改变，不会让函数外的引用所指的地址改变
	 */
	// another one: https://leetcode.com/discuss/18410/easy-o-n-iteration-solution-java
	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		res.add(null);
		helper(root, res);
		return res.get(0);
	}
	
	//返回当前层的上一层root
	public TreeNode helper(TreeNode root, ArrayList<TreeNode> res) {
		if (root.left == null) {
			res.set(0, root);
			return root;
		}
		TreeNode newRoot = helper(root.left, res);
		newRoot.left = root.right;
		newRoot.right = root;
		return newRoot.right;
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
