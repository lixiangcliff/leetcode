package Binary_Tree_Level_Order_Traversal_II;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/23414711
	//类似：https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null){
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		int curNum = 1;
		int nextNum = 0;
		queue.offer(root);
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
				item = new ArrayList<Integer>();
			}
		}
		Collections.reverse(result);
		return result;
	}
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }