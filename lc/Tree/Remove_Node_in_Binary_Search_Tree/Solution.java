package Remove_Node_in_Binary_Search_Tree;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
    	if (root == null) { //根为null， 返回null
    		return root;
    	} else if (value < root.val) { //要remove的值比root小，则其一定在root的左子树
    		root.left = removeNode(root.left, value);
    	} else if (value > root.val) { //要remove的值比root大，则其一定在root的右子树
    		root.right = removeNode(root.right, value);
    	} else {	//当前root即为要remove的node
    		if (root.left == null && root.right == null) { //root没有孩子，将其置null
    			root = null;
    		} else if (root.left == null) { //只有右孩子，用其右孩子替换root的位置
    			root = root.right;
    		} else if (root.right == null) { //只有左孩子，用其左孩子替换root的位置
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
    	if (root == null) {
    		return root;
    	} else if (root.left == null) {
    		return root;
    	} else {
    		while (root.left != null) {
    			root = root.left;
    		}
    		return root;
    	}
    	//上下两种方法等价，上面清晰，下面简洁。推荐上面
    	/*while (root != null && root.left != null) {
    		root = root.left;
    	}
    	return root;
    	*/
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