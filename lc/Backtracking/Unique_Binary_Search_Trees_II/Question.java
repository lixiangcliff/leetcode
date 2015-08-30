package Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		List<TreeNode> result = q.generateTrees(3);
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

	//【注】此题只是DFS，没有backtracking！
	//看图
	//1. 先定义递归的参数的左边界和右边界，即1到n.
	//2. 考虑从left, 到right 这n个数字中选取一个作为根，余下的使用递归来构造左右子树。 
	//3. 当无解时，应该返回一个null树，这样构造树的时候，我们会比较方便，不会出现左边解为空，或是右边解为空的情况。
	//4. 如果说左子树有n种组合，右子树有m种组合，那最终的组合数就是n*m. 把这所有的组合组装起来即可
	//http://www.cnblogs.com/yuzhangcmu/p/4256291.html
	//http://blog.csdn.net/linhuanmars/article/details/24761437
	//http://answer.ninechapter.com/solutions/unique-binary-search-trees-ii/
	public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	//DFS helper【注】函数返回值为：根的数值范围是从leftMost到rightMost的所有满足条件的一颗树【注】必须要有返回值，否则无法得到leftChildren和rightChildren
	private List<TreeNode> helper(int leftMost, int rightMost) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (leftMost > rightMost) { // 如果最左比最右大，则只能是一种情况，即空树。
			result.add(null); //【注】加入一个空元素进去，来表示这是一颗空树，并且同时也是保证下面循环时，即使一边是空树，也让另一边继续运算。
			return result;
		}
		// 好好体会下面"在循环中调用递归函数求解子问题"
		for (int i = leftMost; i <= rightMost; i++) {
			List<TreeNode> leftChildren = helper(leftMost, i - 1);
			List<TreeNode> rightChildren = helper(i + 1, rightMost);
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
