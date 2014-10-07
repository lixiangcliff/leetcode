package Symmetric_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isSymmetric(TreeNode root) {
    	if(root == null){
    		return true;
    	}
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode l, TreeNode r) {
    	if (l == null && r == null){
    		return true;
    	}
    	if (l ==null || r == null){
    		return false;
    	}
        return (l.val == r.val) && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
    
    

}
 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
