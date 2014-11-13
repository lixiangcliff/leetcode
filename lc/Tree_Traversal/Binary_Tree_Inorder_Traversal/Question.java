package Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//http://blog.csdn.net/linhuanmars/article/details/20187257
	//recursion
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		helper(root,result);
        return result;
    }
	private void helper(TreeNode root, ArrayList<Integer> result){
		if (root == null){
			return;
		}
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}
	
	//Iterative
	//this is easier for understanding than linhuan's
	public ArrayList<Integer> inorderTraversalIterative(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if (root==null){
			return result;
		}
		
		//看图！网上图解： http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
		//关于循环条件：最开始时stack为空，但是root不为null；之后在所有node处理完之前stack始终不为空，即使有时候root为null，循环一直能进行下去，直到处理完所有node。
		while(root != null || !stack.isEmpty()){//【注】下面的注释里用node来说明，因为root这里只是一个变量名，对所有非root的任何node下面的逻辑关系都适用
			if(root!=null){//只要node不为null，就做下面两件事：
				stack.push(root); //1.把每次的node压入栈
				root = root.left; //2.node被置为它的左孩子，直到最底（即直到它的左孩子为null）【左】
			}else{                 //当node已经没有左孩子了
				root = stack.pop(); //当前node指向 被弹出栈的那个node
				result.add(root.val);//处理当前node（所有对node的操作都该在这一步执行，比如print，比如存入ArrayList，等等）【根】
				root = root.right;  //node被置为它的右孩子【右】
			}
		}
		return result;
	}
	
	//Morris Traversal下一轮再说...
	//http://blog.csdn.net/linhuanmars/article/details/20187257
	//http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
	

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
