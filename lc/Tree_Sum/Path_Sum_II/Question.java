package Path_Sum_II;

import java.util.ArrayList;



public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//http://blog.csdn.net/linhuanmars/article/details/23655413
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (root == null){
    		return result;
    	}
    	ArrayList<Integer> onePath = new ArrayList<Integer>();
    	onePath.add(root.val);
    	helper(root, sum-root.val, onePath, result);
    	return result;
    }
    
    private void helper(TreeNode root, int sum, ArrayList<Integer> onePath, ArrayList<ArrayList<Integer>> result) {
        if(root == null){
     	   return;
        }
        if(root.left == null && root.right == null && sum == 0){
            result.add(new ArrayList<Integer>(onePath));
     	    return;
        }
        if (root.left != null){
        	onePath.add(root.left.val);
        	helper(root.left, sum-root.left.val, onePath, result);
        	onePath.remove(onePath.size()-1);
        }
        if (root.right != null){
        	onePath.add(root.right.val);
        	helper(root.right, sum-root.right.val, onePath, result);
        	onePath.remove(onePath.size()-1);
        }        
    }
    
    

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}