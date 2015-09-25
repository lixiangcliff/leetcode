package Sum_Root_to_Leaf_Numbers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
	 * Given a binary tree containing digits from 0-9 only, 
	 * each root-to-leaf path could represent a number.
	 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
	 * Find the total sum of all root-to-leaf numbers.
		
		For example,
		
		    1
		   / \
		  2   3
		The root-to-leaf path 1->2 represents the number 12.
		The root-to-leaf path 1->3 represents the number 13.
		
		Return the sum = 12 + 13 = 25.
	 * 
	 */
	
	//用backtrack手写：
	public int sumNumbers(TreeNode root) {
	    int[] res = {0}; // 必须为数组，这样在helper里加工之后，才能返回处理之后的值。
	    int item = 0;
		helper(res, item, root);
		return res[0];
	}

	private void helper(int[] res, int item, TreeNode root) { 
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			res[0] = res[0] + item * 10 + root.val;
		}
		item = item * 10 + root.val;
		helper(res, item, root.left);
		helper(res, item, root.right);
		item = (item - root.val) / 10;
	}
	
	
	//递归条件即是把当前的sum乘以10并且加上当前节点传入下一层递归函数
	//http://blog.csdn.net/linhuanmars/article/details/22913699
	public int sumNumbers2(TreeNode root) {
		return helper(root, 0);
	}

	// 递归的返回值就是以当前root为根的所有root-to-leaf的和
	private int helper(TreeNode root, int sum) { // sum表示：以起始根为根，以当前root的parent为leaf的这一条路径上已累积的总和
		if (root == null) {// 空节点，已经不是叶子了，不需要把数值加入结果，直接返回0
			return 0;
		}
		if (root.left == null && root.right == null) {// 已到达叶子节点，完成了一个整个path,将这一个path的结果加入总和中
			return sum * 10 + root.val;
		} else { // 不为空也不为叶子时，本层的sum * 10 加上root.val, 然后分别传给左右子树递归，把左右子树的到leaf路径和加起来就是当前root到leaf的路径和
			return (helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val));
		}
	}
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }