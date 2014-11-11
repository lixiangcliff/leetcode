package Balanced_Binary_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//from cracking code 5th edition Quesetion 4.1
	public int getHeight(TreeNode root){
		if (root==null){
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
    public boolean isBalanced(TreeNode root) {
    	if(root==null){
    		return true;
    	}
    	int heightDiff = Math.abs(getHeight(root.left)-getHeight(root.right));
    	return heightDiff<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
