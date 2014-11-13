package Convert_Sorted_List_to_Binary_Search_Tree;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//bottom to top:
	/*
	 * 	1. construct the left tree 
		2. construct the root node, list pointer +1.
		3. construct the right node
	 */
	//http://blog.csdn.net/linhuanmars/article/details/23904937
	//http://joycelearning.blogspot.com/2013/09/leetcode-convert-sorted-list-to-binary.html
	//http://yucoding.blogspot.com/2012/12/leetcode-question-24-convert-sorted.html
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
        	return null;
        }
        int count = 0;
        ListNode runner = head;
        while(runner != null){
        	runner = runner.next;
        	count++;
        }
        
        //the reason why create a ArrayList<ListNode> is because:
        //it will be immutable in helper function
        ArrayList<ListNode> sortedlist = new ArrayList<ListNode>();
        sortedlist.add(head);
        //return helper(sortedlist, 0, count); wrong!
        return helper(sortedlist, 0, count-1);
    }
    
    private TreeNode helper(ArrayList<ListNode> sortedlist, int l, int r){
    	if(l > r){
    		return null;
    	}
    	int m = (l+r)/2;
    	// get left;
    	TreeNode left = helper(sortedlist, l, m-1);
    	// get root use current listnode val
    	TreeNode root = new TreeNode(sortedlist.get(0).val);
    	root.left = left;
    	//move to next listnode to get value for right
    	sortedlist.set(0, sortedlist.get(0).next);
    	//get right
    	TreeNode right = helper(sortedlist, m+1, r);
    	root.right = right;
    	return root;
    }

}


 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; next = null; }
 }


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }