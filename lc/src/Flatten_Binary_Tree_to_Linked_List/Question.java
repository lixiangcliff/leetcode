package Flatten_Binary_Tree_to_Linked_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://www.cnblogs.com/feiling/p/3278639.html
    public void flatten(TreeNode root) {
        if(root == null){
        	return;
        }
        if(root.left != null){
        	TreeNode leftNode = root.left;
        	TreeNode rightNode = root.right;
        	root.left = null; // cannot be missed!
        	root.right = leftNode;
        	TreeNode p = leftNode;
        	while(p.right != null){
        		p = p.right;
        	}
        	p.right = rightNode;
        }
        flatten(root.right);
    }

}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
