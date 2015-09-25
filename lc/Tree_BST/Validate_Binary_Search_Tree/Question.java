package Validate_Binary_Search_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/validate-binary-search-tree/
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. 
	 * The right subtree of a node contains only nodes with keys
	 * greater than the node's key. 
	 * Both the left and right subtrees must also
	 * be binary search trees. 
	 */
	
	//下面的思想是：用前序遍历，
	//1.先处理根，检查根的值必须在在给定的上界与下界之间，且如果根本身值是MIN_VALUE或MAX_VALUE，则对应的左或右孩子必须为null，否则false（于是客观上根的下界，根值，根的上界三个数值把整个树所有node可能的取值分成两部分）
	//2.处理左子树，左子树的值必须在[根的下界，根值-1]范围内，否则false
	//3.处理右子树，右子树的值必须在[根值+1，根的上界]范围内，否则false
	//https://oj.leetcode.com/discuss/16352/java-solution-after-adding-test-cases
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	//返回值为：是否当前root的左子树都在"min"到"根值-1" 并且 当前root的右子树都在"根值+1"到max之间
    public boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        //【根】：三个方面判断root是否符合条件(3点可以可以写在同一行，但是这样看着更清晰):
        if (root.val < min || root.val > max ) { // 1.根在上下界外
            return false;
        }
        if (root.val == min && root.left != null) { // 2.如果根已经为最小值，且有左孩子
            return false;
        }
        if (root.val == max && root.right != null) { // 3.如果根已经为最大值，且有右孩子
            return false;
        }
        return helper(root.left, min, root.val - 1) && helper(root.right, root.val + 1, max); // 【左】&【右】
    }	
   
    //【注】leetcode增加了之后MAX_VALUE和MIN_VALUE的corner case，下面的code不会pass
	//http://blog.csdn.net/linhuanmars/article/details/23810735
	//http://www.ninechapter.com/solutions/validate-binary-search-tree/
	//思想：以中序遍历查看当前root的value是不是大于上一次的root的value
	public boolean isValidBST2(TreeNode root) {
		if (root == null){
			return true;
		}
		int[] preNodeVal = {Integer.MIN_VALUE};
		return helper(root, preNodeVal);
	}
	
	private boolean helper(TreeNode root, int[] preNodeVal){
		if (root == null){
			return true;
		}
		if (!helper(root.left, preNodeVal)){//【左】递归
			return false;
		}
		if(root.val <= preNodeVal[0]){//【根】比较当前root值和pre的值
			return false;
		}
		preNodeVal[0] = root.val; // 更新 preNodeVal[0];
		if (!helper(root.right, preNodeVal)){
			return false;//【右】递归
		}
		return true;//只有上面三个判断都为true，最终才能返回true。
	}
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
