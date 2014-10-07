package Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.Stack;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		System.out.println(result.size());

	}
	//Similar to "Binary Tree Level Order Traversal"
	//https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
	//http://blog.csdn.net/linhuanmars/article/details/24509105
	//need to use stack instead of queue
	//http://answer.ninechapter.com/solutions/binary-tree-zigzag-level-order-traversal/
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(root == null){
    		return result;
    	}
    	
    	Stack<TreeNode> currentLevel = new Stack<TreeNode>();
    	Stack<TreeNode> nextLevel = new Stack<TreeNode>();
    	Stack<TreeNode> temp;
    	currentLevel.push(root);
    	boolean normalOrder = true;
    	while(!currentLevel.isEmpty()){
    		ArrayList<Integer> oneLine = new ArrayList<Integer>();
    		/*int size = currentLevel.size();
    		for (int i=0;i<size;i++){*/			// the same as "while" loop below
    		while(!currentLevel.isEmpty()){
    			TreeNode node = currentLevel.pop();
        		oneLine.add(node.val);
	    		if(normalOrder){
	    			if(node.left != null){
	    				nextLevel.push(node.left);
	    			}
	    			if(node.right != null){
	    				nextLevel.push(node.right);
	    			}
	    		}else{
	    			if(node.right != null){
	    				nextLevel.push(node.right);
	    			}
	    			if(node.left != null){
	    				nextLevel.push(node.left);
	    			}
	    		}
    		}
    		temp = currentLevel;
    		currentLevel = nextLevel;
    		nextLevel = temp;
    		//do not forget!!!
    		normalOrder = !normalOrder;
    		result.add(oneLine);
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