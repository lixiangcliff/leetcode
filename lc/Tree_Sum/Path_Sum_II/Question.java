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
    	ArrayList<Integer> item = new ArrayList<Integer>();
    	//helper(root, sum-root.val, item, result);
    	item.add(root.val);//为什么要先把root加进去？为什么上面的只一行的方法不行？
    	helper(root, sum-root.val, item, result);
    	return result;
    }
    
    private void helper(TreeNode root, int sum, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
        if(root == null){
     	   return;
        }
        if(root.left == null && root.right == null && sum == 0){
            result.add(new ArrayList<Integer>(item));
     	    return;
        }
        if (root.left != null){
        	item.add(root.left.val);
        	helper(root.left, sum-root.left.val, item, result);
        	item.remove(item.size()-1);//恢复recursion之前的state
        }
        if (root.right != null){
        	item.add(root.right.val);
        	helper(root.right, sum-root.right.val, item, result);
        	item.remove(item.size()-1);
        }        
    }
    
    

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}