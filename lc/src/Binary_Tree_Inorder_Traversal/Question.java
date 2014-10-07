package Binary_Tree_Inorder_Traversal;

import java.util.Stack;
import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//recursion
	/*public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		inorder(root,result);
        return result;
    }
	private void inorder(TreeNode root, ArrayList<Integer> result){
		if (root == null){
			return;
		}
		inorder(root.left, result);
		result.add(root.val);
		inorder(root.right, result);
	}*/
	
	//Iterative
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root==null){
			return result;
		}
		stack.push(root);
		while(!stack.empty()){
			TreeNode node = stack.pop();			
			if(node.right !=null){
				stack.push(node);
			}
			result.add(node.val);
			if(node.left !=null){
				stack.push(node);
			}
			
		}
		
		return result;
	}
	

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
