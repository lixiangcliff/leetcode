package Unique_Binary_Search_Trees_II;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//http://blog.csdn.net/linhuanmars/article/details/24761437
	//http://answer.ninechapter.com/solutions/unique-binary-search-trees-ii/
    public ArrayList<TreeNode> generateTrees(int n) {
        return doGenerateTrees(1, n);
    }
    
    private ArrayList<TreeNode> doGenerateTrees(int start, int end){
    	ArrayList<TreeNode> result= new ArrayList<TreeNode>();
    	// when n == 0
    	if (start>end){
    		//why?..
    		//answer: when input is 0, output should be empty, i.e null
    		result.add(null);
    		return result;
    	}
    	for(int i=start; i<=end;i++){
    		ArrayList<TreeNode> lside = doGenerateTrees(start,i-1);
    		ArrayList<TreeNode> rside = doGenerateTrees(i+1,end);
    		for(TreeNode l:lside){
    			for(TreeNode r:rside){
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				result.add(root);
    			}
    		}
    		
    	}
    	return result;
    }
}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
 }
