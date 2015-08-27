package Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
	 * Given a binary tree, return the postorder traversal of its nodes' values.

		For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [3,2,1].
		
		Note: Recursive solution is trivial, could you do it iteratively?
	 */
	
	//方法一
	//http://blog.csdn.net/linhuanmars/article/details/22009351
	//recursive
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	helper(root, result);
    	return result;
    }
	
    private void helper(TreeNode root, List<Integer> result){
    	if (root == null){
    		return;
    	}
    	helper(root.left, result);
    	helper(root.right,result);
    	result.add(root.val);
    }
    
    //方法二 better Smart！
	//iterative
    //http://www.cnblogs.com/yuzhangcmu/p/4172783.html
    //"从左到右的后序 与从右到左的前序的逆序是一样的，所以就简单喽！用另外一个栈进行翻转即可喽"
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
        	return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) { // 【注】此处不是 while (root != null)
        	TreeNode node = stack.pop();
        	res.add(node.val);
        	if (node.left != null) {
        		stack.push(node.left);
        	}
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        }
        Collections.reverse(res);
        return res;
    }
    
    //方法三
/*	public ArrayList<Integer> postorderTraversalIterative(TreeNode root) {
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
	}*/
	
	//方法四
	//iterative from Mo
	//类似 inorder，具体解释参考: https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
	//左右根。
/*	public ArrayList<Integer> postorderTraversalIterative2(TreeNode root) {
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
				stack.push(new NodeStatusPair(node, true)); //先压入【根】
				if (node.right != null) {
					stack.push(new NodeStatusPair(node.right, false));//再压入【右】
				}
				if (node.left != null) {
					stack.push(new NodeStatusPair(node.left, false)); //最后压入【左】 (于是弹出的顺序就是【左右根】)
				}
			}
		}
		return result;
	}*/
	
	private class NodeStatusPair {
		TreeNode node;
		boolean ready;
		NodeStatusPair(TreeNode node, boolean ready) {
			this.node = node;
			this.ready = ready;
		}
	}

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}