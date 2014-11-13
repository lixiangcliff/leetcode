package Minimum_Depth_of_Binary_Tree;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//http://gongxuns.blogspot.com/2012/12/leetcode-minimum-depth-of-binary-tree.html
    public int minDepth(TreeNode root) {
		if (root == null){
    		return 0;
    	}
    	if(root.left == null && root.right == null){
    		return 1;
    	}if(root.left == null){
    		return 1+minDepth(root.right);
    	}if(root.right == null){
    		return 1+minDepth(root.left);
    	}
    	else{
    		return Math.min(minDepth(root.left), minDepth(root.right))+1; 
    	}
    }
    

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
