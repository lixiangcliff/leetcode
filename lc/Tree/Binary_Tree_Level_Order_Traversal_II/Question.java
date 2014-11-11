package Binary_Tree_Level_Order_Traversal_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        if(root == null){
        	return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        Stack stack = new Stack();
        queue.add(root);
        while(!queue.isEmpty()){
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	int size = queue.size();
        	for(int i=0; i< size; i++){
        		TreeNode node = queue.remove();
            	level.add(node.val);
            	if( node.left != null){
            		queue.push(node);
            	}
            	if( node.right != null){
            		queue.push(node);
            	}            	
        	}
        	stack.push(level);        	
        }
        while(!stack.isEmpty()){
        	result.add(stack.pop());
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