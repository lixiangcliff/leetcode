package Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/22009351
	//recursive
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	helper(root, result);
    	return result;
    }
	
    private void helper(TreeNode root, ArrayList<Integer> result){
    	if (root == null){
    		return;
    	}
    	helper(root.left, result);
    	helper(root.right,result);
    	result.add(root.val);
    }
    
	//iterative
	public ArrayList<Integer> postorderTraversalIterative(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null){
			return result;
		}
		LinkedList<TreeNode> stack =  new LinkedList<TreeNode>();
		TreeNode pre = null;//用来记录，在程序中前一个被访问的node（【住】，pre并不是后序排列顺序中的前一个node）
		while(root != null ||!stack.isEmpty()){
			if (root != null){//这个部分和inorder一样
				stack.push(root);
				root = root.left;  //【左】
			}else{//这个else里面，是针对栈顶node的右孩子的不同情况的处理
				TreeNode peekNode = stack.peek();
				//栈顶node的右孩子不为null，并且不等于前一个被访问的node（pre）（即之前还没访问过），那么就把当前node置为他的右孩子，然后继续循环。
				if (peekNode.right != null && peekNode.right != pre){
					root = peekNode.right;  //【右】
				}else{//栈顶node的右孩子为null，或者已经访问过了，那么这时应该访问自己（即【根】），然后回溯。
					stack.pop();
					result.add(peekNode.val); //【根】
					pre = peekNode;// 更新pre
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
    TreeNode(int x) { val = x; }
}