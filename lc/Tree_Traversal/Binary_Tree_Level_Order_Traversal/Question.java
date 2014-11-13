package Binary_Tree_Level_Order_Traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//http://answer.ninechapter.com/solutions/binary-tree-level-order-traversal/
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        //Compile Error: incompatible types from leetcode
        //ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList result = new ArrayList();
    	if(root == null){
        	return result;
        }        
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();   
        queue.add(root);
        while(!queue.isEmpty()){        	
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	int size = queue.size();
        	for (int i=0;i < size;i++){
        		TreeNode node = queue.remove();
        		level.add(node.val);
        		if(node.left != null){
            		queue.add(node.left);
            	}
            	if(node.right != null){
            		queue.add(node.right);
            	}
        	}
        	result.add(level);        	
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
