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
	public ArrayList<Integer> inorderTraversalRecursive(TreeNode root) {
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
	public ArrayList<Integer> inorderTraversalIterativeIterative(TreeNode root) {
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
	
	//interative from Mo
	//之所以和preorder不同（preorder不需要保存保存node是否被访问过），是因为inorder时候，第一次经过某node时候不能当时就处理它，要等待会回来时候才能处理。
	//所以需要标记它是否被访问过。即我们需要NodeStatusPair这个class
	//【注】之所以这个算法有效，是因为我们压栈的顺序和inorder正好还是相反的，所以出栈（存入结果）时，就刚好是inorder的顺序了
	//左根右。看图（看步骤！）看【注】
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		LinkedList<NodeStatusPair> stack = new LinkedList<NodeStatusPair>(); //保存node的访问状态 
		stack.push(new NodeStatusPair(root, false));//赋初值是not ready，因为现在是第一次访问，我们要按[左右根]的顺序，要一直往左找下去。等再次回来时，再把root改为ready
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek().node;
			boolean ready = stack.peek().ready;
			stack.pop();
			if (ready) {
				result.add(node.val);
			} else {
				if (node.right != null) {
					stack.push(new NodeStatusPair(node.right, false));//先压入【右】
				}
				stack.push(new NodeStatusPair(node, true)); //再压入【根】
				if (node.left != null) {
					stack.push(new NodeStatusPair(node.left, false)); //最后压入【左】 (于是弹出的顺序就是【左根右】)
				}
			}
		}
		return result;
	}
	
	//【注】重点理解这个ready，意思是访问过了，但是还没有ready（如果还没访问的话，栈中根本就没有这个node对应的NodeStatusPair存在）
	private class NodeStatusPair {
		TreeNode node;
		boolean ready;
		NodeStatusPair(TreeNode node, boolean ready) {
			this.node = node;
			this.ready = ready;
		}
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
