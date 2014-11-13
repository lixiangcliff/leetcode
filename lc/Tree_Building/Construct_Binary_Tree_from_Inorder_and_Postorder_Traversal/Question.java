package Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.HashMap;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24390157
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
        	return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length;i++){
        	map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
        
    }
    
    private TreeNode helper(int[] postorder, int postL, int postR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
    	//cannot be missed!!!
    	if(postL>postR || inL>inR){
    		return null;
    	}
    	int index = map.get(postorder[postR]);
    	TreeNode root = new TreeNode(postorder[postR]);
    	root.left = helper(postorder, postL, postL-1+index-inL, inorder, inL, index-1, map); //  new postL or postR should has some relationship 
    	root.right = helper(postorder, postR-inR+index, postR-1, inorder, index+1, inR, map); // with previous postL or postR
    	return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }
}
