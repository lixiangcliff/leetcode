package Binary_Tree_Maximum_Path_Sum;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/22969069
    public int maxPathSum(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(Integer.MIN_VALUE);
        helper(root, result);
        return result.get(0);
    }
    
    private int helper(TreeNode root, ArrayList<Integer> result){
    	if(root == null){
    		return 0;
    	}
    	int left = helper(root.left, result);
    	int right = helper(root.right, result);
    	int cur = root.val + (left>0?left:0) + (right>0?right:0);
    	if(cur>result.get(0)){
    		result.set(0, cur);
    	}
    	// Math.max(cur, Math.max(left, right)); //wrong!
    	// return current node value + one of branches(left, right, 0(when left<0 && right<0))
    	return root.val+(Math.max(left, Math.max(right, 0)));
    }

}

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
