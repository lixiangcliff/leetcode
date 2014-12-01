package Binary_Tree_Preorder_Traversal;
import java.util.ArrayList;
import java.util.LinkedList;
public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
	 * Given a binary tree, return the preorder traversal of its nodes' values.

		For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [1,2,3].
		
		Note: Recursive solution is trivial, could you do it iteratively?
	 */
	//http://blog.csdn.net/linhuanmars/article/details/21428647
	//recursive way
	public ArrayList<Integer> preorderTraversalRecursive(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		helper(root, result);
		return result;
		
	}
	
	private void helper(TreeNode root, ArrayList<Integer> result){
		if (root == null){
			return;
		}
		result.add(root.val);
		helper(root.left, result);
		helper(root.right, result);
	}
	
	//iterative way
	//更多注释，参考inOrder： https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
	public static ArrayList<Integer> preorderTraversalIterative(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(root != null || !stack.isEmpty()){
        	if(root != null){
        		result.add(root.val);//【根】
        		stack.push(root);
        		root = root.left; //【左】
        	}else{
        		root = stack.pop();
        		root = root.right; //【右】
        	}
        }
        return result;
    }
	
	//interative from Mo
	//根左右。看图！
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop(); 
			result.add(node.val);//处理【根】
			if (node.right != null) {
				stack.push(node.right); //先把【右】压入栈。（为的是之后，先把【左】弹出栈来处理）
			}
			if (node.left != null) {
				stack.push(node.left); 
			}
		}
		return result;
	}
	
	

	//Morris Taversal to be continue later..
}



  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
