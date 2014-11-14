package Path_Sum;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// http://blog.csdn.net/linhuanmars/article/details/23654413
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		// 说明此时root是叶子节点，并且剩余sum与其val相等，所以true
		if (root.left == null && root.right == null && root.val == sum) {
			return true;
		}
		//左右子树有任何一个符合的就行，所以用||连接
		//继续的值为sum - root.val（不是sum - root.left.val！），因为要把当前的val（root.val）减去，然后继续递归。
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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