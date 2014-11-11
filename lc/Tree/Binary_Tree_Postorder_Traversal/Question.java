package Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.Stack;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//recursive
   /* public ArrayList<Integer> postorderTraversal(TreeNode root) {
       // ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> result;
        result = new ArrayList<Integer>();
        doPostorderTraversal(result, root);
        return result;
    }
    
    private void doPostorderTraversal(ArrayList<Integer> result, TreeNode root) {
        if(root == null){
        	return;
        }
        doPostorderTraversal(result, root.left);
        doPostorderTraversal(result, root.right);
        result.add(root.val);
    }*/
	
	//iterative;
	//wrong answer!!!
	/*public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null){
			return postOrder;
		}
		stack.push(root);
		while(!stack.empty()){
			TreeNode node = stack.pop();
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
			postOrder.add(node.val);
		}		
		return postOrder;
	}*/

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}