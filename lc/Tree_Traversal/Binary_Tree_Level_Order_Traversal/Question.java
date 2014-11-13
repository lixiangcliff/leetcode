package Binary_Tree_Level_Order_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/23404111
	//类似此题的iterative way：https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null){
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int curNum = 1;
		int nextNum = 0;
		queue.offer(root);
		ArrayList<Integer> item = new ArrayList<Integer>();
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			item.add(node.val);
			curNum--;
			if (node.left != null){
				queue.offer(node.left);
				nextNum++;
			}
			if (node.right != null){
				queue.offer(node.right);
				nextNum++;
			}
			if (curNum == 0){
				curNum = nextNum;
				nextNum = 0;
				result.add(item);
				//item.clear();【注】，这样写错误！原因问问老师。
				item = new ArrayList<Integer>();
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
