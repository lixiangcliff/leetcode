package Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.HashMap;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24389549
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder ==null || inorder == null){
    		return null;
    	}
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<inorder.length;i++){
        	map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);

        
    }
    private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
    	if (preL > preR || inL > inR){
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[preL]);
    	int index = map.get(root.val);
    	root.left = helper(preorder, preL+1, index-inL+preL, inorder, inL, index-1, map);//all children on left sub tree of root
    	root.right = helper(preorder, index-inL+preL+1, preR, inorder, index+1, inR, map);//all children on left sub tree of root
    	return root;
    }

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }
