package Validate_Binary_Search_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//my way
	//wrong!! because fail to check whether current node is less than previous node..
    /*public boolean isValidBST(TreeNode root) {
    	if (root == null){
    		return true;
    	}
    	return helper(root);
    }
    
    private boolean helper(TreeNode root){
    	if(root == null){
    		return true;
    	}
    	if(root.left != null){
    		if (root.left.val >= root.val){
    			return false;
    		}
    	}
    	if(root.right != null){
    		if (root.right.val <= root.val){
    			return false;
    		}
    	}
    	return helper(root.left) && helper(root.right);
    }*/
	
	//http://blog.csdn.net/linhuanmars/article/details/23810735
	public boolean isValidBST(TreeNode root) {
		if (root == null){
			return true;
		}
		int[] preNodeVal = {Integer.MIN_VALUE};
		return helper(root, preNodeVal);
	}
	
	private boolean helper(TreeNode root, int[] preNodeVal){
		if (root == null){
			return true;
		}
		//check whether inorder traverse will keep the increase trend
		boolean left = helper(root.left, preNodeVal);
		if(root.val <= preNodeVal[0]){
			return false;
		}
		preNodeVal[0] = root.val; // new preNodeVal[0], check it for right case;
		return left && helper(root.right, preNodeVal);
	}
    

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
