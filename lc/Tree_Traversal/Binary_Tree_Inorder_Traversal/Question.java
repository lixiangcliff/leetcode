package Binary_Tree_Inorder_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
	 * Given a binary tree, return the inorder traversal of its nodes' values.
		
		For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [1,3,2].
		
		Note: Recursive solution is trivial, could you do it iteratively?
	 */
	//方法一
	//http://blog.csdn.net/linhuanmars/article/details/20187257
	//recursion
	public List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		helper(root, result);
		return result;
	}

	private void helper(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		helper(root.left, result);
		result.add(root.val);
		helper(root.right, result);
	}
	
	//方法二 better
	//Iterative
	//http://www.cnblogs.com/yuzhangcmu/p/4141585.html
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList<TreeNode>();
        TreeNode node = root; //【注】重点是一定要在循环中传递node，所以要在循环外定义node
        while (true) {
            while (node != null) { //找到当前node的最左孩子，并且将node的所有左孩子及其下一级左孩子加入栈。
                s.push(node);
                node = node.left; //【左】一直找最左的
            }
            if (s.isEmpty()) { // 要在添加所有左孩子入栈之后，再判断栈是否为空。是因为最初栈一定是空的。
                break;
            }
            node = s.pop(); // 每次pop出来的就是当前node作为左孩子时，对应的【根】
            res.add(node.val); // 【注】result内容都是来自每次stack弹出的node
            node = node.right; // 【右】最后当前node往它的右子树走，去处理它的右孩子
        }
        return res;
    }
	
	
	//方法三
	//interative from Mo
	//之所以和preorder不同（preorder不需要保存node是否被访问过），是因为inorder时候，第一次经过某node时候不能当时就处理它，要等待会回来时候才能处理。
	//所以需要标记它是否被访问过。即我们需要NodeStatusPair这个class
	//【注】之所以这个算法有效，是因为我们压栈的顺序和inorder正好还是相反的，所以出栈（存入结果）时，就刚好是inorder的顺序了
	//左根右。看图（看步骤！）看【注】
/*	public ArrayList<Integer> inorderTraversal(TreeNode root) {
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
	}*/
	
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
