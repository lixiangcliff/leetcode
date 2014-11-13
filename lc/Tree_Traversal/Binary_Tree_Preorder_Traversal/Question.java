package Binary_Tree_Preorder_Traversal;
import java.util.Stack;
import java.util.ArrayList;
public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> preorder = new ArrayList<Integer>();
        
        if (root == null) {
            return preorder;
        }       
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop(); // we need to keep this node!!!
            preorder.add(node.val);    
            if (node.right != null) {
                stack.push(node.right);  // here is why we need to keep it. and we need to push right before left!
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preorder;
    }

}



  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
