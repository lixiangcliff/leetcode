package Flatten_Binary_Tree_to_Linked_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
	 * Given a binary tree, flatten it to a linked list in-place.
		For example,
		Given
		
		         1
		        / \
		       2   5
		      / \   \
		     3   4   6
		     
		The flattened tree should look like:
		
		   1
		    \
		     2
		      \
		       3
		        \
		         4
		          \
		           5
		            \
		             6
		
		Hints:
		If you notice carefully in the flattened tree, 
		each node's right child points to the next node of a pre-order traversal.
	 */
	
	//https://leetcode.com/discuss/30719/my-short-post-order-traversal-java-solution-for-share
	//上面这个，还没想懂。。。
	
	
	//1.每次将当前root为根的树切成 root, root左子树(left), root右子树(right)三部分,（先取好left和right，然后把root.left和root.right置null）
	//2.然后left接在root.right,然后递归处理left
	//3.然后right接在root.right,然后递归处理right
	//4.返回root
	// http://www.cnblogs.com/yuzhangcmu/p/4186572.html
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    // return : 返回的root表示flatten之后的最右边的node
    private TreeNode dfs(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	root.left = null; //【注】重要！这两行将root, root左子树 root右子树切成三部分
    	root.right = null;
    	if (left != null) {  // connect the left tree.
    		root.right = left;
    		root = dfs(left);
    	}
    	if (right != null) {  // connect the right tree.
    		root.right = right;
    		root = dfs(right);
    	}
    	return root;
    }
	

}

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
