package Balanced_Binary_Tree;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//http://blog.csdn.net/linhuanmars/article/details/23731355
    public boolean isBalanced(TreeNode root) {
    	if(root==null){
    		return true;
    	}
    	return helper(root)>=0;
    }
    
    private int helper(TreeNode root){
		if (root==null){
			return 0;
		}
		int leftH = helper(root.left);//左子树高度
		int rightH = helper(root.right);//右子树高度
		if (leftH < 0 || rightH < 0){//任何一个子树<0，则返回-1（-1表示已经失去平衡）
			return -1;
		}
		if(Math.abs(leftH-rightH) > 1){//表示左右子树高度相差>1
			return -1;
		}
		//返回树的高度（左右子树高的那个+1）
		return (Math.max(leftH, rightH) + 1);
	}
	

}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
