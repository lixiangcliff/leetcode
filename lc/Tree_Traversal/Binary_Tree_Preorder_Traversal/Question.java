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
	
	//http://blog.csdn.net/linhuanmars/article/details/21428647
	//recursive way
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
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

	//Morris Taversal to be continue later..
}



  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
