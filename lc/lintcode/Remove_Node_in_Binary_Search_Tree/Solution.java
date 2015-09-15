package Remove_Node_in_Binary_Search_Tree;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * http://lintcode.com/en/problem/remove-node-in-binary-search-tree/
	 * Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. 
	 * If there is no such a node with given value in the binary search tree, do nothing. 
	 * You should keep the tree still a binary search tree after removal.
		Example
		Given binary search tree:
		         5
		        / \
		       3   6
		      / \
		     2   4
		     
		Remove 3, you can either return:
		         5
		        / \
		       2   6
		        \
		         4
		or :
		         5
		        / \
		       4   6
		      / 
		     2   
	 */
	
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
	
    public TreeNode removeNode(TreeNode root, int value) {
    	if (root == null) { //根为null， 返回null
    		return root;
    	} else if (value < root.val) { //【左】要remove的值比root小，则其一定在root的左子树
    		root.left = removeNode(root.left, value);
    	} else if (value > root.val) { //【右】要remove的值比root大，则其一定在root的右子树
    		root.right = removeNode(root.right, value);
    	} else {	//【根】当前root即为要remove的node
    		if (root.left == null && root.right == null) { //root没有孩子，则将其置null
    			root = null;
    		} else if (root.left == null) { // root指向root.right，剔除root处的node 【注】把它想象成linkedlist，就容易懂了。
    			root = root.right;
    		} else if (root.right == null) { 
    			root = root.left;
    		} else {	//两个孩子都有，则在其右子树中找到最小值，并用最小值替换该root值，最后remove该最小值的node
    			TreeNode temp = findMin(root.right);
    			root.val = temp.val;
    			root.right = removeNode(root.right, temp.val);
    		}
    	}
    	return root;
    }
    
    //返回以root为根的值最小的node
    private TreeNode findMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
    }

}

 class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
    }
 }